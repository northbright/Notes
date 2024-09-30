# Handle File Upload

## Nginx Configuration(Optional)
Nginx limits request body size to 1M by default.
If use Nginx as reverse proxy for a Go App, make sure to set `"client_max_body_size"` in "nginx.conf".

```bash
vi /etc/nginx/nginx.conf
```

```
http {
        ##
        # Basic Settings
        ##

        ......

        client_max_body_size 100M;
}

```

## Example Code

```go
const (
  // Max upload file fize.
  // Make sure to set "client_max_body_size" in "nginx.conf"
  // if Nginx is used as reverse proxy.
  MAX_UPLOAD_SIZE = 1024 * 1024 * 10
)

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

## References
* [How to process file uploads in Go](https://freshman.tech/file-upload-golang/)
* [Uploading and downloading files using multipart/form-data](https://www.sobyte.net/post/2022-03/go-multipart-form-data/)
