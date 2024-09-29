# Use QUploader to Upload Multiple Files to a Golang Server

## Problem
* Quasar SPA
* Need to upload multiple images to a Go server

## Quasar SPA Code

```vue
<q-dialog v-model="showUploadDialog">
  <q-card>
    <q-card-actions align="center">
      <q-uploader
        url="/upload"
        multiple
	    accept=".jpg"
        @failed="onUploadFailed"
	    @uploaded="onUploadOK"
	    color="teal"
      />
    </q-card-actions>
  </q-card>
</q-dialog>

const onUploadFailed = (info) => {
  console.log(`failed to upload. info.xhr.status: ${info.xhr.status}`)
  console.log(`response text: ${info.xhr.responseText}`)
}   
    
const onUploadOK = (info) => {
  console.log(`image uploaded OK: ${info.xhr.responseText}`)
  $q.notify({
    message: `图片上传成功!`
  })  
}  

```

You may set the "batch" prop for QUploader to make all files uploaded in one request.

## Go Server Code

```go
func uploadHandler(w http.ResponseWriter, r *http.Request) {
	type Response struct {
		Success       bool     `json:"success"`
		ErrMsg        string   `json:"err_msg,omitempty"`
		UploadedFiles []string `json:"uploaded_files"`
	}

	var (
		e             error
		uploadedFiles []string = []string{}
	)

	defer func() {
		resp := Response{}

		if e == nil {
			resp.Success = true
		} else {
			resp.Success = false
			resp.ErrMsg = e.Error()
			log.Printf("uploadHandler(): error: %v", e)

			w.WriteHeader(http.StatusBadRequest)
		}

		resp.UploadedFiles = uploadedFiles

		w.Header().Set("Content-Type", "application/json")

		enc := json.NewEncoder(w)
		enc.SetIndent("", "    ")
		if e = enc.Encode(&resp); e != nil {
			return
		}

		log.Printf("uploadHandler() OK")
	}()

	// Get cookie.
	c, err := r.Cookie("token")
	if err != nil {
		if err == http.ErrNoCookie {
			w.WriteHeader(http.StatusUnauthorized)
			e = fmt.Errorf("unauthorized")
			return
		} else {
			w.WriteHeader(http.StatusBadRequest)
			e = fmt.Errorf("r.Cookie() error: %v", err)
			return
		}
	}
	log.Printf("token in cookie: %v", c.Value)

	// Check HTTP method.
	if r.Method != "POST" {
		e = fmt.Errorf("uploadHandler: HTTP method is NOT POST(%v)", r.Method)
		return
	}

	// Update r.Body with a MaxByteReader to limit the size to read from upload file.
	r.Body = http.MaxBytesReader(w, r.Body, MAX_UPLOAD_SIZE)
	defer r.Body.Close()

	// Parse multiple part form of request.
	if err = r.ParseMultipartForm(MAX_UPLOAD_SIZE); err != nil {
		e = fmt.Errorf("r.ParseMultipartForm(MAX_UPLOAD_SIZE) error: %v", err)
		return
	}

	for k, _ := range r.MultipartForm.File {
		log.Printf("k: %v", k)

		srcFile, fileHeader, err := r.FormFile(k)
		if err != nil {
			e = fmt.Errorf("r.FormFile() error: %v", err)
			return
		}
		defer srcFile.Close()

		// Read first 512 bytes to a buffer.
		buf := make([]byte, 512)
		_, err = srcFile.Read(buf)
		if err != nil {
			e = fmt.Errorf("file.Read() error: %v", err)
			return
		}

		// Get the MIME type from the buffer.
		fileType := http.DetectContentType(buf)
		if fileType != "image/jpeg" && fileType != "image/png" && fileType != "image/webp" {
			e = fmt.Errorf("file type is not jpeg, png or webp")
			return
		}

		log.Printf("file type: %v", fileType)

		// Set pointer to the start of the file.
		if _, err := srcFile.Seek(0, io.SeekStart); err != nil {
			e = fmt.Errorf("io.Seek() error: %v", err)
			return
		}

		log.Printf("fileHeader.Filename: %v", fileHeader.Filename)

		// Make dst file name with lower case file name extension.
		base := fmt.Sprintf("%s.jpg", code)
		dst := filepath.Join(uploadImgDir, base)
		dstFile, err := os.OpenFile(dst, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
		if err != nil {
			e = fmt.Errorf("os.OpenFile() error: %v", err)
			return
		}
		defer dstFile.Close()

		// Save file to disk via IO copy.
		n, err := io.Copy(dstFile, srcFile)
		if err != nil {
			e = fmt.Errorf("io.Copy() error: %v", err)
			return
		}
		log.Printf("io.Copy() OK, %v bytes copied\nfile: %v saved to disk OK", n, fileHeader.Filename)

		if err := db.UpdateRecordFromImg(dst); err != nil {
			e = fmt.Errorf("db.UpdateRecordFromImg() error: %v", err)
			return
		}
		log.Printf("db.UpdateRecordFromImg() OK, file: %v", dst)
		uploadedFiles = append(uploadedFiles, base)
	}
	e = nil
}

```
