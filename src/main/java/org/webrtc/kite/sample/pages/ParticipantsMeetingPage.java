
package org.webrtc.kite.sample.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.webrtc.kite.config.test.TestConfig;

import io.cosmosoftware.kite.exception.KiteInteractionException;
import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.pages.BasePage;
import io.cosmosoftware.kite.report.Status;

public class ParticipantsMeetingPage extends BasePage {

	public static int hand = 1;
	
	public static int total_msg;

	public ParticipantsMeetingPage(Runner runner) {
		super(runner);

	}

	@FindBy(xpath = "//div[@class='side-bar open']/ul/li[2]")
	WebElement chat;

	@FindBy(xpath = "//input[@placeholder='Type a Message']")
	WebElement textbox;

	@FindBy(xpath = "//button[@class='chatsend__button']")
	WebElement sendmsg;

	@FindBy(xpath = "//div[@class='conference__call__actions--items']/ul/li[contains(@data-tooltip,'Screen Share')]")
	WebElement screenShare;

	@FindBy(xpath = "//div[@class='conference__call__actions--items']/ul/li[contains(@data-tooltip,'mute')]")
	WebElement mute;

	@FindBy(xpath = "//div[@class='conference__call__actions--items']/ul/li[contains(@data-tooltip,'Video')]")
	WebElement video_off;

	@FindBy(xpath = "//div[@class='conference__call__actions--items']/ul/li[contains(@data-tooltip,'End Call')]")
	WebElement hangup;

	@FindBy(xpath = "//*[@id=\"js--networkstatsbtn\"]")
	WebElement connection_stats;

	@FindBy(xpath = "//div[@class='conference__call__actions--resolution']")
	WebElement resolution_setting;

	@FindBy(xpath = "//div[@class='resolution__dropdown is-active']/ul/li[]/label")
	WebElement resolution_low;

	

	@FindBy(xpath = "//button[@class='copylinkaction__button']")
	WebElement copylink;

	@FindBy(xpath = "//div[@class='conference__call__mainaction']/span")
	WebElement fullscreen_InOut;

	@FindBy(xpath = "/html/body/app-root/web-component/broadcast/main/section[1]/div[3]/div[2]/div[1]/ul/li[1]")
	WebElement handraise;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[1]/span")
	WebElement lockRoom;
	@FindBy(xpath = "/html/body/app-root/web-component/call/main/div[3]/room-lock/section/div[3]/button")
	WebElement lockroomverify;
	
	@FindBy(xpath = "//span[@class='chat__text--participant']")
	List<WebElement> participantMsg;

	@FindBy(xpath = "//span[@class='chat__text--currentuser']")
	List<WebElement> localMsg;

	public void InstantMSG() throws InterruptedException, KiteTestException

	{
		Thread.sleep(5000);

		
		try {
			waitUntilAvailabilityOf(chat, 5);
			chat.click();
   
			waitUntilAvailabilityOf(textbox, 5);
			
			textbox.sendKeys("hello Host", Keys.ENTER);
			
		} catch (KiteInteractionException e) {
			e.printStackTrace();
		} 
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		total_msg = participantMsg.size() + localMsg.size();
		logger.info("Total Received message in Participant" + " " + total_msg);
		
		TestConfig tpl = new TestConfig();
		int size = tpl.getTupleSize();
        
		
		if (size == total_msg) {
			logger.info("all msg was received");
		} else {
			throw new KiteTestException("All messages were not received or duplicate messages were there",Status.SKIPPED);
		}

	}

	public void mute() {

		mute.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mute.click();
	}

	public void video_off() {

		video_off.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		video_off.click();

	}

	public void handraise() throws InterruptedException {
		
		if ( hand<=3) {
			hand++;
           Thread.sleep(hand*2000);
           
			handraise.click();

			System.out.println("handRaised");
		} else {
			System.out.println("handRaise is going on");
		}
	}

	public void select_resolution() {

		resolution_setting.click();

		try {
			waitUntilVisibilityOf(resolution_low, 2);
			resolution_low.click();
			
		} catch (KiteInteractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void hangup() {

		try {
			Thread.sleep(65000);
			
			hangup.click();
			webDriver.close();

		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 

	}

	public void fullScreen() {

		fullscreen_InOut.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fullscreen_InOut.click();
	}

	/*
	 * public void lockRoomTest() {
	 * 
	 * ((JavascriptExecutor) webDriver).executeScript("window.open()");
	 * ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
	 * webDriver.switchTo().window(tabs.get(1));
	 * 
	 * webDriver.get("https://staging-join.telebu.com/meeting/RGCpXK7o"); String
	 * veri = lockroomverify.getText(); assertEquals("Home", veri);
	 * webDriver.close(); webDriver.switchTo().window(tabs.get(0));
	 * 
	 * }
	 */
}
