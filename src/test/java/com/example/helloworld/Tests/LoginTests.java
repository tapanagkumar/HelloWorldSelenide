package com.example.helloworld.Tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;


public class LoginTests extends MainPageTest {
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

    @Test(enabled = false)
    public static void problemUser()
    {
        //yet to be developed
    }

}
// mvn  clean  -Dselenide.browser="safari" -Dtest="MainPageTest, LoginTests" test
