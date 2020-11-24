package com.myproject.pages;

import com.myproject.WebDriverSettings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class GoogleLoginPage extends WebDriverSettings {

    public GoogleLoginPage() {
        super(WebDriverSettings.driver);
        PageFactory.initElements(WebDriverSettings.driver, this);
    }
    public void clickOnEnterButton() {
        enterToPersonProfile.click();
    }
    public void clickOnLoginAsGoogle() {
        loginAsGoogle.click();
    }
    @FindBy(xpath = "//a[text()=' войдите в личный кабинет ']")
    private WebElement enterToPersonProfile;
    @FindBy(xpath = "//div[@class=\"modal__holder modal__holder_show_animation modal__holder_size_medium\"]")
    private WebElement popUpLoginAs;
    @FindBy(xpath = "//social/button[2]")
    private WebElement loginAsGoogle;
    @FindBy(xpath = "//*[@id='email']")
    private WebElement enterEmail;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement enterPassword;
    public void loginAsGoogle(){
        loginAsGoogle.click();
    }
    public void enterToPersonProfile(){
        enterToPersonProfile.click();
    }
    public void clickToEmailField(){
        enterEmail.click();
    }
    public void enterEmail(String email){
        enterEmail.sendKeys(email);
    }
    public void clickToEnterPassword(){
        enterPassword.click();
    }
    public void enterPassword(String password){
        enterPassword.sendKeys(password);
    }
    public void navigateToGoogleWindow(){
        String facebookWindow = WebDriverSettings.driver.getWindowHandle();
        Set<String> allWindowHandles = WebDriverSettings.driver.getWindowHandles();

        for (String childWindow : allWindowHandles) {
            if (!facebookWindow.equalsIgnoreCase(childWindow)) {
                WebDriverSettings.driver.switchTo().window(childWindow);
            }
        }
    }
}
