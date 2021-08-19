package org.openIntents.steps;

import java.io.IOException;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.*;
import org.openIntents.utils.DriverUtility;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ShoppingLists {

	AndroidDriver<AndroidElement> driver;
	Logger log=LogManager.getLogger(ShoppingLists.class);

	@Given("^Open OI application$")
	public void Open_OI_application() throws IOException {
		log.info("Open_OI_application Execution started");
		//DriverUtility util = new DriverUtility();
		//driver = util.getDriver();
		log.info(" Open_OI_application is successfully executed");
	}

	@When("^create new list$")
	public void create_new_list() {
		log.info("create_new_list Execution started");
		log.info("create_new_list is successfully executed");
	}

	@When("^Add few items$")
	public void Add_few_items() {
		log.info("Add_few_items Execution started");
		log.info("Add_few_items is successfully executed");
	}

	@When("^delete one item$")
	public void delete_one_item() {
		log.info("delete_one_item Execution started");
		log.info("delete_one_item is successfully executed");
	}

	@Then("^only added elements should retain$")
	public void only_added_elements_should_retain() {
		log.info("only_added_elements_should_retain Execution started");
		log.info("only_added_elements_should_retain is successfully executed");
	}

	@When("^sort the list$")
	public void sort_the_list() {
		log.info("sort_the_list Execution started");
		log.info("sort_the_list is successfully executed");
	}

	@Then("^verify sorted list items shown$")
	public void verify_sorted_list_items_shown() {
		log.info("verify_sorted_list_items_shown Execution started");
		log.info("verify_sorted_list_items_shown is successfully executed");
	}

}
