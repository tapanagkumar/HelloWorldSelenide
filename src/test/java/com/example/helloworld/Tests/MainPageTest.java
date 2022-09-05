package com.example.helloworld.Tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.example.helloworld.Pages.LoginPage;
import com.example.helloworld.Pages.ProductsPage;
import com.example.helloworld.Pages.YourCart;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    //loginPage mainPage = new MainPage();
    static LoginPage lPage = new LoginPage();
    static ProductsPage products = new ProductsPage();
    static YourCart cart = new YourCart();


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

    @Test(priority = 1)
    public void productsAvailable() {
        //Check for successful login and Sort products by low to High
        products.productList.shouldHave(text("PRODUCTS"));
    }

    @Test(priority = 2)
    public void sortByLow2High() {
        products.sortDropdown.selectOptionByValue("lohi");
        products.sortList.should(CollectionCondition.sizeGreaterThan(0));
        products.itemList.get(0).shouldHave(text("Sauce Labs Onesie"));
        products.itemList.get(2).shouldHave(text("Sauce Labs Bolt T-Shirt"));
    }

    @Test(priority = 3)
    public void sortByHigh2Low() {
        products.sortDropdown.selectOptionByValue("hilo");
        products.sortList.should(CollectionCondition.sizeGreaterThan(0));
        products.itemList.get(0).shouldHave(text("Sauce Labs Fleece Jacket"));
        products.itemList.get(2).shouldHave(text("Sauce Labs Bolt T-Shirt"));
    }

    @Test(priority = 4)
    void sortByA2Z() {
        products.sortDropdown.selectOptionByValue("az");
        products.sortList.should(CollectionCondition.sizeGreaterThan(0));
        products.itemList.get(0).shouldHave(text("Sauce Labs Backpack"));
        products.itemList.get(2).shouldHave(text("Sauce Labs Bolt T-Shirt"));
    }

    @Test(priority = 5)
    void sortByB2A() {
        products.sortDropdown.selectOptionByValue("za");
        products.sortList.should(CollectionCondition.sizeGreaterThan(0));
        products.itemList.get(0).shouldHave(text("Test.allTheThings() T-Shirt (Red)"));
        products.itemList.get(2).shouldHave(text("Sauce Labs Fleece Jacket"));
    }

    @Test
    void buyProducts(){
        products.productList.shouldHave(text("PRODUCTS"));
        products.addBackpackToCartSauceLabs.click();
        products.addBikeLightToCartSauceLabs.click();
        products.removeSauceLabsBackpack.shouldBe(visible);
        products.removeSauceLabsBikeLight.shouldBe(visible);
        products.shoppingCartLink.click();
        cart.yourCartTitle.shouldHave(text("Your Cart"));
        cart.sauceLabsBackpackInventoryItem3.should(CollectionCondition.exactTexts("Sauce Labs Backpack"));
        cart.sauceLabsBikeLightInventory.should(CollectionCondition.exactTexts("Sauce Labs Bike Light"));
        //cart.sauceLabsInventoryItem.shouldHave(text("Sauce Labs Bike Light"));

    }

    @AfterTest
    public void tearDown() {
        closeWindow();
    }

}
