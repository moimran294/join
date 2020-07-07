package org.webrtc.kite.sample.checks;


import java.io.IOException;

import org.webrtc.kite.config.client.BrowserSpecs;
import org.webrtc.kite.config.client.Client;
import org.webrtc.kite.sample.pages.HostJoinPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.steps.TestStep;

public class OtpChecks extends TestStep {
	
	
	static HostJoinPage hostPage = null;
	ConsoleLogs lg=null;
	
	public OtpChecks(Runner runner) {
		
		super(runner);
	      lg =new ConsoleLogs(runner);
		
		hostPage = new HostJoinPage(runner);
	}

	@Override
	protected void step() throws KiteTestException {
		
		try {
		hostPage.createRoom();
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new KiteTestException("Room creation failed", Status.FAILED);
		
		}
		finally {
			
			
			if(BrowserSpecs.BrowName.equalsIgnoreCase("chrome")) {
				lg.get_browser_console_log("AllVideochecks",report);
			}
			
		}
		
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "Get otp and login step";
	}

}
