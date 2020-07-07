package org.webrtc.kite.sample.checks;

import org.webrtc.kite.sample.pages.HostMeetingPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.steps.TestStep;

public class ProfileChecks extends TestStep {

	
	static HostMeetingPage hostmeetingPage = null;
	ConsoleLogs lg=null;
	public ProfileChecks(Runner runner) {
		super(runner);
		 hostmeetingPage = new HostMeetingPage(runner);
		 lg =new ConsoleLogs(runner);
	}

	@Override
	protected void step() throws KiteTestException {
	    try {
			hostmeetingPage.my_Profile();
			
			hostmeetingPage.mail_id_Check();
			hostmeetingPage.meeting_History();
			hostmeetingPage.signOut_MyProfile();
		} catch (Exception e) {
			e.printStackTrace();
			throw new KiteTestException("Issue in profile data", Status.SKIPPED); 
			
		}finally {
			
			
			//lg.get_browser_console_log("ProfileChecks",report);
		
	}
		
	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "Profile Data Test" ;
	}

}
