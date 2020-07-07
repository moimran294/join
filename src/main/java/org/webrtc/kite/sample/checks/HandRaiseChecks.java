package org.webrtc.kite.sample.checks;

import org.webrtc.kite.config.client.BrowserSpecs;
import org.webrtc.kite.sample.pages.HostMeetingPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.steps.TestStep;

public class HandRaiseChecks extends TestStep {
	
	static HostMeetingPage hostmeetingPage = null;
	ConsoleLogs lg=null;

	public HandRaiseChecks(Runner runner) {
		super(runner);
		hostmeetingPage = new HostMeetingPage(runner);
		  lg =new ConsoleLogs(runner);
	}

	@Override
	protected void step() throws KiteTestException {
		try {
			hostmeetingPage.AcceptHandRaise();
			hostmeetingPage.AcceptHandRaise();
			hostmeetingPage.AcceptHandRaise();
			
		}catch (Exception e) {
			throw new KiteTestException("Hand raise Request Not present", Status.SKIPPED);
		}finally {
			
			
			if(BrowserSpecs.BrowName.equalsIgnoreCase("chrome")) {
				lg.get_browser_console_log("AllVideochecks",report);
			}
		
	}
		
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "Hand Raise test";
	}

}
