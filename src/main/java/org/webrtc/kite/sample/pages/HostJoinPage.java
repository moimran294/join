package org.webrtc.kite.sample.pages;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.webrtc.kite.WebDriverFactory;
import org.webrtc.kite.exception.KiteNoKeyException;
import org.webrtc.kite.tests.KiteBaseTest;

import io.cosmosoftware.kite.exception.KiteInteractionException;
import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.pages.BasePage;
import io.cosmosoftware.kite.report.Status;
import io.cosmosoftware.kite.util.WebDriverUtils;

public class HostJoinPage extends BasePage {

	private static final String TELEBU_PAGE = "https://webrtc-e0ca2.web.app/login";
    public static String generatedroomId=null;
	public static String roomId = "https://electron-app-8efac.web.app/meeting/4mK6gOkN";
	public static String webinarRoomId = "https://electron-app-8efac.web.app/broadcast/O9xBMpyCK";
	public String meetingType = null;
	static GetOTPFunctionality otppage = null;
	
	
	

	public HostJoinPage(Runner runner) {
		super(runner);
		otppage = new GetOTPFunctionality(runner);
	}
    

	
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendotp;

	@FindBy(xpath = "//input[@class='input__control--text']")
	WebElement roomlink;
	
	@FindBy(xpath = "//div[@class='error-message']/span")
	WebElement invalidOtp;

	@FindBy(xpath = "/html/body/app-root/web-component/home/main/section/section/section/room-info/div[2]/button")
	WebElement start;

	@FindBy(xpath = "/html/body/app-root/web-component/home/main/section/section/section/broadcast-info/div[2]/button")
	WebElement startWebinar;

	@FindBy(xpath = "//button[@class='transprent__button']")
	WebElement skip;

	@FindBy(xpath = "//input[@name='userName']")
	WebElement meetingname;

	@FindBy(xpath = "//div[@class='paper-foot']/button[@type='submit']")
	WebElement next;

	
	@FindBy(xpath = "/html/body/app-root/web-component/home/main/section/section/div/button[2]")
	WebElement selectWebinar;

	@FindBy(xpath = "//button[text()='Webinar']")
	WebElement Webinar;

	@FindBy(xpath = "//div[@class='paper width-md nickname-popup']/div/div/label")
	WebElement permissionmsg;

	@FindBy(xpath = "//video[@id='vid']")
	WebElement echoVideotest;
	
	
	public void openUrl(){
		
		webDriver.get(TELEBU_PAGE);
		webDriver.manage().window().maximize();
	}

	public void createRoom() throws KiteTestException, InterruptedException {
		
		email.sendKeys("imran.mohammad@smscountry.com");
		sendotp.click();
		otppage.clickEmail();
		
		try {
			
		if(roomlink.isDisplayed())
		{
			logger.info("room link is available");
		}
			
		}catch (Exception e) {
			       
                 if(invalidOtp.isDisplayed()) {
                	 logger.info("Invalid OTP ");
                	 throw new KiteNoKeyException("Invalid otp");
                 }
				
		}

	}

	public void Selectwebinar() {

		selectWebinar.click();

	}

	public void ShareMeetingLink() throws InterruptedException{
		
			
			
				
				try {
					generatedroomId = roomlink.getAttribute("placeholder");
					if(generatedroomId.equals(roomId)) {
				
					}else {
						roomId=generatedroomId;
						logger.error("generated link is not same");
					}
					}catch (Exception e) {
						logger.info("room link is not available");
					}
			}	
				
			
				
		

	

	public void ShareWebinarLink() {
		try {
			generatedroomId = roomlink.getAttribute("placeholder");
			if(generatedroomId.equals(webinarRoomId)) {
		
			}else {
				
				logger.error("generated link is not same");
			}
			}catch (Exception e) {
				logger.info("room link is not available");
			}

	}

	public void StartMeeting() {
		try {
			waitUntilVisibilityOf(start, 5);
		} catch (KiteInteractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start.click();
		System.out.println("click start");

	}

	public void StartWebinar() {
		try {
			waitUntilVisibilityOf(startWebinar, 5);
		} catch (KiteInteractionException e) {

			e.printStackTrace();
		}
		startWebinar.click();
		System.out.println("click start Webinar");

	}

	public void SkipEchotest()  {

        try {
			waitUntilAvailabilityOf(skip, 5);
		} catch (KiteInteractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (skip.isDisplayed() && echoVideotest.isDisplayed()) {
			skip.click();
		}

		else {
			logger.info(permissionmsg.getText());
			webDriver.close();
		}

		logger.info("skip echo in host");

	}

	public void UserName() {
		
		
		meetingname.clear();
		meetingname.sendKeys("Imran(Automation)");
		
       
		logger.info("filling Host name");
		
		
		next.click();

	}

}
