/*
 * Copyright (C) 2012 The Android Open Source Project
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
 * limitations under the License
 */

package com.android.onetimeinitializer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * BroadcastReceiver that starts the service to performs one time initialization
 * at bootup time.
 */
public class OneTimeInitializerReceiver extends BroadcastReceiver {

    private static final String TAG = OneTimeInitializerReceiver.class.getSimpleName()
            .substring(0, 22);

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG, "OneTimeInitializerReceiver.onReceive");
        context.startService(new Intent(context, OneTimeInitializerService.class));
    }
}
