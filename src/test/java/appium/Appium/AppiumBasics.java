package appium.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest {

	@Test
	void appiumBasics() throws MalformedURLException {
		
		//Click and set wifi name in Preference

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"3. Preference dependencies\")")).click();
		
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)")).click();
		
		String wifiText = driver.findElement(By.id("android:id/alertTitle")).getText();
		
	    Assert.assertEquals(wifiText, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Siddhesh");
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId('android:id/button1')")).click();

	}
	
	
}
