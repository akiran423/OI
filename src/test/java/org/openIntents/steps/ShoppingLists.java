package org.openIntents.steps;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.log4j.*;
import org.openIntents.utils.DriverUtility;
import org.openIntents.utils.GeneralUtility;
import org.openqa.selenium.By;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ShoppingLists {

	AndroidDriver<AndroidElement> driver;
	Logger log = LogManager.getLogger(ShoppingLists.class);
	
	List<String> items1 = new ArrayList<String>();
	
	public ShoppingLists()
	{
		items1.add("Pencil");
		items1.add("Book");
		items1.add("Pen");
	}

	@Given("^Open OI application$")
	public void Open_OI_application() throws IOException {
		log.info("Open_OI_application Execution started");
		DriverUtility util = new DriverUtility();
		driver = util.getDriver();
		try
		{driver.findElement(By.id("org.openintents.shopping:id/layout_choice_bottom")).click();
		}
		catch (Exception e) {
			log.info("Choice to select layout was not shown after opening");
		}
		log.info(" Open_OI_application is successfully executed");
	}

	@When("^Create new list$")
	public void create_new_list() {
		log.info("create_new_list Execution started");
		// click on shopping list menu
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
		GeneralUtility.waitForPresenceOfElementLocaTed(driver, 0,
				driver.findElement(By.xpath("//*[@text='New list']")));
		// click new list option
		driver.findElement(By.xpath("//*[@text='New list']")).click();
		// enter list name
		driver.findElement(By.id("org.openintents.shopping:id/edittext")).sendKeys("List:" + Math.random());
		// Click OK
		driver.findElement(By.id("android:id/button1")).click();
		log.info("create_new_list is successfully executed");
	}

	@When("^Add few items$")
	public void Add_few_items() {
		log.info("Add_few_items Execution started");
		
		addItemsToNewList(items1);

		log.info("Add_few_items is successfully executed");
	}

	// create new list add items
	public void addItemsToNewList(List<String> items) {
		log.info("addItemsToNewList Execution started");
		driver.findElement(By.id("android:id/search_button")).click();
		// Add items
		for (String item : items) {
			
			driver.findElement(By.id("android:id/search_src_text")).sendKeys(item);
			driver.findElement(By.id("android:id/search_go_btn")).click();
		}

		log.info("addItemsToNewList is successfully executed");
	}

	@When("^Delete one item$")
	public void delete_one_item() {
		log.info("delete_one_item Execution started");
		//driver.findElementsByAndroidUIAutomator("new UiSelector().checked(false)").get(8).click();
		driver.findElementsByClassName("android.widget.CheckBox").get(0).click();
		log.info("delete_one_item is successfully executed");
	}

	@Then("^Only added elements should retain$")
	public void only_added_elements_should_retain() {
		log.info("only_added_elements_should_retain Execution started");
		assertTrue(driver.findElements(By.id("org.openintents.shopping:id/name")).get(0).isDisplayed());
		log.info("only_added_elements_should_retain is successfully executed");
	}

	@When("^Sort the list$")
	public void sort_the_list() {
		log.info("sort_the_list Execution started");
		driver.findElement(By.id("org.openintents.shopping:id/title")).click();
		log.info("sort_the_list is successfully executed");
	}

	@Then("^List items are in sorted order$")
	public void list_items_are_in_sorted_order() {
		log.info("list_items_are_in_sorted_order Execution started");
		//sort the items
		Collections.sort(items1);
		int size=driver.findElements(By.xpath("//android.widget.TextView[@resource-id='org.openintents.shopping:id/name']")).size();
		//verify items are in sorted order
		for(int i=0;i<(size-1);i++)
		{
			assertTrue(driver.findElements(By.xpath("//android.widget.TextView[@resource-id='org.openintents.shopping:id/name']")).get(i).getText().equals(items1.get(i)));
		}
		log.info("list_items_are_in_sorted_order is successfully executed");
	}

}
