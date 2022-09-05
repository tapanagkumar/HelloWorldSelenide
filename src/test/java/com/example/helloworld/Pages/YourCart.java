package com.example.helloworld.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.saucedemo.com/inventory.html
public class YourCart {
    public SelenideElement yourCartTitle = $(byText("Your Cart"));
    public ElementsCollection sauceLabsBikeLightInventory = $$("#item_0_title_link div");
    public ElementsCollection sauceLabsBackpackInventoryItem3 = $$("#item_4_title_link div");

}