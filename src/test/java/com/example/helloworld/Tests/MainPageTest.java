package com.example.helloworld.Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.example.helloworld.Pages.LoginPage;
import com.example.helloworld.Pages.ProductsPage;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    //loginPage mainPage = new MainPage();
    static LoginPage lPage = new LoginPage();
    static ProductsPage products = new ProductsPage();


    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.headless = true;
        //Configuration.browser = "chrome";
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
    public void productsAvailable() {
        //Check for successful login and Sort products by low to High
        products.productList.shouldHave(text("PRODUCTS"));
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

    @Test()
    public static void lockedUsers(){
        open("/");
        lPage.username.sendKeys("locked_out_user");
        lPage.password.sendKeys("secret_sauce");
        lPage.login.click();
        products.productList.shouldNotBe(visible);
        lPage.epicSadfaceSorryThisUser.shouldHave(text("Epic sadface: Sorry, this user has been locked out.")
        );
    }
    @AfterTest
    public void tearDown() {
        closeWindow();
    }

}
