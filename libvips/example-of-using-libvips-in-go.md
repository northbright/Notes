# Example of Using [libvips](https://www.libvips.org/) in Go

## About [libvips](https://www.libvips.org/)
* A demand-driven, horizontally threaded image processing library
* Written in C / C++

## Example
[picsum-photos](https://github.com/DMarby/picsum-photos) source code shows how to call [libvips](https://www.libvips.org/) functions in Golang.

* [internal/vips/](https://github.com/DMarby/picsum-photos/tree/main/internal/vips)

* It uses [vips_thumbnail_buffer](https://github.com/libvips/libvips/blob/8.13/libvips/resample/thumbnail.c#L1486) in [resize_image](https://github.com/DMarby/picsum-photos/blob/main/internal/vips/vips-bridge.c#L19)

* It calls [vips_jpegsave_buffer](https://github.com/libvips/libvips/blob/8.13/libvips/foreign/jpegsave.c#L730) in [save_image_to_jpeg_buffer](https://github.com/DMarby/picsum-photos/blob/main/internal/vips/vips-bridge.c#L11) and [vips_webpsave_buffer](https://github.com/libvips/libvips/blob/8.13/libvips/foreign/webpsave.c#L652) in [save_image_to_webp_buffer](https://github.com/DMarby/picsum-photos/blob/main/internal/vips/vips-bridge.c#L15)

* See `resizeImage()`, `grayScale()`, `blur()`, `setUserComment()`, `saveToJpegBuffer()` and `saveToWebPBuffer()` in [internal/image/vips/image.go](https://github.com/DMarby/picsum-photos/blob/main/internal/image/vips/image.go)

