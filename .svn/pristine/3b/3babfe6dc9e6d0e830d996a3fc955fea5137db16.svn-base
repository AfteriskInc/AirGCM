package com.afterisk.shared.android.gcm;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;
import com.google.android.gcm.GCMRegistrar;

public class GCMPushUnregisterFunction implements FREFunction 
{

	@Override
	public FREObject call(FREContext context, FREObject[] args) 
	{
		FREObject result;
		
		String message = "Device was not registered with GCM.";
		
		Log.i("GCMExtension", "checking device registration");
		
		GCMRegistrar.checkDevice(context.getActivity().getApplication());
		
		final String regId = GCMRegistrar.getRegistrationId(context.getActivity().getApplication());
        
		if (!regId.equals("")) 
        {
			GCMRegistrar.unregister(context.getActivity().getApplication());
			message = "GCMRegistrar: unregistering device from GCM";
        }
    
		
		try 
		{
			result = FREObject.newObject(message);
			return result;
		} 
		catch (FREWrongThreadException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}