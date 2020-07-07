package org.webrtc.kite.sample.steps;

import org.webrtc.kite.sample.pages.ParticipantsJoinPage;
import org.webrtc.kite.sample.pages.ParticipantsMeetingPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.steps.TestStep;

public class ParticipantsWebinarJoinStep extends TestStep {

	public ParticipantsMeetingPage meetingPage = null;
	public ParticipantsJoinPage joinpage = null;

	public ParticipantsWebinarJoinStep(Runner runner) {
		super(runner);
		joinpage = new ParticipantsJoinPage(runner);
		meetingPage = new ParticipantsMeetingPage(runner);
	}

	@Override
	protected void step() throws KiteTestException {
		try {
			joinpage.joinWebinarRoom();

			joinpage.SkipEchotest();

			joinpage.meetingname();
			
			meetingPage.InstantMSG();

			
			Thread.sleep(2000);
			meetingPage.handraise();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return "participant webinar join steps";
	}

}
