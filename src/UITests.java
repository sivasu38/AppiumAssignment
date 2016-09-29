import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class UITests {

	public static AppiumDriver driver;

	@BeforeClass
	public void setupCapabilites()
	{
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("browserName", "");
		desiredCapabilities.setCapability("newCommandTimeout", "500");
		desiredCapabilities.setCapability("automationName",
					"appium");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceType", "phone");
		desiredCapabilities.setCapability("deviceName", "Android Emulator");
		desiredCapabilities.setCapability(CapabilityType.VERSION, "4.3");
		desiredCapabilities.setCapability(CapabilityType.PLATFORM,
					"Mac");
		desiredCapabilities.setCapability(
				CapabilityType.SUPPORTS_JAVASCRIPT, true);
		desiredCapabilities.setCapability(CapabilityType.HAS_TOUCHSCREEN,
				true);
		desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,
				true);
		desiredCapabilities
					.setCapability(
							"app",
							System.getProperty("user.dir")
									+ "/res/app-debug.apk");
		desiredCapabilities.setCapability("appPackage",
				"com.myntra.networkanalyzer");

		desiredCapabilities
				.setCapability("appWaitActivity",
						"com.myntra.networkanalyzer.MainActivity");
		desiredCapabilities
				.setCapability("appActivity",
						"com.myntra.networkanalyzer.MainActivity");
		try {
			driver = new AndroidDriver(new URL(
                    "http://127.0.0.1:4723/wd/hub"),
                    desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void FirstTest()
	{
       driver.findElements(By.className("android.widget.RelativeLayout")).get(0).click();
	   String assertionText = driver.findElements(By.className("android.widget.TextView")).get(1).getText();
       Assert.assertNotNull(assertionText,"The expected dataUsage Details were not fetched");
	}

}
