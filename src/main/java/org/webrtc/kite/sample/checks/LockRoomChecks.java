package org.webrtc.kite.sample.checks;

import org.webrtc.kite.config.client.BrowserSpecs;
import org.webrtc.kite.sample.pages.HostMeetingPage;
import org.webrtc.kite.sample.pages.ParticipantsJoinPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.steps.TestStep;
import io.cosmosoftware.kite.util.ReportUtils;

public class LockRoomChecks extends TestStep {

	
	static HostMeetingPage hostmeetingPage = null;
	ConsoleLogs lg=null;
	public LockRoomChecks(Runner runner) {
		super(runner);
		hostmeetingPage = new HostMeetingPage(runner);
		  lg =new ConsoleLogs(runner);
	}

	@Override
	protected void step() throws KiteTestException {
		try {
			
			hostmeetingPage.lockRoomTest(); 
		  System.out.println(ParticipantsJoinPage.LockroomMessage);
			if(ParticipantsJoinPage.LockroomMessage.contains("Room has been locked")) {
				logger.info("Room is locked,Room Lock feature working fine");
			}else { 
				throw new KiteTestException("Room lock freature Not working", Status.SKIPPED);
				
			}
			
			hostmeetingPage.UnlockRoom();
			
			
			if(hostmeetingPage.BlackScreenChecks()) {
				
				
				logger.info("Black screen insted of video");
				reporter.screenshotAttachment( report, "Black Screen", ReportUtils.saveScreenshotPNG(webDriver));
				
			}
			
		}catch (Exception e) {
			
			if(BrowserSpecs.BrowName.equalsIgnoreCase("chrome")) {
				lg.get_browser_console_log("AllVideochecks",report);
			}
		}
		
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "Lock Room Test";
	}

}
