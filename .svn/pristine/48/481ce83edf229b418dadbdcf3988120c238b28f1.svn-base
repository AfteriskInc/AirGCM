package com.afterisk.shared.android.gcm;

import android.content.Context;

import com.google.android.gcm.GCMBroadcastReceiver;

public class AfteriskGCMBroadcastReceiver extends GCMBroadcastReceiver
{

	@Override
	protected java.lang.String getGCMIntentServiceClassName(Context context)
	{
		String intentClassName = super.getGCMIntentServiceClassName(context);
		intentClassName = "com.afterisk.shared.android.gcm.GCMIntentService";
		//FREContext freContext = GCMPushExtension.context;
		//freContext.dispatchStatusEventAsync("intentClassName", intentClassName);
		return intentClassName;
	}
}