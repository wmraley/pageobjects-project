package com.sqa.mr.auto;

import java.util.concurrent.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.testng.annotations.*;

public class BasicTest extends Core {

	public BasicTest(String baseUrl) {
		super(baseUrl, null);
	}

	@BeforeClass(enabled = true, groups = "chrome")
	public void setUpChrome() {
		// Set system property to use Chrome driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		// Setup the driver to use Chrome
		setDriver(new ChromeDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		getDriver().get(getBaseURL());
	}

	@BeforeClass(enabled = true, groups = "firefox")
	public void setUpFirefox() {
		// Setup the driver to use Firefox
		setDriver(new FirefoxDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		getDriver().get(getBaseURL());
	}

	@BeforeClass(enabled = false, groups = "ie")
	public void setUpIE() {
		// Set system property to use IE driver
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		// Setup the driver to use IE
		setDriver(new InternetExplorerDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		getDriver().get(getBaseURL());
	}

	@BeforeMethod()
	public void setupTest() {
		// getDriver().get(getBaseURL());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// quit closes all instances of the browser.
		getDriver().quit();
		// close method would close current instance only.
		// ex: driver.close();
	}
}
