package com.example.helloworld.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.sun.jna.Structure;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {
    public SelenideElement productList = $(".title");
    public SelenideElement sortDropdown = $(By.className("product_sort_container"));
    public ElementsCollection  sortList =  $$(By.className("inventory_list"));
    public ElementsCollection itemList = $$(By.className("inventory_item"));
    public SelenideElement addBackpackToCartSauceLabs = $("#add-to-cart-sauce-labs-backpack");
    public SelenideElement addBikeLightToCartSauceLabs = $("#add-to-cart-sauce-labs-bike-light");
    public SelenideElement removeSauceLabsBackpack = $("#remove-sauce-labs-backpack");
    public SelenideElement removeSauceLabsBikeLight = $("#remove-sauce-labs-bike-light");
    public SelenideElement shoppingCartLink = $(".shopping_cart_link");
}
