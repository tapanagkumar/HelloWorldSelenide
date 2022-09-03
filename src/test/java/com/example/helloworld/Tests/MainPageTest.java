package com.example.helloworld.Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.example.helloworld.Pages.LoginPage;
import com.example.helloworld.Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    //loginPage mainPage = new MainPage();
    LoginPage lPage = new LoginPage();
    ProductsPage products = new ProductsPage();


    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.baseUrl = "https://www.saucedemo.com";
        //Configuration.browser="firefox";
        Configuration.headless = true;
        //Configuration.remote="http://localhost:4444/wd/hub";
        //Map<String, Boolean> options = new HashMap<>();
        //options.put("enableVNC", true);
        //options.put("enableVideo", true);
        //options.put("enableLog", true);
        //Configuration.browserCapabilities = new FirefoxOptions();
        //Configuration.browserCapabilities.setCapability("selenoid:options", options);
    }

    @BeforeMethod
    public void setUp() {
        open("/");
        lPage.username.sendKeys("standard_user");
        lPage.password.sendKeys("secret_sauce");
        lPage.login.click();
    }

    @Test
    public void productsAvailable() throws InterruptedException {
        //Check for successful login and Sort products by low to High
        $(products.productList).shouldHave(text("PRODUCTS"));
    }

    @Test
    public void sortByLow2High() {
        products.sortDropdown.selectOptionByValue("lohi");
        products.sortList.should(CollectionCondition.sizeGreaterThan(0));
        products.itemList.get(0).shouldHave(text("Sauce Labs Onesie"));
        products.itemList.get(2).shouldHave(text("Sauce Labs Bolt T-Shirt"));
    }

    @Test
    public void sortByHigh2Low() {
            products.sortDropdown.selectOptionByValue("hilo");
            products.sortList.should(CollectionCondition.sizeGreaterThan(0));
            products.itemList.get(0).shouldHave(text("Sauce Labs Fleece Jacket"));
            products.itemList.get(2).shouldHave(text("Sauce Labs Bolt T-Shirt"));
    }

    @Test
    void sortByA2Z() {
            products.sortDropdown.selectOptionByValue("az");
            products.sortList.should(CollectionCondition.sizeGreaterThan(0));
            products.itemList.get(0).shouldHave(text("Sauce Labs Backpack"));
            products.itemList.get(2).shouldHave(text("Sauce Labs Bolt T-Shirt"));
    }

    @Test
    void sortByB2A() {
        products.sortDropdown.selectOptionByValue("za");
        products.sortList.should(CollectionCondition.sizeGreaterThan(0));
        products.itemList.get(0).shouldHave(text("Test.allTheThings() T-Shirt (Red)"));
        products.itemList.get(2).shouldHave(text("Sauce Labs Fleece Jacket"));
    }
    @AfterTest
    public void teadDown() {
        closeWindow();
    }
}
