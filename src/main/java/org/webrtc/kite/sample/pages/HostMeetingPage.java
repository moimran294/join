package org.webrtc.kite.sample.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.activation.MailcapCommandMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.webrtc.kite.sample.steps.HostJoinStep;

import io.cosmosoftware.kite.exception.KiteInteractionException;
import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.pages.BasePage;
import io.cosmosoftware.kite.report.AllureStepReport;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.steps.ScreenshotStep;

public class HostMeetingPage extends BasePage {

	public static int totalmemberinpanel;

	public static int total_msg;

	public static int participant_in_gridview;

	public static boolean muteIconVisible = true;
	public static boolean blackscreen = false;
	public static int videoTag;

	public static boolean lockroom = true;
	public static int height = 0;
	public static int width = 0;

	public HostMeetingPage(Runner runner) {
		super(runner);

	}

	@FindBy(xpath = "//div[@class='side-bar open']/ul/li[2]")
	WebElement chat;
	// div[@class='conference__call__actions--items']/ul/li[contains(@data-tooltip,'Screen
	// Share')]
	@FindBy(xpath = "//input[@placeholder='Type a Message']")
	WebElement textbox;

	@FindBy(xpath = "//button[@class='chatsend__button']")
	WebElement sendmsg;

	@FindBy(xpath = "//div[@class='conference__call__actions--items']/ul/li[contains(@data-tooltip,'Room')]")
	WebElement lockRoom;

	@FindBy(xpath = "//div[@class='conference__call__actions--items']/ul/li[contains(@data-tooltip,'Screen Share')]")
	WebElement screenShare;

	@FindBy(xpath = "//div[@class='conference__call__actions--items']/ul/li[contains(@data-tooltip,'mute')]")
	WebElement muteButton;

	@FindBy(xpath = "//*[@class='icon icon-action-unmute']")
	List<WebElement> muteIcon;

	@FindBy(xpath = "//div[@class='conference__call__actions--items']/ul/li[contains(@data-tooltip,'Record')]")
	WebElement recording;

	@FindBy(xpath = "//div[@class='conference__call__actions--items']/ul/li[contains(@data-tooltip,'Video')]")
	WebElement video_off;

	@FindBy(xpath = "//div[@class='conference__call__actions--items']/ul/li[contains(@data-tooltip,'End Call')]")
	WebElement hangup;

	@FindBy(xpath = "//*[@id='js--networkstatsbtn']")
	WebElement connection_stats;

	@FindBy(xpath = "//div[@class='is-active networkstats__dropdown']/ul/li")
	List<WebElement> connection_Data;

	@FindBy(xpath = "//div[@class='conference__call__actions--resolution']/button")
	WebElement resolution_setting;

	@FindBy(xpath = "//div[@class='resolution__dropdown is-active']/ul/li[1]")
	WebElement resolution_low;
	@FindBy(xpath = "//div[@class='resolution__dropdown is-active']/ul/li[3]")
	WebElement resolution_high;

	@FindBy(xpath = "//button[@class='copylinkaction__button']")
	WebElement copylink;

	@FindBy(xpath = "//li[@class='grid-view']")
	WebElement gridView;

	@FindBy(xpath = "//div[@class='conference__call__gridview__item']")
	List<WebElement> gridViewItem;

	@FindBy(xpath = "//div[@class='paper width-md']/div/button[@class='primary__button']")
	WebElement gridViewAccept;

	@FindBy(xpath = "//div[@class='floating-mute-all']/button")
	WebElement mute_all;

	@FindBy(xpath = "//div[@class='tabs']/ul/li[1]")
	WebElement memberpanel;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[1]/div[1]/primary-participant[@ng-reflect-full-screen]")
	WebElement actiondata;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[1]/div/div[2]/section[1]/participants-list/ul/li")
	List<WebElement> totalMember;

	@FindBy(xpath = "//section[@class='content__members']/broadcast-list/ul/li")
	List<WebElement> totalWebinarMember;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[1]/div/div[2]/section[1]/participants-list/ul/li/div/div/h4")
	List<WebElement> memberName;

	@FindBy(xpath = "//section[@class='content__members']/broadcast-list/ul/li//h4")
	List<WebElement> memberNameInWebinar;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/div[3]/room-lock/section/div[3]/button")
	WebElement lockroomverify;

	@FindBy(xpath = "/html/body/app-root/web-component/broadcast/div[1]/div[2]/span[1]")
	WebElement Accept;

	@FindBy(xpath = "//div[@class='conference__call__mainaction']/span")
	WebElement fullscreen_InOut;

	@FindBy(xpath = "//span[@class='chat__text--participant']")
	List<WebElement> participantMsg;

	@FindBy(xpath = "//span[@class='chat__text--currentuser']")
	List<WebElement> localMsg;

	@FindBy(xpath = "//video[@id='localVideo']")
	List<WebElement> Participantvideo;

	@FindBy(xpath = "//div[contains(@class,'conference__call__container__video')]/primary-participant")
	WebElement primaryparticipantobject;

	@FindBy(xpath = "//div[@class='conference__call__container__participants--participant']/participant-video")
	List<WebElement> participantobject;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[1]/div[1]/primary-participant/video")
	List<WebElement> hostVideo;

	@FindBy(xpath = "//div[@class='userprofile--shortname js--dropdown']")
	WebElement userProfile;

	@FindBy(xpath = "//div[@class='paper-body ']/div/input")
	WebElement editName;

	@FindBy(xpath = "/html/body/app-root/web-component/home/post-login-header/header/nav/div[2]/div/div[3]/div/ul/li[1]/a/span")
	WebElement editNameButton;

	@FindBy(xpath = "//div[@class='userprofile--dropdown-menu']/ul/li[1]/a")
	WebElement getProfileName;

	@FindBy(xpath = "//div[@class='paper-foot']/button[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//div[@class='userprofile--dropdown-menu']/ul/li[2]")
	WebElement getMailInProfile;

	@FindBy(xpath = "//div[@class='userprofile--dropdown-menu']/ul/li[3]")
	WebElement meetingHistory;

	@FindBy(css = "body > app-root > web-component > home > post-login-header > section > div.paper-head > div > div > svg > use")
	WebElement closeHistory;

	@FindBy(css = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[4]")
	WebElement record;

	@FindBy(xpath = "//ul[@class='call-history__data__list']/li[1]/span[1]")
	WebElement memberslist;

	@FindBy(xpath = "//ul[@class='call-history__data__list']/li[1]/span[2]")
	WebElement start_endTime;

	@FindBy(xpath = "//ul[@class='call-history__data__list']/li[1]/span[3]")
	WebElement meetingDuration;

	@FindBy(xpath = "//ul[@class='call-history__data__list']/li[1]/span[4]")
	WebElement date;

	@FindBy(xpath = "//ul[@class='call-history__data__list']/li[1]/span[5]")
	WebElement downloadRecordings;

	@FindBy(xpath = "//div[@class='call-history__filterscontainer']/h3[@class='paper-head--title']")
	WebElement historyLayout;

	@FindBy(xpath = "//div[@class='userprofile--dropdown-menu']/ul/li[4]")
	WebElement signOut;

	// h1[@class='primary-heading']
	@FindBy(xpath = "//h1[@class='primary-heading']")
	WebElement homePage;

	public void InstantMSG() throws InterruptedException

	{

		logger.info("In Message Pannel");
		try {
			Thread.sleep(8000);
			waitUntilAvailabilityOf(chat, 5);
			chat.click();

			waitUntilAvailabilityOf(textbox, 5);

			textbox.sendKeys("hello participants, I am the host", Keys.ENTER);

		} catch (KiteInteractionException e) {

		}

		Thread.sleep(9000);

		total_msg = participantMsg.size() + localMsg.size();
		logger.info("total msg" + " " + total_msg);
	}

	public void Videocheck() {
		try {
			videoTag = Participantvideo.size() + hostVideo.size();
			logger.info("Available video" + " " + videoTag);

		} catch (Exception e) {

		}

	}

	public boolean BlackScreenChecks() {

		logger.info(primaryparticipantobject.getAttribute("ng-reflect-stream"));

		if (primaryparticipantobject.getAttribute("ng-reflect-stream") == null) {
			blackscreen = true;
		}

		for (WebElement e : participantobject) {
			if (e.getAttribute("ng-reflect-stream") == null) {

				logger.info(e.getAttribute("ng-reflect-name") + " has black screen");
				blackscreen = true;
			}

		}
		return blackscreen;
	}

	public void ScreenShare() throws InterruptedException, KiteTestException {
		try {
			waitUntilVisibilityOf(screenShare, 5);
		} catch (KiteInteractionException e) {

			e.printStackTrace();
		}
		screenShare.click();
		if (primaryparticipantobject.getAttribute("ng-reflect-video-type") == "screen-cast") {
			logger.info("screen Share started");
		} else {
			throw new KiteTestException("Screen Share button is not working", Status.SKIPPED);
		}

		Thread.sleep(7000);

		screenShare.click();
		if (primaryparticipantobject.getAttribute("ng-reflect-video-type") == "camera") {
			logger.info("screen Share stoped");
		}
	}

	public void clearChat() {

	}

	public void totalMembers() {

		memberpanel.click();
		List<WebElement> members = totalMember;
		totalmemberinpanel = totalMember.size();

		logger.info("number of participant including host" + " " + totalmemberinpanel);

		for (WebElement e : memberName) {
			String name = e.getText();
			System.out.println(name);
		}
	}

	public void totalWebinarMembers() {

		memberpanel.click();
		List<WebElement> members = totalWebinarMember;
		totalmemberinpanel = totalWebinarMember.size();

		logger.info("number of participant including host" + " " + totalmemberinpanel);

		for (WebElement e : memberNameInWebinar) {
			String name = e.getText();
			System.out.println(name);
		}
	}

	public void GridView() throws InterruptedException, KiteTestException {

		if (totalMember.size() > 4) {
			if (gridView.isDisplayed()) {

				gridView.click();

				waitUntilVisibilityOf(gridViewAccept, 3);

				gridViewAccept.click();
			}
		} else {
			logger.error("min 4 participant require for grid view");
			throw new KiteTestException("participant are enoungh for grid view", Status.SKIPPED);
		}

	}

	public void mute() throws KiteTestException {

		try {

			waitUntilVisibilityOf(muteButton, 3);

			muteButton.click();

			Thread.sleep(2000);
			if (muteIcon.isEmpty()) {
				muteIconVisible = false;
				logger.info("muteIcon not displaying");

			}
			logger.info("in mute" + primaryparticipantobject.getAttribute("ng-reflect-audio-status"));
			if (primaryparticipantobject.getAttribute("ng-reflect-audio-status").equals("0")) {

				logger.info("Audio Muted");
			} else {
				throw new KiteTestException("user state not change to mute", Status.SKIPPED);			}

			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void unmute() throws InterruptedException {

		muteButton.click();
		Thread.sleep(2000);
		if (primaryparticipantobject.getAttribute("ng-reflect-audio-status").equals("1")) {

			logger.info("Audio Unmuted");
		}
	}

	public void fullScreen() throws KiteTestException, InterruptedException {

		fullscreen_InOut.click();

		try {
			Thread.sleep(2000);
			
			logger.info(primaryparticipantobject.getAttribute("ng-reflect-full-screen"));
			if (primaryparticipantobject.getAttribute("ng-reflect-full-screen").equals("true")) {

				logger.info(" In Fullscreen Mode");
			} else {
				throw new KiteTestException("user state not change to Fullscreen", Status.SKIPPED);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fullscreen_InOut.click();
		Thread.sleep(2000);
		if (primaryparticipantobject.getAttribute("ng-reflect-full-screen") == "false") {

			logger.info(" Exited From Fullscreen Mode");
		}
	}

	public void ConectionStatedata() throws InterruptedException {
		connection_stats.click();
		Thread.sleep(2000);
		Map<String, String> map = new HashMap<>();

		for (WebElement e : connection_Data) {
			String[] value = e.getText().split("-");
			map.put(value[0].trim(), value[1].trim());
		}

		System.out.println(map.get("Resolution"));

		String[] resolution = map.get("Resolution").split("x");

		int height = Integer.parseInt(resolution[0].trim());
		int width = Integer.parseInt(resolution[1].trim());

		System.out.println("resolution" + " " + height + " " + width);
	}

	public void muteALL() {

		memberpanel.click();

		try {
			waitUntilVisibilityOf(mute_all, 3);
		} catch (KiteInteractionException e) {
			
			e.printStackTrace();
		}
		mute_all.click();

	}

	public void video_pause_play() {

		video_off.click();
		try {
			Thread.sleep(2000);
			logger.info("in video" + primaryparticipantobject.getAttribute("ng-reflect-video-status"));
			if (primaryparticipantobject.getAttribute("ng-reflect-video-status").equals("0")) {

				logger.info("video paused");

			}
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		video_off.click();
		if (primaryparticipantobject.getAttribute("ng-reflect-video-status").equals("1")) {

			logger.info("video play");

		}
	}

	public void lockRoomTest() throws InterruptedException {
		Thread.sleep(1000);
		lockRoom.click();// if(lockroom== true)
		boolean Roomlock = true;
		Thread.sleep(7000);

	}

	public void UnlockRoom() {

		lockRoom.click();
	}

	public void AcceptHandRaise() throws InterruptedException {
		try {
			Thread.sleep(2000);
			waitUntilVisibilityOf(Accept, 10);
		} catch (KiteInteractionException e) {
			System.out.println("Accept button not visible");
		}
		Accept.click();
	}

	public void select_resolution() throws KiteTestException {

		resolution_setting.click();

		logger.info("Resolution in meedium setting");
		if (primaryparticipantobject.getAttribute("ng-reflect-resolution").equals("240")) {

			logger.info(primaryparticipantobject.getAttribute("ng-reflect-resolution"));
		} else {

			logger.info("we not receving optimum resolution in medium setting");
		}

		try {
			waitUntilVisibilityOf(resolution_low, 2);
			resolution_low.click();
			logger.info("Resolution in low setting");
			if (primaryparticipantobject.getAttribute("ng-reflect-resolution").equals("140")) {

				logger.info(primaryparticipantobject.getAttribute("ng-reflect-resolution"));
			} else {

				logger.info("we are not receving optimum resolution in low setting");
			}

			waitUntilVisibilityOf(resolution_high, 2);
			resolution_high.click();
			logger.info("Resolution in high setting");
			if (primaryparticipantobject.getAttribute("ng-reflect-resolution").equals("360")) {

				logger.info(primaryparticipantobject.getAttribute("ng-reflect-resolution"));
			} else {

				logger.info("we are not receving optimum resolution in high setting");
			}

		} catch (KiteInteractionException e) {
			throw new KiteTestException("Issue in resolution setting", Status.SKIPPED);
		}

	}

	public void hangup() {

		try {
			Thread.sleep(20000);
			hangup.click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void my_Profile() throws InterruptedException, KiteTestException {

		userProfile.click();
		System.out.println("Clicked on My profile");
		Thread.sleep(500);
		String existingname = getProfileName.getText();
		System.out.println("Existing user name is:" + existingname);

		// Edit Profile Name
		editNameButton.click();
		// String profileName= editName.getAttribute("ng-reflect-model");
		// System.out.println("Existing user name is:"+profileName);
		editName.clear();
		String name = "Mohammad";
		editName.sendKeys(name);
		// String modifiedName = editName.getAttribute("ng-reflect-model");
		// System.out.println("Modifying name as:"+modifiedName);
		submit.click();
		Thread.sleep(2000);
		userProfile.click();

		System.out.println("After Modifying user name is:" + getProfileName.getText());
		// Verify User name updated or not
		if (getProfileName.getText().equalsIgnoreCase(name)) {
			System.out.println("User Name Modified successfully");
		} else {
			throw new KiteTestException("user name not modified", Status.SKIPPED);
		}
		userProfile.click();
	}

	public void mail_id_Check() throws KiteTestException {
		userProfile.click();

		// Compare profile mail Id with static mailId given by user
		String fetchmailid = getMailInProfile.getText();
		System.out.println("mail id is " + fetchmailid);

		if (fetchmailid.equalsIgnoreCase("imran.mohammad@smscountry.com")) {
			System.out.println("Verified User Profile ");
		} else {
			throw new KiteTestException("email id not match", Status.SKIPPED);
		}
		userProfile.click();
	}

	public void meeting_History() throws InterruptedException {
		Thread.sleep(1000);
		userProfile.click();
		meetingHistory.click();

		if (historyLayout.isDisplayed()) {
			System.out.println("Meeting History Clicked");
		} else {
			logger.error("Meeting History page is not clicked");
		}

		String members = memberslist.getText();
		// Split the members count
		String[] splitStr = members.split("\\s+");
		System.out.println("Number of participants from meeting history:" + splitStr[0]);
		int i = Integer.parseInt(splitStr[0]);
		// Comparing members count
		if (totalmemberinpanel == i) {
			System.out.println("Members count verified successfully");
		} else {
			logger.error("Failed at members count");
		}

		String startendtime = start_endTime.getText();
		System.out.println("Meeting start and End Time:" + startendtime);
		String duration = meetingDuration.getText();
		System.out.println("Meeting duration" + duration);
		String meetingdate = date.getText();
		System.out.println("Meeting date" + meetingdate);
		// fetching System date
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);

		// Comparing system date with meeting date
		if (date1.equalsIgnoreCase(meetingdate)) {
			System.out.println("Verified Meeting date successfully");
		} else {
			logger.error("Mismatch in meeting date");

		}

		/*
		 * Thread.sleep(500); if(downloadRecordings.isDisplayed()) { System.out.
		 * println("Done Recording successfully and record is available for download");
		 * } else { System.out.println("Recording is ot available"); }
		 */

		closeHistory.click();

	}

	public void signOut_MyProfile() {
		userProfile.click();
		signOut.click();
		if (homePage.isDisplayed()) {
			System.out.println("Done Signout");

		} else {
			System.out.println("Error Occured at signout");
		}

	}

	public void recodingValidation() throws InterruptedException {
		long startTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		int cou;
		for (cou = 1; cou < 30; cou++) {
			userProfile.click();
			meetingHistory.click();
			if (downloadRecordings.isDisplayed()) {
				System.out.println("gettext from recordings" + downloadRecordings.getText());
				String compare = downloadRecordings.getText();
				Thread.sleep(5000);
				if (compare.startsWith("Downloa")) {
					long endTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
					long duration = (endTime - startTime);
					System.out.println("Recordings came in" + duration + "seconds");
					System.out.println("Done Recording successfully and record is available for download");
					break;
				}
			}
			closeHistory.click();
		}
	}
}
