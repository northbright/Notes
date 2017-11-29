# Call `JSON.stringify(obj)` to Get String as POST data for AJAX

#### Problem
* We post JSON object via AJAX to API server which is written in [Golang](https://golang.org).
* The Golang API server use "encoding/json" to unmarshall the JSON obect to struct.
* It reports error when post some JSON object directly in $.ajax():

        invalid character 'a' in literal null (expecting 'u' 

#### Solution
* Use string as post data.
* Call JSON.stringify(obj) to convert obj to string.

#### Example
    var postData = {a:"",b:""};

    $.ajax({
      type: "POST",
      url: url,
      data: JSON.stringify(postData),
      success: success,
      dataType: dataType
    });
