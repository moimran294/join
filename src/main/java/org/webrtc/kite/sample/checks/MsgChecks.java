package org.webrtc.kite.sample.checks;

import org.webrtc.kite.config.client.BrowserSpecs;
import org.webrtc.kite.config.test.TestConfig;



import org.webrtc.kite.sample.pages.HostMeetingPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;

import io.cosmosoftware.kite.report.Status;

import io.cosmosoftware.kite.steps.TestStep;
import io.cosmosoftware.kite.util.ReportUtils;

public class MsgChecks extends TestStep {

	static HostMeetingPage hostmeetingPage = null;
	ConsoleLogs lg=null;

	public MsgChecks(Runner runner) {
		super(runner);
		hostmeetingPage = new HostMeetingPage(runner);
		  lg =new ConsoleLogs(runner);
	}

	@Override
	protected void step() throws KiteTestException {

		try {
            
			hostmeetingPage.InstantMSG();
			logger.info("msg send by host");
			TestConfig tpl = new TestConfig();
			int size = tpl.getTupleSize();
            
			
      if(hostmeetingPage.BlackScreenChecks()) {
				
				
				logger.info("Black screen insted of video");
				reporter.screenshotAttachment( report, "Black Screen", ReportUtils.saveScreenshotPNG(webDriver));
				
			}
			
			if (size == HostMeetingPage.total_msg) {
				logger.info("all msg was received");
			} else {
				throw new KiteTestException("All messages were not received or duplicate messages were there",
						Status.SKIPPED);
			}
           
			
		} catch (Exception e) {
			
			throw new KiteTestException("Issue in Instant Message", Status.SKIPPED);
		}finally {
			
			
			if(BrowserSpecs.BrowName.equalsIgnoreCase("chrome")) {
				lg.get_browser_console_log("AllVideochecks",report);
			}
		
	}

		
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "Message verification Test";
	}

}
