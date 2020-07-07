package org.webrtc.kite.sample.steps;


import org.webrtc.kite.sample.pages.HostJoinPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.steps.TestStep;

public class HostJoinStep extends TestStep{
	
	static HostJoinPage hostPage = null;

	public HostJoinStep(Runner runner) {
		super(runner);
		hostPage = new HostJoinPage(runner);
	}

	@Override
	protected void step() throws KiteTestException {
		
		
				
		//WebDriverFactory.proxy
		hostPage.openUrl();
		
		
		
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "Navigate to join website";
	}

}
