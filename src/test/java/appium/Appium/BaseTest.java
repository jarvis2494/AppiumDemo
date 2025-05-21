package appium.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	static final String appium_url = "127.0.0.1";
	static final String appium_url_protocol = "http://127.0.0.1:4723";
	static String apppath = "C:\\Users\\Sidh\\eclipse-workspace\\Appium\\resources\\ApiDemos-debug.apk";
	static String mainJS = "C:\\Users\\Sidh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	AndroidDriver driver;

	File file = new File(mainJS);

	AppiumDriverLocalService appiumServiceBuilder;

	@BeforeClass
	void ConfigAppium() throws MalformedURLException {

		appiumServiceBuilder = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress(appium_url).usingPort(4723)
				.build();

		appiumServiceBuilder.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 9");
		options.setApp(apppath);

		driver = new AndroidDriver(new URL(appium_url_protocol), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
		appiumServiceBuilder.stop();
	}

}
