# Use upload-artifact Action to Store Data from a Workflow

## Problem
* Compiled a Tex File into a PDF in a Github Action Workflow
* Need to Store and Download the PDF

## Solution
Use [upload-artifact](https://github.com/actions/upload-artifact) to upload(store) the PDF(artifact).

It'll compress the selected files / dir into a zip file and upload it.
The zip file can be found in the workflow run > "Artifacts".

## Example

```yml
    - name: Upload the Compiled PDF
      uses: actions/upload-artifact@v4
      with:
        name: my_book # the file name without extension
        path: my_book.pdf
```

## References
* [upload-artifact](https://github.com/actions/upload-artifact)
* [latex-action](https://github.com/xu-cheng/latex-action)
* [Storing and sharing data from a workflow](https://docs.github.com/en/actions/writing-workflows/choosing-what-your-workflow-does/storing-and-sharing-data-from-a-workflow)

