package com.example.helloworld.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public SelenideElement username = $("#user-name");
    public SelenideElement password = $(By.id("password"));
    public SelenideElement login = $("#login-button");
}
