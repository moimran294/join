package org.webrtc.kite.sample.checks;

import java.io.File;
import java.io.IOException;


import org.webrtc.kite.WebDriverFactory;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.steps.TestStep;


public class NetworkLog extends TestStep {

	public NetworkLog(Runner runner) {
		super(runner);
		
	}

	
	@Override
	protected void step() throws KiteTestException {
		
		
		
		/*
		 * Har har = WebDriverFactory.proxy.getHar();
		 * 
		 * File harFile = new File("NetworkJoin.har"); try { har.writeTo(harFile); }
		 * catch (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		 
		 
		
	}
	    

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "collecting network data";
	}

	
	
	

}
