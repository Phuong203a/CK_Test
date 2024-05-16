package org.swat_final;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.sql.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class UITest {
    @Before
    public void setUp() throws MalformedURLException {
        AppiumDriverSetup.setUp();
    }

    @Test
    public void checkButtonInLoginPage() throws InterruptedException {
        WebElement loginBtn = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));

        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assert(loginBtn.getAttribute("clickable").equals("true"));
        assert(signUpRedirect.getAttribute("clickable").equals("true"));
    }

    @Test
    public void checkButtonInRegisterPage() throws InterruptedException {
        WebElement goToRegister = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        goToRegister.click();
        Thread.sleep(2000);
        WebElement loginBtn = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnGotoLogin"));
        WebElement registerBtn = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));
        assert(loginBtn.getAttribute("clickable").equals("true"));
        assert(registerBtn.getAttribute("clickable").equals("true"));
    }

    @Test
    public void testInputValidInLoginPage() throws InterruptedException {
        WebElement emailInput = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement passWordInput  = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        assert(emailInput.getAttribute("clickable").equals("true"));
        assert(passWordInput.getAttribute("clickable").equals("true"));
        assert(emailInput.getAttribute("enabled").equals("true"));
        assert(passWordInput.getAttribute("enabled").equals("true"));
        assert(emailInput.getAttribute("displayed").equals("true"));
        assert(passWordInput.getAttribute("focusable").equals("true"));
        assert(emailInput.getAttribute("focusable").equals("true"));
        assert(passWordInput.getAttribute("password").equals("true"));

    }

    @Test
    public void testInputValidInRegisterPage() throws InterruptedException {
        WebElement goToRegister = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        goToRegister.click();
        Thread.sleep(2000);

        WebElement NameButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement PhoneButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement GmailButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement PasswordButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        assert(NameButton.getAttribute("clickable").equals("true"));
        assert(PhoneButton.getAttribute("clickable").equals("true"));
        assert(GmailButton.getAttribute("clickable").equals("true"));
        assert(PasswordButton.getAttribute("clickable").equals("true"));
        assert(NameButton.getAttribute("displayed").equals("true"));
        assert(PhoneButton.getAttribute("displayed").equals("true"));
        assert(GmailButton.getAttribute("displayed").equals("true"));
        assert(PasswordButton.getAttribute("displayed").equals("true"));
        assert(NameButton.getAttribute("focusable").equals("true"));
        assert(PhoneButton.getAttribute("focusable").equals("true"));
        assert(GmailButton.getAttribute("focusable").equals("true"));
        assert(PasswordButton.getAttribute("focusable").equals("true"));
    }
    @Test
    public void testTextInLoginPage() throws InterruptedException {
        WebElement emailInput = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement passWordInput  = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginBtn = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));

        assert(emailInput.getAttribute("text").equals("Email"));
        assert(passWordInput.getAttribute("text").equals("Password"));
        assert(loginBtn.getAttribute("text").equals("Login"));
        assert(signUpRedirect.getAttribute("text").equals("New User? Register"));

    }

    @Test
    public void testTextInRegisterPage() throws InterruptedException {
        WebElement goToRegister = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        goToRegister.click();
        Thread.sleep(2000);

        WebElement NameButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement PhoneButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement GmailButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement PasswordButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement loginBtn = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnGotoLogin"));
        WebElement registerBtn = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));
        assert(NameButton.getAttribute("text").equals("Name"));
        assert(PhoneButton.getAttribute("text").equals("Phone number"));
        assert(GmailButton.getAttribute("text").equals("Gmail"));
        assert(PasswordButton.getAttribute("text").equals("Password"));
        assert(registerBtn.getAttribute("text").equals("Register"));
        assert(loginBtn.getAttribute("text").equals("Login"));
    }
}
