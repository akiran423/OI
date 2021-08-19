package org.openIntents.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverUtility {
	Properties props;
	
	public AndroidDriver<AndroidElement> getDriver() throws IOException {
		DesiredCapabilities cap=getDesiredCapabilities();
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL(props.getProperty("url")),cap);
		return driver;
		
	}
	public DesiredCapabilities getDesiredCapabilities() throws IOException {
		FileReader reader=new FileReader("src/test/resources/oi.properties");  
	      
		props=new Properties();  
		props.load(reader);  

		File appDir=new File(props.getProperty("appDirectory"));
		File app=new File(appDir,props.getProperty("appName"));
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("deviceName"));
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "KiranPixel5");
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("automationName"));
		
		return cap;
		
	}
	public static void main(String[] a) throws IOException {
		DriverUtility util=new DriverUtility();
		util.getDriver();
	}

}
