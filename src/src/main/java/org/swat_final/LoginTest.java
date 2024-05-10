package org.swat_final;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

public class LoginTest {

    @Before
    public void setUp() throws MalformedURLException {
        AppiumDriverSetup.setUp();
    }

    @Test
    public void loginWithEmptyCredentials() throws InterruptedException {
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));

        email.sendKeys("");
        password.sendKeys("");

        loginButton.click();

        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Enter your Email and Password to login"));
    }

    @Test
    public void loginWithEmptyEmail() throws InterruptedException {
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));

        email.sendKeys("");
        password.sendKeys("123456");
        loginButton.click();

        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Enter your Email and Password to login"));
    }

    @Test
    public void loginWithEmptyPassword() throws InterruptedException {
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));

        email.sendKeys("nguyenloi@gmail.com");
        password.sendKeys("");

        loginButton.click();
        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Enter your Email and Password to login"));
    }

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        String currentActivity = AppiumDriverSetup.driver.currentActivity();
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));

        email.sendKeys("nguyenquangloi2666@gmail.com");
        Thread.sleep(2000);
        password.sendKeys("Loi123456");
        Thread.sleep(2000);
        loginButton.click();

        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        WebElement msg = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.TextView[@text=\"You are now logged in\"]"));

        assert(msg.getText().equals("You are now logged in"));
        assert(toast.getText().equals("Login sucess"));

        Thread.sleep(2000);
        String newActivity = AppiumDriverSetup.driver.currentActivity();
        assert(!currentActivity.equals(newActivity));
    }

    @Test
    public void loginWithInvalidCredentials() throws InterruptedException {
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));

        email.sendKeys("loiivalid@gmail.com");
        Thread.sleep(2000);
        password.sendKeys("Loi123456");
        Thread.sleep(2000);
        loginButton.click();
        Thread.sleep(2000);

        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Login error"));
    }

    @Test
    public void loginWithInvalidEmail() throws InterruptedException {
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));

        email.sendKeys("loiivalidgmail.com");
        Thread.sleep(2000);
        password.sendKeys("Loi123456");
        Thread.sleep(2000);
        loginButton.click();

        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Please enter a valid email"));
    }

    @Test
    public void loginWithPasswordTooShort() throws InterruptedException {
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));

        email.sendKeys("nguyenquangloi2666@gmail.com");
        Thread.sleep(2000);
        password.sendKeys("loI56");
        Thread.sleep(2000);
        loginButton.click();

        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Password must be at least 6 characters"));
    }

    @Test
    public void loginWithInvalidPassword() throws InterruptedException {
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));

        email.sendKeys("nguyenquangloi2666@gmail.com");
        Thread.sleep(2000);
        password.sendKeys("loi123456");
        Thread.sleep(2000);
        loginButton.click();

        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Password must contain at least one uppercase letter, one lowercase letter, and one digit"));
    }

    @Test
    public void loginWithTrailingSpaces() throws InterruptedException {
        String currentActivity = AppiumDriverSetup.driver.currentActivity();
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));

        email.sendKeys("nguyenquangloi2666@gmail.com ");
        Thread.sleep(2000);
        password.sendKeys("Loi123456 ");
        Thread.sleep(2000);
        loginButton.click();
        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        WebElement msg = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.TextView[@text=\"You are now logged in\"]"));

        assert(msg.getText().equals("You are now logged in"));
        assert(toast.getText().equals("Login sucess"));

        Thread.sleep(2000);
        String newActivity = AppiumDriverSetup.driver.currentActivity();
        assert(!currentActivity.equals(newActivity));
    }

    @Test
    public void verifyOrientationChanges() throws InterruptedException {
        ScreenOrientation currentOrientation = AppiumDriverSetup.driver.getOrientation();
        if(currentOrientation.equals(ScreenOrientation.PORTRAIT)) {
            AppiumDriverSetup.driver.rotate(ScreenOrientation.LANDSCAPE);
            WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
            WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
            WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));
            WebElement tvRegister = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
            assert(email.isDisplayed());
            assert(password.isDisplayed());
            assert(loginButton.isDisplayed());
            assert(tvRegister.isDisplayed());
        } else {
            AppiumDriverSetup.driver.rotate(ScreenOrientation.PORTRAIT);
            WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
            WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
            WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));
            WebElement tvRegister = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
            assert(email.isDisplayed());
            assert(password.isDisplayed());
            assert(loginButton.isDisplayed());
            assert(tvRegister.isDisplayed());
        }
    }

    @Test
    public void verifyRegisterButton() throws InterruptedException {
        WebElement registerButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        registerButton.click();
        Thread.sleep(2000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));
        WebElement loginRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnGotoLogin"));

        assert(name.isDisplayed());
        assert(phone.isDisplayed());
        assert(gmail.isDisplayed());
        assert(password.isDisplayed());
        assert(signUpButton.isDisplayed());
        assert(loginRedirect.isDisplayed());
    }

    @Test
    public void verifyWhenLoseConnection() throws InterruptedException {
        // Turn off wifi and data connection
        AppiumDriverSetup.driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());

        System.out.println("Connection status: " + AppiumDriverSetup.driver.getConnection().isWiFiEnabled());


        String currentActivity = AppiumDriverSetup.driver.currentActivity();
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));


        email.sendKeys("nguyenquangloi2666@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("Loi123456");
        Thread.sleep(1000);

        loginButton.click();

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        WebElement msg = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.TextView[@text=\"You are now logged in\"]"));

        assert(msg.getText().equals("You are now logged in"));
        assert(toast.getText().equals("Login sucess"));

        Thread.sleep(2000);
        String newActivity = AppiumDriverSetup.driver.currentActivity();
        assert(!currentActivity.equals(newActivity));

        Thread.sleep(5000);
        // Turn on wifi and data connection after the test
        AppiumDriverSetup.driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
        System.out.println("Connection status final: " + AppiumDriverSetup.driver.getConnection().isWiFiEnabled());

    }

    @Test
    public void verifyInAirplaneMode() throws InterruptedException {
        // Turn on airplane mode
        AppiumDriverSetup.driver.toggleAirplaneMode();
        Thread.sleep(3000);

        String currentActivity = AppiumDriverSetup.driver.currentActivity();
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));

        email.sendKeys("nguyenquangloi2666@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("Loi123456");
        Thread.sleep(1000);

        loginButton.click();

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        WebElement msg = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.TextView[@text=\"You are now logged in\"]"));

        assert(msg.getText().equals("You are now logged in"));
        assert(toast.getText().equals("Login sucess"));

        Thread.sleep(2000);
        String newActivity = AppiumDriverSetup.driver.currentActivity();
        assert(!currentActivity.equals(newActivity));

        Thread.sleep(2000);
        AppiumDriverSetup.driver.toggleAirplaneMode();

    }

    @Test
    public void testSQLInjection() throws InterruptedException {
        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));

        String sqlInjectionString = "' OR '1'='1";

        email.sendKeys("nguyenquangloi2666@gmail.com");
        password.sendKeys(sqlInjectionString);

        loginButton.click();
        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Password must contain at least one uppercase letter, one lowercase letter, and one digit"));
    }

    @After
    public void tearDown() {
        AppiumDriverSetup.tearDown();
    }


}