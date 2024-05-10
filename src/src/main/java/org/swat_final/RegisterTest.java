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

public class RegisterTest {
    @Before
    public void setUp() throws MalformedURLException {
        AppiumDriverSetup.setUp();
    }

    @Test
    public void signUpWithEmptyAllFields() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));
        signUpButton.click();

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Please fill all the details"));
    }

    @Test
    public void signUpWithEmptyName() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("");
        phone.sendKeys("0977701541");
        Thread.sleep(1000);
        gmail.sendKeys("nguyen19@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("123456");
        Thread.sleep(1000);
        signUpButton.click();


        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Please fill all the details"));
    }

    @Test
    public void signUpWithEmptyPhone() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("loi");
        phone.sendKeys("");
        Thread.sleep(1000);
        gmail.sendKeys("nguyen19@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("123456");
        Thread.sleep(1000);

        signUpButton.click();
        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Please fill all the details"));
    }

    @Test
    public void signUpWithEmptyEmail() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("loi");
        phone.sendKeys("0977701541");
        Thread.sleep(1000);
        gmail.sendKeys("");
        Thread.sleep(1000);
        password.sendKeys("123456");
        Thread.sleep(1000);

        signUpButton.click();
        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Please fill all the details"));
    }

    @Test
    public void signUpWithEmptyPassWord() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("loi");
        Thread.sleep(1000);
        phone.sendKeys("0977701541");
        Thread.sleep(1000);
        gmail.sendKeys("nguyen19@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("");
        Thread.sleep(1000);

        signUpButton.click();
        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Please fill all the details"));
    };

    @Test
    public void verifyFieldPasswordIsHidden() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        password.sendKeys("123456");
        assert(password.getAttribute("password").equals("true"));
    }

    @Test
    public void signUpWithValidCredentials() throws InterruptedException {

        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        String currentActivity = AppiumDriverSetup.driver.currentActivity();
        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("loi");
        Thread.sleep(1000);
        phone.sendKeys("0977701541");
        Thread.sleep(1000);
        gmail.sendKeys("nguyenquangloi2666@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("Loi123456");
        Thread.sleep(1000);
        signUpButton.click();

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Registration Successful"));

        Thread.sleep(3000);
        String afterClickActivity = AppiumDriverSetup.driver.currentActivity();
        assert(currentActivity.equals(afterClickActivity));
    }

    @Test
    public void signUpWithInvalidEmail() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("loi");
        Thread.sleep(1000);
        phone.sendKeys("0977701541");
        Thread.sleep(1000);
        gmail.sendKeys("nguyenquangloi2666mail");
        Thread.sleep(1000);
        password.sendKeys("123456");
        Thread.sleep(1000);

        signUpButton.click();

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Please enter a valid email"));
    }

    @Test
    public void signUpWithInvalidPhone() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("loi");
        Thread.sleep(1000);
        phone.sendKeys("097770154");
        Thread.sleep(1000);
        gmail.sendKeys("nguyenlll@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("123456");
        Thread.sleep(1000);

        signUpButton.click();
        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Please enter a valid phone number"));


    }

    @Test
    public void signUpWithPasswordTooShort() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("loi");
        Thread.sleep(1000);
        phone.sendKeys("0977701541");
        Thread.sleep(1000);
        gmail.sendKeys("ng@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("1");
        Thread.sleep(1000);

        signUpButton.click();
        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Password must be at least 6 characters"));
    }

    @Test
    public void signUpWithPasswordWeak() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("loi");
        Thread.sleep(1000);
        phone.sendKeys("0977701541");
        Thread.sleep(1000);
        gmail.sendKeys("ng@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("loi1234");
        Thread.sleep(1000);

        signUpButton.click();
        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Password must contain at least one uppercase letter, one lowercase letter, and one digit"));
    }


    @Test
    public void signUpWithRegisteredEmail() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("Loiregistered");
        Thread.sleep(1000);
        phone.sendKeys("0977701542");
        Thread.sleep(1000);

        gmail.sendKeys("nguyenquangloi2666@gmail.com");
        Thread.sleep(1000);

        password.sendKeys("Loi123456");
        Thread.sleep(1000);

        signUpButton.click();

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Email already exists, please use another email"));
    }

    @Test
    public void signUpWithRegisteredUsername() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        String currentActivity = AppiumDriverSetup.driver.currentActivity();
        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("Loiregistered");
        Thread.sleep(1000);
        phone.sendKeys("0977701521");
        Thread.sleep(1000);
        gmail.sendKeys("ngngng@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("123456Loi");
        Thread.sleep(1000);

        signUpButton.click();
        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Registration Successful"));

        Thread.sleep(3000);
        String afterClickActivity = AppiumDriverSetup.driver.currentActivity();
        assert(currentActivity.equals(afterClickActivity));
    }

    @Test
    public void signUpWithRegisteredPhone() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("Loiregistered");
        Thread.sleep(1000);
        phone.sendKeys("0977701541");
        Thread.sleep(1000);
        gmail.sendKeys("loi32@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("loiprO123456");
        Thread.sleep(1000);

        signUpButton.click();
        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Phone number already exists, please use another phone number"));

    }

    @Test
    public void clickLoginBtn() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement loginRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnGotoLogin"));
        loginRedirect.click();

        AppiumDriverSetup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement email = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLogGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etLoginPassword"));
        WebElement loginButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnLogin"));
        WebElement tvRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));

        assert(email.isDisplayed());
        assert(password.isDisplayed());
        assert(loginButton.isDisplayed());
        assert(tvRedirect.isDisplayed());
    }

    @Test
    public void verifyOrientationChanges() throws InterruptedException {
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        ScreenOrientation currentOrientation = AppiumDriverSetup.driver.getOrientation();

        if(currentOrientation.equals(ScreenOrientation.PORTRAIT)) {
            // Change the orientation to LANDSCAPE
            AppiumDriverSetup.driver.rotate(ScreenOrientation.LANDSCAPE);
            Thread.sleep(3000);

            WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
            assert(name.isDisplayed());
            WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
            assert(phone.isDisplayed());
            WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
            assert(gmail.isDisplayed());
            WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
            assert(password.isDisplayed());
            scrollToAnElementByText(AppiumDriverSetup.driver, "Register");
            WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));
            WebElement loginRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnGotoLogin"));

            assert(signUpButton.isDisplayed());
            assert(loginRedirect.isDisplayed());
        } else {
            // Change the orientation to PORTRAIT
            AppiumDriverSetup.driver.rotate(ScreenOrientation.PORTRAIT);
            Thread.sleep(3000);


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
    }

    @Test
    public void verifyWhenLoseConnection() throws InterruptedException {
        // Turn off wifi and data connection
        AppiumDriverSetup.driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());

        System.out.println("Connection status: " + AppiumDriverSetup.driver.getConnection().isWiFiEnabled());

        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("loi");
        Thread.sleep(1000);
        phone.sendKeys("0272201541");
        Thread.sleep(1000);
        gmail.sendKeys("ngu1yenqangloi2666@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("lOi123456");
        Thread.sleep(1000);

        signUpButton.click();

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Registration Successful"));

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
        WebElement signUpRedirect = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/tvRegister"));
        signUpRedirect.click();
        Thread.sleep(3000);

        WebElement name = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegName"));
        WebElement phone = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPhone"));
        WebElement gmail = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegGmail"));
        WebElement password = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/etRegPassword"));
        WebElement signUpButton = AppiumDriverSetup.driver.findElement(By.id("com.example.vamsi.login:id/btnRegLogin"));

        name.sendKeys("loi");
        Thread.sleep(1000);
        phone.sendKeys("0972301541");
        Thread.sleep(1000);
        gmail.sendKeys("nguyenquangloi2122@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("Loi123456");
        Thread.sleep(1000);

        signUpButton.click();

        WebElement toast = AppiumDriverSetup.driver.findElement(By.xpath("//android.widget.Toast[1]"));
        assert(toast.getText().equals("Registration Successful"));
        Thread.sleep(2000);

        // Turn off airplane mode after the test
        AppiumDriverSetup.driver.toggleAirplaneMode();
    }

    @After
    public void tearDown() {
        AppiumDriverSetup.tearDown();
    }

    public WebElement scrollToAnElementByText(AppiumDriver<WebElement> driver, String text) {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }
}
