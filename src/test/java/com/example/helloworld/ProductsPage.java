package com.example.helloworld;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    public SelenideElement product = $(".title");
    public SelenideElement sortingOptions = $(By.className("product_sort_container"));

}
