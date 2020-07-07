package org.webrtc.kite.sample.checks;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintStream;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;


import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.report.AllureStepReport;
import io.cosmosoftware.kite.steps.TestStep;

public class ConsoleLogs extends TestStep  {

	private static int runCount = 0;
	public ConsoleLogs(Runner runner) {
		super(runner);

	}

	public void get_browser_console_log(String TestName, AllureStepReport stepreport)  {

		Ifilename.getFileName();
		String fileName = "browserlog"+"-"+Ifilename.getFileName()+".log";

		File file = new File(fileName);

		/*
		 * PrintStream o = null; try { o = new PrintStream(file); } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
       
		StringBuilder sb = new StringBuilder();
		/*
		 * o.append("In"+" "+TestName); o.append("\n\n");
		 */
		
		for (LogEntry entry : logEntries) {
			if (entry.getMessage().contains("ERROR")) {
				
				sb.append(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
				sb.append("\n");
				
				/*
				 * o.append(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " +
				 * entry.getMessage()); o.append("\n");
				 */
			}
		}
	
		if (sb.toString().length() > 0) {
			logger.info("Console Error Present, please checks Allure report for that");
			reporter.textAttachment(stepreport, TestName+" "+" browser log", sb.toString(), "plain");
			 
		}
		//clearConsoleErrors();
	}

	public void clearConsoleErrors() {
		JavascriptExecutor js = ((JavascriptExecutor) webDriver);
		String script = "console.clear();";
		js.executeScript(script);

	}

	@Override
	protected void step() throws KiteTestException {
		// TODO Auto-generated method stub

	}

	@Override
	public String stepDescription() {
		// TODO Auto-generated method stub
		return " browser console log ";
	}

}
