# Using a Data JSON File for a Web App Built with Quasar and Golang

## Problem
* A web App built with Quasar as frontend and Golang HTTP server as backend
* Need to distribute a data JSON file
  * The data JSON can be modified after Quasar SPA is built
  * The Quasar SPA requests the JSON data via ajax(e.g. `axios`)

## Solution
* Use Golang HTTP static file server.
* Put a data JSON file under Quasar project's static assets dir: "/public"
  * Example: `/public/bk_imgs.json`

    ```json
    {
      "bk_imgs": [
        {
          "url": "img/bk-landscape-01.jpg",
          "ratio": 1.365,
          "qimg_width": "40vw",
          "qimg_height": "53vh"
        },
        {
          "url": "img/bk-square.jpg",
          "ratio": 1,
          "qimg_width": "38vw",
          "qimg_height": "68vh"
        },
        {
          "url": "img/bk-portrait-01.jpg",
          "ratio": 0.763,
          "qimg_width": "32vw",
          "qimg_height": "86vh"
        }
      ]
    }
    ```
* The JSON filei will be copied to "dist/spa"(e.g. `dist/spa/bk_imgs.json`
* It can be accessed by the URL: `"http://xx:xx/bk_imgs.json"`
* In the Quasar SPA code, use ajax to get the JSON file.

  ```js
  const bkImgs = ref([])

  const updateBkImgData = () => {
    axios
      .get("/bk_img_data.json")
      .then((response) => {
        bkImgs.value = response.data.bk_imgs
      })
      .catch((e) => {
        var errMsg = "/bk_img_data.json axios error: " + e
        $q.notify(errMsg)
      })
  } 
  ```
* We can modify the JSON file and refresh the SPA to make ajax get the updated data in the JSON file.

## References
* [App Handling Assets](https://quasar.dev/quasar-cli-webpack/handling-assets/)
