package org.webrtc.kite.sample.checks;

import org.webrtc.kite.config.client.BrowserSpecs;
import org.webrtc.kite.config.test.TestConfig;
import org.webrtc.kite.sample.pages.HostJoinPage;
import org.webrtc.kite.sample.pages.HostMeetingPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.steps.TestStep;

public class MemberCount_NameCheck extends TestStep {

	
	static HostMeetingPage hostmeetingPage = null;
	ConsoleLogs lg=null;
	public MemberCount_NameCheck(Runner runner) {
		super(runner);
		hostmeetingPage = new HostMeetingPage(runner);
		 lg =new ConsoleLogs(runner);
	}

	@Override
	protected void step() throws KiteTestException {
		try {
		hostmeetingPage.totalMembers();
		TestConfig tpl = new TestConfig();
		int size = tpl.getTupleSize();
		if(size!=HostMeetingPage.totalmemberinpanel) {
			throw new KiteTestException("All member are not present in member Panel", Status.SKIPPED);
			
		}
		}
		catch (Exception e) {
			throw new KiteTestException("Issue in member Panel", Status.SKIPPED);
		}finally {
			
			
			if(BrowserSpecs.BrowName.equalsIgnoreCase("chrome")) {
				lg.get_browser_console_log("AllVideochecks",report);
			}
		
	}
		
		
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "Member count Verification Test";
	}

}
