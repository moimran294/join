package org.webrtc.kite.sample.checks;

import org.webrtc.kite.sample.pages.HostMeetingPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.steps.TestStep;

public class ResolutionChecks extends TestStep{

	static HostMeetingPage hostmeetingPage = null;
	ConsoleLogs lg=null;
	public ResolutionChecks(Runner runner) {
		super(runner);
		hostmeetingPage = new HostMeetingPage(runner);
		 lg =new ConsoleLogs(runner);
	}

	@Override
	protected void step() throws KiteTestException {
		
		hostmeetingPage.select_resolution();
		
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "Resolution Test";
	}

}
