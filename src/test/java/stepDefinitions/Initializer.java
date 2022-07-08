package stepDefinitions;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Initializer extends Base {
	@Before
	public void beforeHooks(Scenario scenario) {
		logger.info("Scenario: " + scenario.getName() + " has been started");
		selectBrowser();
		openBrowser();
	}

	@After
	public void afterHooks(Scenario scenario) {
		driver.quit();
		logger.info("Scenario" + scenario.getName() + "has been ended.");
	}
}
