package com.myproject.test;

import com.myproject.WebDriverSettings;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myproject.pages.GoogleLoginPage;

public class LoginAsGoogleTest extends WebDriverSettings {
    public LoginAsGoogleTest(WebDriver driver) {
        super(driver);
    }
    @Test
    public void collaborationWithGoogle(){
        GoogleLoginPage googleLoginPage = PageFactory.initElements(WebDriverSettings.driver, GoogleLoginPage.class);
        checkThatSiteIsOpen(ROZETKA_URL,driver.getCurrentUrl());        // STEP
        googleLoginPage.enterToPersonProfile();                         // click on 'войдите в личный кабинет'
        googleLoginPage.loginAsGoogle();                                // click on 'Google' button
        googleLoginPage.navigateToGoogleWindow();                       // Switch to google Login window
        googleLoginPage.clickToEmailField();                            // click on input field 'Email'
        googleLoginPage.enterEmail("Artem.Rud.Softserve@gmail.com");
        googleLoginPage.clickToEnterPassword();
        googleLoginPage.enterPassword("vfcnth1995");
        Assert.assertEquals(WebDriverSettings.driver.findElement(By.xpath("//a[@class='header-toplin" +
                "e__user-link link-dashed']")).getText(),"Артем Рудь"); // check that user was logged
    }
    @Step("Check that site htpps://rozetka.com.ua/ is open")
    public void checkThatSiteIsOpen(String expected,String actual){
        Assert.assertEquals(expected, actual);
    }
}
