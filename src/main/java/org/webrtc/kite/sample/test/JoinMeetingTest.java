package org.webrtc.kite.sample.test;

import org.webrtc.kite.config.test.TestConfig;
import org.webrtc.kite.sample.checks.AllVideochecks;
import org.webrtc.kite.sample.checks.ConnectionData_Checks;

import org.webrtc.kite.sample.checks.EchoTestChecks;
import org.webrtc.kite.sample.checks.GridViewChecks;
import org.webrtc.kite.sample.checks.HangupCallChecks;
import org.webrtc.kite.sample.checks.LockRoomChecks;

import org.webrtc.kite.sample.checks.MeetingNameCheck;
import org.webrtc.kite.sample.checks.MemberCount_NameCheck;
import org.webrtc.kite.sample.checks.MsgChecks;
import org.webrtc.kite.sample.checks.MuteAll_FullScreenchecks;
import org.webrtc.kite.sample.checks.Mute_UnmuteChecks;

import org.webrtc.kite.sample.checks.OtpChecks;
import org.webrtc.kite.sample.checks.ProfileChecks;
import org.webrtc.kite.sample.checks.ResolutionChecks;
import org.webrtc.kite.sample.checks.ScreenSharechecks;
import org.webrtc.kite.sample.checks.ShareMeetinglinkChecks;

import org.webrtc.kite.sample.checks.VideoPlayPauseChecks;
import org.webrtc.kite.sample.steps.HostJoinStep;
import org.webrtc.kite.sample.steps.ParticipantsMeetingJoinStep;
import org.webrtc.kite.tests.KiteBaseTest;
import org.webrtc.kite.tests.TestRunner;

public class JoinMeetingTest extends KiteBaseTest {

	public Boolean isHostExist = true;
	TestConfig tpl = new TestConfig();

	@Override
	public void afterTerminate() {
		this.isHostExist = false;
	}

	@Override
	public void populateTestSteps(TestRunner runner) {
		int size = tpl.getTupleSize();
		if (isHostExist) {
			isHostExist = false;

			System.out.println("Host Script Ready");

			runner.addStep(new HostJoinStep(runner));

			runner.addStep(new OtpChecks(runner));

			runner.addStep(new ShareMeetinglinkChecks(runner));

			runner.addStep(new EchoTestChecks(runner));

			runner.addStep(new MeetingNameCheck(runner));

			runner.addStep(new MsgChecks(runner));

			runner.addStep(new MemberCount_NameCheck(runner));

			runner.addStep(new Mute_UnmuteChecks(runner));

			runner.addStep(new LockRoomChecks(runner));

			runner.addStep(new VideoPlayPauseChecks(runner));

			runner.addStep(new ConnectionData_Checks(runner));

			runner.addStep(new MuteAll_FullScreenchecks(runner));

			runner.addStep(new AllVideochecks(runner));
			
			runner.addStep(new ResolutionChecks(runner));

			runner.addStep(new ScreenSharechecks(runner));

			if (size > 4) {
				runner.addStep(new GridViewChecks(runner));
			}

			runner.addStep(new HangupCallChecks(runner));
			// runner.addStep(new NetworkLog(runner));

			runner.addStep(new ProfileChecks(runner));

		} else

		{

			System.out.println("Participant Script Ready");

			runner.addStep(new ParticipantsMeetingJoinStep(runner));

		}

	}

}
