package org.webrtc.kite.sample.checks;

import org.webrtc.kite.config.client.BrowserSpecs;
import org.webrtc.kite.sample.pages.HostMeetingPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.steps.TestStep;

public class RecordingChecks extends TestStep{
	static HostMeetingPage hostmeetingPage = null;
	ConsoleLogs lg=null;

	public RecordingChecks(Runner runner) {
		super(runner);
		hostmeetingPage = new HostMeetingPage(runner);
		 lg =new ConsoleLogs(runner);
	}

	@Override
	protected void step() throws KiteTestException {
		 try {
			
			// hostmeetingPage.recodingValidation();
		 }catch (Exception e) {
			throw new KiteTestException("Issue in fetching meeting history", Status.SKIPPED);
		}finally {
			if(BrowserSpecs.BrowName.equalsIgnoreCase("chrome")) {
				lg.get_browser_console_log("AllVideochecks",report);
			}
		}
		
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
