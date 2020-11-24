package com.myproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    public static final String ROZETKA_URL = "https://rozetka.com.ua/";
    protected static WebDriver driver;

    public WebDriverSettings (WebDriver driver){
        WebDriverSettings.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @BeforeTest
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(ROZETKA_URL);
    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

}