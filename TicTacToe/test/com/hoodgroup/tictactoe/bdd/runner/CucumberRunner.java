/**
 * File: CucumberRunner.java
 * Creation Date: May 26, 2022
 *
 * Copyright © 2022 by HOOD GmbH – all rights reserved 
 */
package com.hoodgroup.tictactoe.bdd.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * The <code>CucumberRunnter</code> is the main class for running the gherkin
 * scenarios as a JUnit test.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="test/com/hoodgroup/tictactoe/bdd/features", glue = "com.hoodgroup.tictactoe.bdd.steps", publish=true)
public class CucumberRunner {

}
