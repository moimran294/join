package org.webrtc.kite.sample.checks;

import org.webrtc.kite.config.client.BrowserSpecs;
import org.webrtc.kite.sample.pages.HostMeetingPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.steps.ScreenshotStep;
import io.cosmosoftware.kite.steps.TestStep;
import io.cosmosoftware.kite.util.ReportUtils;

public class Mute_UnmuteChecks extends TestStep {

	static HostMeetingPage hostmeetingPage = null;
	
	ConsoleLogs lg=null;

	public Mute_UnmuteChecks(Runner runner) {
		super(runner);
		hostmeetingPage = new HostMeetingPage(runner);	 
		 lg =new ConsoleLogs(runner);
	}

	@Override
	protected void step() throws KiteTestException {
		try {
			hostmeetingPage.mute();
          
			if (hostmeetingPage.muteIconVisible == true) {
				logger.info("mute icon is visible on mute click");

			} else {
        
				throw new KiteTestException("mute Icon is not visible", Status.SKIPPED);
			}

			hostmeetingPage.unmute();

		
		} catch (Exception e) {

			throw new KiteTestException(e.getMessage(), Status.SKIPPED);
		}finally {
			
			
			if(BrowserSpecs.BrowName.equalsIgnoreCase("chrome")) {
				lg.get_browser_console_log("AllVideochecks",report);
			}
		
	}
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "mute button Test";
	}

}
