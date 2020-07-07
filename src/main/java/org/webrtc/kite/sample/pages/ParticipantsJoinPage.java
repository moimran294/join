package org.webrtc.kite.sample.pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cosmosoftware.kite.exception.KiteInteractionException;
import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.pages.BasePage;
import io.cosmosoftware.kite.report.Status;

public class ParticipantsJoinPage extends BasePage {
	
	public static String LockroomMessage=null;

	public ParticipantsJoinPage(Runner runner) {
		super(runner);
		webDriver.manage().window().maximize();
	

	}

	

	public static int i = 1;

	@FindBy(xpath = "//button[@class='transprent__button']")
	WebElement skip;

	@FindBy(xpath = "//input[@name='userName']")
	WebElement meetingname;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement next;

	@FindBy(xpath = "//div/room-lock//h3")
	WebElement LockRoomMsg;
	@FindBy(xpath = "//div[@class='paper width-md nickname-popup']/div/div/label")
	WebElement permissionmsg;
	
	@FindBy(xpath = "//video[@id='vid']")
	WebElement echoVideotest;

	

	public void joinMeetingRoom() throws InterruptedException {
		
		do {
			
			Thread.sleep(2000);
		}while(HostJoinPage.generatedroomId==null);

		//System.out.println(HostJoinPage.generatedroomId);
	
		webDriver.navigate().to(HostJoinPage.generatedroomId);
	
	

	}

	public void joinWebinarRoom() throws InterruptedException {

		do {
			
			Thread.sleep(2000);
		}while(HostJoinPage.generatedroomId==null);


	
		webDriver.navigate().to(HostJoinPage.generatedroomId);

	}

	public void SkipEchotest() throws InterruptedException, KiteTestException {

		try {
			Thread.sleep(2000);
			waitUntilVisibilityOf(skip, 5);
		} catch (KiteInteractionException e) {
			
			throw new KiteTestException("Skip button not visible", Status.SKIPPED);
		}

		if (skip.isDisplayed() && echoVideotest.isDisplayed()) {
			
			skip.click();
		}

		else {
			logger.info(permissionmsg.getText());
			webDriver.close();
		}

	}

	public void meetingname() {
		
		meetingname.sendKeys(i++ +" "+"Automated_Participant");

		
		try {
			waitUntilVisibilityOf(next, 5);
		} catch (KiteInteractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		next.click();

	}
	
	public void LockRoomTest() throws KiteInteractionException, InterruptedException {
		
		Thread.sleep(3000);
		((JavascriptExecutor) webDriver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs.get(1));
	
		webDriver.get(HostJoinPage.generatedroomId);
		
		waitUntilVisibilityOf(LockRoomMsg, 10);
		if(LockRoomMsg.isDisplayed()) {
		LockroomMessage= LockRoomMsg.getText();
		}
		webDriver.close();
		webDriver.switchTo().window(tabs.get(0));
		//Room has been locked
	}
}
