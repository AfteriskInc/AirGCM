package com.afterisk.shared.android.gcm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

public class GCMInitFunction implements FREFunction 
{

	@Override
	public FREObject call(FREContext context, FREObject[] args) 
	{
		FREObject result;
		
		Log.i("GCMExtension", "checking pending messages");
		
		String message = "false";
		Intent launchIntent = context.getActivity().getIntent();
   
		if(launchIntent != null)
      	{
      		Bundle ex = launchIntent.getExtras();
      		if(ex != null)
      		{
      			message = launchIntent.getStringExtra("data");
      		}
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