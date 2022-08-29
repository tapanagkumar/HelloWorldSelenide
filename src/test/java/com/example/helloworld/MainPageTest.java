package com.example.helloworld;

import com.codeborne.selenide.CollectionCondition;
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
    ProductsPage products = new ProductsPage();


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
        //Check for successful login and Sort products by low to High
        $(products.product).shouldHave(text("PRODUCTS"));
        Select select = new Select($(products.sortingOptions));
        select.selectByValue("lohi");
        //Thread.sleep(13000);
        $$(By.className("inventory_list")).should(CollectionCondition.sizeGreaterThan(0));
        $$(By.className("inventory_item")).get(0).shouldHave(text("Sauce Labs Onesie"));
        $$(By.className("inventory_item")).get(2).shouldHave(text("Sauce Labs Bolt T-Shirt"));
    }




}
