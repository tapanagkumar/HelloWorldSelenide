package com.example.helloworld.Tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.example.helloworld.Tests.MainPageTest.lPage;
import static com.example.helloworld.Tests.MainPageTest.products;

public class UserLoginTests {

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.headless = false;
    }

    @Test()
    public static void lockedUsers1() {
        open("/");
        lPage.username.sendKeys("locked_out_user");
        lPage.password.sendKeys("secret_sauce");
        lPage.login.click();
        products.productList.shouldNotBe(visible);
        lPage.epicSadfaceSorryThisUser.shouldHave(text("Epic sadface: Sorry, this user has been locked out.")
        );
    }
}
