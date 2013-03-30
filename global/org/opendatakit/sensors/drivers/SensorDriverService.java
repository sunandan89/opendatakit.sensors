/*
 * Copyright (C) 2013 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.opendatakit.sensors.drivers;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Individual sensors export this service.
 *
 * @author wbrunette@gmail.com
 * @author rohitchaudhri@gmail.com
 *
 */
@SuppressLint("Registered")
public class SensorDriverService extends Service {

	private IBinder mSensorServiceBinder;

	public static final String TAG = "SensorDriverService";

	public void onCreate ()
	{
		mSensorServiceBinder = new SensorDriverServiceInterface(this);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return mSensorServiceBinder;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_STICKY;
	}

}
