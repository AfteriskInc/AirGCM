package com.afterisk.shared.android.gcm;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.google.android.gcm.GCMRegistrar;

public class GCMPushRegisterFunction implements FREFunction 
{

	@Override
	public FREObject call(FREContext context, FREObject[] args) 
	{
		FREObject result;
		
		String message = "ok";
		String senderID = "";
		
		Log.i("GCMExtension", "checking device registration");
		
		try {
			senderID = args[0].getAsString();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GCMRegistrar.checkDevice(context.getActivity().getApplication());
		
		final String regId = GCMRegistrar.getRegistrationId(context.getActivity().getApplication());
        
		if (regId.equals("")) 
        {
			GCMRegistrar.register(context.getActivity().getApplication(), senderID);
          	message = "GCMRegistrar: registering sender " +  senderID;
        } 
        else 
        {
        	message = "registrationID:" + regId;
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