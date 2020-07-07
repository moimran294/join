package org.webrtc.kite.sample.checks;

import org.webrtc.kite.config.client.BrowserSpecs;
import org.webrtc.kite.sample.pages.HostJoinPage;
import org.webrtc.kite.tests.TestRunner;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.steps.TestStep;

public class MeetingNameCheck extends TestStep {
	
	static HostJoinPage hostPage = null;
	ConsoleLogs lg=null;
	public MeetingNameCheck(Runner runner) {
		super(runner);
		hostPage = new HostJoinPage(runner);
		 lg =new ConsoleLogs(runner);
	}

	@Override
	protected void step() throws KiteTestException {
	
		try {
		hostPage.UserName();
		}catch (Exception e) {
			throw new KiteTestException("Issue in meeting name fill", Status.FAILED);
		}finally {
			
			
			if(BrowserSpecs.BrowName.equalsIgnoreCase("chrome")) {
				lg.get_browser_console_log("AllVideochecks",report);
			}
	}
		
		
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "Meeting Name Test";
	}

}
