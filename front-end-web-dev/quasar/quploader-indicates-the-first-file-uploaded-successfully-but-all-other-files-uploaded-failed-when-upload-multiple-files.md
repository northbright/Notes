# QUploader Indicates the First File Uploaded Successfully But All Other Files Uploaded Failed when Upload Multiple Files

## Problem
* Quasar SPA
* Put a QUploader in a QDialog
* Set "multiple" behavior without "batch" prop.
* Upload image files to "/upload" of a Golang server
* Golang server get all requests one by one and save the files on the disk and set status to 200 OK and returns JSON data correctly.
* In browser debug mode, it also shows the network requests / responses are OK
* But QUploader calls @uploaded for the first file but calls @failed for the next files
* The @failed callback function, the paramerter: info.xhr.status is 0
* If use "batch" upload prop, all files are uploaded successfully in one request.

## Root Cause
In @uploaded callback, it closes the QDialog(e.g. showDialog = false).
So the QUploader was destroyed after the first file was uploaded successfully.

## Solution
* Do not do close the container of QUploader in @uploaded or @failed or other event callbacks.
