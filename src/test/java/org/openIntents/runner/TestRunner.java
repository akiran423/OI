package org.openIntents.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(features = "features",glue={"org.openIntents.steps"} )

public class TestRunner {

}
