package org.webrtc.kite.sample.test;

import org.webrtc.kite.sample.checks.AllVideochecks;
import org.webrtc.kite.sample.checks.ConsoleLogs;
import org.webrtc.kite.sample.checks.EchoTestChecks;
import org.webrtc.kite.sample.checks.GridViewChecks;
import org.webrtc.kite.sample.checks.HandRaiseChecks;
import org.webrtc.kite.sample.checks.MeetingNameCheck;
import org.webrtc.kite.sample.checks.MemberCountWebinarchecks;
import org.webrtc.kite.sample.checks.MemberCount_NameCheck;
import org.webrtc.kite.sample.checks.MsgChecks;
import org.webrtc.kite.sample.checks.Mute_UnmuteChecks;
import org.webrtc.kite.sample.checks.OtpChecks;
import org.webrtc.kite.sample.checks.ScreenSharechecks;
import org.webrtc.kite.sample.checks.ShareMeetinglinkChecks;
import org.webrtc.kite.sample.checks.ShareWebinarlinkChecks;
import org.webrtc.kite.sample.checks.VideoPlayPauseChecks;
import org.webrtc.kite.sample.steps.HostJoinStep;
import org.webrtc.kite.sample.steps.ParticipantsMeetingJoinStep;
import org.webrtc.kite.sample.steps.ParticipantsWebinarJoinStep;
import org.webrtc.kite.tests.KiteBaseTest;
import org.webrtc.kite.tests.TestRunner;

public class JoinWebinarTest extends KiteBaseTest{
	
	
	public Boolean isHostExist = true;

	@Override
	public void afterTerminate() {
		this.isHostExist = false;
	}

	@Override
	public void populateTestSteps(TestRunner runner) {

		if (isHostExist) {
			isHostExist = false;
			
			System.out.println("Host Webinar Script");
			

			runner.addStep(new HostJoinStep(runner));

			runner.addStep(new OtpChecks(runner));

			runner.addStep(new ShareWebinarlinkChecks(runner));

			runner.addStep(new EchoTestChecks(runner));
			
			runner.addStep(new MeetingNameCheck(runner));

			runner.addStep(new MsgChecks(runner));
			
			runner.addStep(new HandRaiseChecks(runner));
			
			runner.addStep(new MemberCountWebinarchecks(runner));
				
			runner.addStep(new Mute_UnmuteChecks(runner));
			
			runner.addStep(new VideoPlayPauseChecks(runner));
			
			runner.addStep(new ScreenSharechecks(runner));
				
			} 
		else
		
		{
			
			System.out.println("Participants Webinar Script");
			
			runner.addStep(new ParticipantsWebinarJoinStep(runner));
     
			
		
			 

		}

	}

}
