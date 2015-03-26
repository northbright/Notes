
# Integrate iflytek SDK to Implement Chinese Voice Recognition in AOSP

## Part I: Preparation

1. Register an account on <http://open.voicecloud.cn>

2. Create an app in your account and get the `app id`.

3. Download iflytek's Android SDK

4. Copy `Msc.jar` and `libmsc.so` from SDK's `SpeechDemo` to the project folder:  

        /libs/Msc.jar
        /libs/armeabi/libmsc.so
        /libs/armeabi-v7a/libmsc.so

5. Copy `assets` folder from SDK's `SpeechDemo` to the project folder:

        /assets

6. Copy `JsonParser.java` from SDK's `SpeechDemo` to the project folder:

        src/com/iflytek/speech/util/JsonParser.java

        // Import JosnParser in Your Activity:
        import com.iflytek.speech.util.JsonParser;

7. Write `proguard.flags` to keep classes of `Msc.jar`:  

        -keep class com.iflytek.**{*;}

        -verbose


8. Modify `Android.mk`:  

        LOCAL_PATH := $(call my-dir)

        # libmsc library
        include $(CLEAR_VARS)
        LOCAL_MODULE := libmsc
        LOCAL_SRC_FILES := libs/armeabi-v7a/libmsc.so
        LOCAL_MODULE_TAGS := optional
        LOCAL_MODULE_SUFFIX := .so
        LOCAL_MODULE_CLASS := SHARED_LIBRARIES
        include $(BUILD_PREBUILT)

        # VoiceTest
        include $(CLEAR_VARS)
        LOCAL_MODULE_TAGS := optional

        LOCAL_STATIC_JAVA_LIBRARIES := android-support-v4 Msc

        LOCAL_REQUIRED_MODULES := \
            libmsc

        LOCAL_SRC_FILES := $(call all-java-files-under, src)

        LOCAL_PACKAGE_NAME := VoiceTest
        LOCAL_CERTIFICATE := platform

        LOCAL_PROGUARD_FLAG_FILES := proguard.flags

        include $(BUILD_PACKAGE)

        ##################################################
        include $(CLEAR_VARS)

        LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := Msc:libs/Msc.jar

        include $(BUILD_MULTI_PREBUILT)

        include $(call all-makefiles-under,$(LOCAL_PATH))

9. iflytek SDK uses port: 1028 to connect server.  
   Make sure it's not blocked in your network or you'll get network error.

## Part II: Write a Sample App(VoiceTest)

1. Create `src/com/android/voicetest/TestApp.java` to call `SpeechUtility.createUtility()` with your own `app id` in `onCreate()`:  

        package com.android.voicetest;

        import android.app.Application;
        import com.iflytek.cloud.SpeechUtility;

        public class TestApp extends Application{
            @Override
            public void onCreate() {
                SpeechUtility.createUtility(TestApp.this, "appid=YOUR_APP_ID");  // set your own app id here
                super.onCreate();
            }
        }

2. Add permissions and set application name to `TestApp` in `AndroidManifest.xml`:  

        <?xml version="1.0" encoding="utf-8"?>
        <manifest xmlns:android="http://schemas.android.com/apk/res/android"
            package="com.android.voicetest">

            <original-package android:name="com.android.voicetest" />

            <application android:label="@string/app_name"
                         android:name="TestApp">
                <activity android:name="VoiceTest">
                    <intent-filter>
                        <action android:name="android.intent.action.MAIN" />
                        <category android:name="android.intent.category.DEFAULT" />
                        <category android:name="android.intent.category.LAUNCHER" />
                    </intent-filter>
                </activity>
            </application>

            <uses-permission android:name="android.permission.RECORD_AUDIO" />
            <uses-permission android:name="android.permission.INTERNET" />
            <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
            <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
            <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
            <uses-permission android:name="android.permission.READ_PHONE_STATE" />
            <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
            <uses-permission android:name="android.permission.READ_CONTACTS" />
            <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

        </manifest>

3. Use `InitListener`:

        import com.iflytek.cloud.InitListener;

        private InitListener mInitListener = new InitListener() {
            @Override
            public void onInit(int code) {
                if (code != ErrorCode.SUCCESS) {
                    showMessage(true, "onInit(): error: " + code);
                } else {
                    showMessage(true, "onInit(): succeeded");
                }
            }
        };


4. There're 2 ways to use iflytek SDK to do voice recognition:

   * One is `SpeechRecognizer`

            import com.iflytek.cloud.SpeechRecognizer;
            import com.iflytek.cloud.RecognizerListener;

            public class VoiceTest extends Activity {
                private SpeechRecognizer mIat;  // Use the Recognizer way
                String finalText = "";  // concat the strings of multiple onResult() calls.
                ......
            }

            public void onCreate(Bundle state) {
                // Recognizer Way
                mIat = SpeechRecognizer.createRecognizer(this, mInitListener);
                mIat.setParameter(SpeechConstant.ASR_PTT, "false");  // no punctuation
                ......
            }
            
            // Recognizer Way: Use RecognizerListener
            private RecognizerListener recognizerListener=new RecognizerListener(){
                @Override
                public void onBeginOfSpeech() {
                    showMessage(true, "begin of speech");
                }

                @Override
                public void onError(SpeechError error) {
                    showMessage(true, "onError(): " + error.getPlainDescription(true));
                }

                @Override
                public void onEndOfSpeech() {
                    showMessage(true, "end of speech");
                }

                @Override
                public void onResult(RecognizerResult results, boolean isLast) {
                    String text = JsonParser.parseIatResult(results.getResultString());
                    finalText += text;
                    if(isLast) {
                        showMessage(true, "onResult():last: " + text);
                        showMessage(true, "final: " + finalText);
                    } else {
                        showMessage(true, "onResult(): " + text);
                    }
                }

                @Override
                public void onVolumeChanged(int volume) {
                    //showMessage(true, "onVolumeChanged(): " + volume);
                }

                @Override
                public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
                }
            };

            // Start Listening
            int ret = mIat.startListening(recognizerListener);
            if(ret != ErrorCode.SUCCESS){
                showMessage(true, "startListening() error: " + ret);
            } else {
                showMessage(true, "OK");
                starting = true;
            }

            // Stop Listening
            mIat.stopListening();

   * Another is `RecognizerDialog`

            import com.iflytek.cloud.ui.RecognizerDialog;
            import com.iflytek.cloud.ui.RecognizerDialogListener;

            public class VoiceTest extends Activity {
                private RecognizerDialog iatDialog;  // Dialog way
                String finalText = "";  // concat the strings of multiple onResult() calls.
                ......
            }

            public void onCreate(Bundle state) {
                // Dialog Way
                iatDialog = new RecognizerDialog(this, mInitListener);
                ......
            }

            private RecognizerDialogListener recognizerDialogListener=new RecognizerDialogListener(){
                public void onResult(RecognizerResult results, boolean isLast) {
                    String text = JsonParser.parseIatResult(results.getResultString());
                    finalText += text;
                    if (isLast) {
                        showMessage(true, "dialog::onResult():last: " + text);
                        showMessage(true, "final: " + finalText);
                    } else {
                        showMessage(true, "dialog::onResult(): " + text);
                    }
                }

                public void onError(SpeechError error) {
                    String text = error.getPlainDescription(true);
                    showMessage(true, "dialog::onError(): " + text);
                }
            };

            // Show Dialog
            iatDialog.setListener(recognizerDialogListener);
            iatDialog.show();

            // Dismiss Dialog
            iatDialog.dismiss();
            
## References
* Source Code of Sample App(VoiceTest):  
  <https://github.com/northbright/VoiceTest>