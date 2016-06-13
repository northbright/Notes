# Golang Client of alidayu(阿里大鱼)

<https://github.com/northbright/alidayu> is a Golang SDK for [alidayu(阿里大鱼)](https://www.alidayu.com/).

#### Example

        // Create a new client(创建一个新的Client实例).
        c := &alidayu.Client{AppKey: "", AppSecret: "", UseHTTPS: false}

        // ---------------------------------------
        // Send Verification Code in SMS(发送短信验证码).
        // ---------------------------------------
        // Set Parameters.
        params := map[string]string{}
        // It'll use default common parameters if you don't set them.
        // 如果这些公共参数不设置，那么会自动使用默认值.
        // params["format"] = "json"
        // params["v"] = "2.0"
        // params["sign_method"] = "md5"
        params["method"] = "alibaba.aliqin.fc.sms.num.send"           // Set method to send SMS(API接口名称).
        params["sms_type"] = "normal"                                 // Set SMS type(短信类型).
        params["sms_free_sign_name"] = ""                             // Set SMS signature(短信签名).
        params["sms_param"] = `{"code":"123456", "product":"My App"}` // Set variable for SMS template(短信模板变量).
        params["sms_template_code"] = ""                              // Set SMS template code(短信模板ID).
        params["rec_num"] = ""                                        // Set phone number to send SMS(短信接收号码).

        // Call Exec() to post the request.
        success, result, err := c.Exec(params)
        if err != nil {
                fmt.Fprintf(os.Stderr, "c.Exec() error: %v\nsuccess: %v\nresult: %v\n", err, success, result)
                return
        }

        fmt.Fprintf(os.Stderr, "c.Exec() successfully\nsuccess: %v\nresult: %s\n", success, result)

        // ------------------------------------------
        // Send Verification Code in Single Call(发送文本转语音通知验证码).
        // ------------------------------------------
        // Set Parameters.
        params = map[string]string{}
        params["method"] = "alibaba.aliqin.fc.tts.num.singlecall"     // Set method to make single call(API接口名称).
        params["tts_param"] = `{"code":"123456", "product":"My App"}` // Set variable for TTS template(文本转语音（TTS）模板变量).
        params["called_num"] = ""                                     // Set phone number to make single call(被叫号码).
        params["called_show_num"] = ""                                // Set show number(被叫号显).
        params["tts_code"] = ""                                       // Set TTS code(TTS模板ID).

        // Call Exec() to post the request.
        success, result, err = c.Exec(params)
        if err != nil {
                fmt.Fprintf(os.Stderr, "c.Exec() error: %v\nsuccess: %v\nresult: %v\n", err, success, result)
                return
        }

        fmt.Fprintf(os.Stderr, "c.Exec() successfully\nsuccess: %v\nresult: %s\n", success, result)

#### References
* [alidayu](https://github.com/northbright/alidayu)
* [alidayu API](https://api.alidayu.com)
