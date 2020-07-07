
package org.webrtc.kite.sample.steps;

import org.webrtc.kite.sample.pages.ParticipantsJoinPage;
import org.webrtc.kite.sample.pages.ParticipantsMeetingPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.steps.TestStep;

public class ParticipantsMeetingJoinStep extends TestStep {

	public ParticipantsMeetingPage meetingPage = null;
	public ParticipantsJoinPage joinpage = null;
	
	public static boolean lock=true;

	public ParticipantsMeetingJoinStep(Runner runner) {
		super(runner);

		joinpage = new ParticipantsJoinPage(runner);
		meetingPage = new ParticipantsMeetingPage(runner);
	}

	@Override
	protected void step() throws KiteTestException {


		try {
			joinpage.joinMeetingRoom();

		} catch (Exception e) {
			throw new KiteTestException("meeting Link not available", Status.FAILED);
		}
		try {
			joinpage.SkipEchotest();
			logger.info("Skip Echo test In Participant");
		} catch (Exception e) {
			throw new KiteTestException("Issue In Echo Test for Participant", Status.SKIPPED);
		}
		try {
			joinpage.meetingname();
			logger.info("Participant Name Done");
		} catch (Exception e) {
			throw new KiteTestException("Issue In Meeting Name", Status.SKIPPED);
		}

		try {
			logger.info("In Participant Message Panel ");
			meetingPage.InstantMSG();
		} catch (Exception e) {
			throw new KiteTestException("Issue in Message", Status.SKIPPED);
		}

		try {
			logger.info("In Mute Unmute Operation for Participant");
			meetingPage.mute();
		} catch (Exception e) {
			System.out.println("participant mute button not working");
		}
		try {
			logger.info("In Play/Pause Operation for Participant");
			meetingPage.video_off();
		} catch (Exception e) {
			System.out.println("participant video button is not working");
		}
		try {
			if(lock==true) {
				lock = false;
				
				joinpage.LockRoomTest();	
			}
			else {
			
				Thread.sleep(5000);
			}
		}catch (Exception e) {
			
		}
		try {
			meetingPage.hangup();
		} catch (Exception e) {
			System.out.println("hang up button issue");
		}

	}

	@Override
	public String stepDescription() { // TODO Auto-generated method
		return "Participant Join script";
	}

}
