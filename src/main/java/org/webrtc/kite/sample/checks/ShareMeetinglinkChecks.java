package org.webrtc.kite.sample.checks;

import org.webrtc.kite.config.client.BrowserSpecs;
import org.webrtc.kite.sample.pages.HostJoinPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.steps.TestStep;

public class ShareMeetinglinkChecks extends TestStep {
	
	static HostJoinPage hostPage = null;
	ConsoleLogs lg=null;
	public ShareMeetinglinkChecks(Runner runner) {
		super(runner);
		hostPage = new HostJoinPage(runner);
		 lg =new ConsoleLogs(runner);
	}

	@Override
	protected void step() throws KiteTestException {
		
		
		try {
        hostPage.ShareMeetingLink();
        
        logger.info("Link Generated by Host is" +" "+ HostJoinPage.generatedroomId);
        
        hostPage.StartMeeting();
		
		}catch (Exception e) {
			
			throw new KiteTestException("Share Meeeting test failed", Status.FAILED);
		}finally {
			
			
			
			if(BrowserSpecs.BrowName.equalsIgnoreCase("chrome")) {
				lg.get_browser_console_log("AllVideochecks",report);
			}
		
	}
		
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "link checks and share with participant";
	}

}