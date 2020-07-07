package org.webrtc.kite.sample.steps;

import org.junit.Test;
import org.webrtc.kite.sample.pages.GetOTPFunctionality;
import org.webrtc.kite.sample.pages.HostJoinPage;
import org.webrtc.kite.sample.pages.HostMeetingPage;
import org.webrtc.kite.tests.KiteBaseTest;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.AllureStepReport;
import io.cosmosoftware.kite.report.StatusDetails;
import io.cosmosoftware.kite.steps.TestStep;

public class HostMeetingJoinStep extends TestStep {

	static HostJoinPage hostPage = null;
   // static CreateRoom cr = null;
	static HostMeetingPage hostmeetingPage = null;

	public HostMeetingJoinStep(Runner runner) {
		super(runner);
		hostPage = new HostJoinPage(runner);
		hostmeetingPage = new HostMeetingPage(runner);
       // cr =new CreateRoom(runner);
	}

	@Override
	protected void step() {
		
		
		/*
		 * try { //cr.step(); } catch (KiteTestException e1) { // TODO Auto-generated
		 * catch block e1.printStackTrace(); }
		 */

		/*
		 * try {
		 * 
		 * 
		 * hostPage.createRoom(); System.out.println("Room creation step is paas");
		 * report.setDescription("OTP validation"); } catch (Exception e) {
		 * 
		 * System.out.println("otp invalid"); System.out.println("Create Room Failed " +
		 * e.getMessage()); }
		 */

		try {
			hostPage.ShareMeetingLink();
			StatusDetails details = new StatusDetails();
			details.setMessage("Hello world");
			report.setDetails(details);
			report.setDescription("share link");
		} catch (Exception e) {
			System.out.println("issue in sharing link");
		}

		try {
			hostPage.StartMeeting();
		} catch (Exception e) {
			System.out.println("start meeting step fail");
		}

		try {
			hostPage.SkipEchotest();
		} catch (Exception e) {
			System.out.println("skip button is not working");
		}
		try {
			hostPage.UserName();
		} catch (Exception e) {
			System.out.println("issue in meeting name filling");
		}

		try {
			hostmeetingPage.mute();
		} catch (Exception e) {
			System.out.println("issue in mute button");
		}

		try {
			hostmeetingPage.InstantMSG();
		} catch (Exception e) {
			System.out.println("issue in message");
		}
		try {
			hostmeetingPage.video_pause_play();
		} catch (Exception e) {
			System.out.println("video off button is working");
		}
		try {
			hostmeetingPage.totalMembers();
		} catch (Exception e) {
			System.out.println("total number of member are diffrent");
		}
		try {
			
			hostmeetingPage.muteALL();
		}catch (Exception e) {
			System.out.println("mute all button is not working");
		}
		
		try {
			hostmeetingPage.Videocheck();
		} catch (Exception e) {
			System.out.println("all member are not displayed");
		}
		
		try {
			hostmeetingPage.fullScreen();
		}catch (Exception e) {
		   System.out.println("fullscreen button is not working");
		}
  
		/*
		 * try { hostmeetingPage.select_resolution(); }catch (Exception e) {
		 * System.out.println("mode selection is not working"); }
		 */
		
		try {
			hostmeetingPage.ScreenShare();
		} catch (Exception e) {
			System.out.println("screen shre is not working");
		}

		try {
			hostmeetingPage.GridView();
		} catch (Exception e) {
			System.out.println("grid button is not visible");
		}

		try {
			hostmeetingPage.lockRoomTest();
		} catch (Exception e) {
			System.out.println("lock room button is not wroking" + "");
		}
		// hostmeetingPage.hangup();

	}

	@Override
	public String stepDescription() {
		return null;
	}

}
