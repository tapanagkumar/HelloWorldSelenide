package com.example.helloworld.Tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.example.helloworld.Tests.MainPageTest.lPage;
import static com.example.helloworld.Tests.MainPageTest.products;

public class UserLoginTests {

    @BeforeClass
    public static void setUpAll() {
       MainPageTest.setUpAll();
    }

    @Test
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
