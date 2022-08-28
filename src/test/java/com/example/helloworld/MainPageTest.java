package com.example.helloworld;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    //loginPage mainPage = new MainPage();
    LoginPage lPage = new LoginPage();


    @BeforeClass
    public static void setUpAll() {

        Configuration.browserSize = "1280x800";
        Configuration.browser="chrome";
        Configuration.baseUrl="https://www.saucedemo.com";
        Configuration.headless=false;
    }

    @BeforeMethod
    public void setUp() {
        open("/");
        lPage.username.sendKeys("standard_user");
        lPage.password.sendKeys("secret_sauce");
        lPage.login.click();
    }

    @Test
    public void products() throws InterruptedException {
       // $(".title").shouldHave(attribute("value", "Selenium"));
        $(".title").shouldHave(text("PRODUCTS"));
       // String product_sort_container = "lo";
        //String product_sort_container1 = "product_sort_container";
        Select select = new Select($(By.className("product_sort_container")));
        select.selectByValue("lohi");
        Thread.sleep(13000);
    }




}
