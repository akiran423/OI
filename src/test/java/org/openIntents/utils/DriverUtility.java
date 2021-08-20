package org.openIntents.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverUtility {
	Properties props;

	/**
	 * Method to invoke Android driver with configured app in oi.properties
	 */
	public AndroidDriver<AndroidElement> getDriver() throws IOException {
		DesiredCapabilities cap = getDesiredCapabilities();
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL(props.getProperty("url")),
				cap);
		return driver;

	}

	/**
	 * Method to set desired capabilities , and return to driver as configured in
	 * oi.properties
	 */
	public DesiredCapabilities getDesiredCapabilities() throws IOException {
		FileReader reader = new FileReader("src/test/resources/oi.properties");

		props = new Properties();
		props.load(reader);

		File appDir = new File(props.getProperty("appDirectory"));
		File app = new File(appDir, props.getProperty("appName"));
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("deviceName"));
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("automationName"));
		cap.setCapability(MobileCapabilityType.PLATFORM, props.getProperty("platform"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, props.getProperty("platformVersion"));
		// cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.openintents.shopping.ui.LayoutChoiceActivity");
		// cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.openintents.shopping");
		return cap;

	}

}
