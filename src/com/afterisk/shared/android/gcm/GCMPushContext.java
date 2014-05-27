package com.afterisk.shared.android.gcm;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class GCMPushContext extends FREContext 
{

	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public Map<String, FREFunction> getFunctions() 
	{
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
		
		map.put("register", new GCMPushRegisterFunction());
		map.put("unregister", new GCMPushUnregisterFunction());
		map.put("checkPendingPayload", new GCMInitFunction());
		
		return map;
	}

}
