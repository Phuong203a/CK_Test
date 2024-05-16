package org.swat_final;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverSetup {
    public static AndroidDriver driver;

    public static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("appium:deviceName", "samsung SM-A235F");
//        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:deviceName", "Pixel 3a API 34");
        capabilities.setCapability("appium:appPackage", "com.example.vamsi.login");
        capabilities.setCapability("appium:appActivity", ".MainActivity");
        capabilities.setCapability("appium:noReset", true);
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        URL appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(appiumUrl, capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
