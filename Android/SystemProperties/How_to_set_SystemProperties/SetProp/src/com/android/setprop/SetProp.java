/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.setprop;

import android.app.Activity;
import android.content.res.Resources;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.provider.MediaStore;
import android.content.ActivityNotFoundException;
import android.os.SystemProperties;
import android.text.method.ScrollingMovementMethod;

public class SetProp extends Activity {
    final String TAG = "SetProp";
    final String PROP_NAME = "persist.sys.my.prop";

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.main);
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Call finish() if you want to start a new activity and exit
        //finish();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void showCurrentState(int ret) {
        TextView outputText = (TextView) findViewById(R.id.output_text_view);
        String msg = outputText.getText() + "\n" + PROP_NAME + " = " + ret;
        outputText.setText(msg);
        outputText.setMovementMethod(new ScrollingMovementMethod());
    }

    public void set(View view) {
        SystemProperties.set(PROP_NAME, "1");
        int ret = SystemProperties.getInt(PROP_NAME, 0);
        showCurrentState(ret);
    }

    public void unset(View view) {
        SystemProperties.set(PROP_NAME, "0");
        int ret = SystemProperties.getInt(PROP_NAME, 0);
        showCurrentState(ret);
    }
}
