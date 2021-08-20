package org.openIntents.utils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralUtility {

	
	public static boolean waitForPresenceOfElementLocaTed(AndroidDriver<AndroidElement> driver, int timeLimitInSeconds, MobileElement element){
		boolean isElementPresent=false;
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementPresent = element.isDisplayed();
			return isElementPresent;	
		}catch(Exception e){
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		} }
}
