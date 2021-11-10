package com.aires.utilities;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil {
	String fileName = System.getProperty("user.dir")+ "extentreport.html";
	public ExtentReports extent;
	public static ExtentTest currentScenario;
	public static ExtentTest features;
	public static String reportLocation = System.getProperty("user.dir")+ "/TestReports";

	public ExtentReportUtil() throws Exception {
	}
	
	public void ExtentReport() {
		extent = new ExtentReports();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Test report for aires");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Aires Test Report");
		extent.attachReporter(htmlReporter);
	}
	
	public void ExtentReportScreenshot() throws Exception {
		String screenshotPath = System.getProperty("user.dir")+"/IRISScreenShots"+"/FAIL"+".png";
		File fileObj = new File(screenshotPath);
		Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screen);
		try { 
			ImageIO.write(capture, "png", fileObj); 
		}

		catch (IOException e) { 
			e.printStackTrace();
		}
		currentScenario.fail("details").addScreenCaptureFromPath(reportLocation + "screenshot.png");
	}
	
	public void flushReport() {
		extent.flush();
	}	
}
