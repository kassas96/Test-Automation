
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class Lec3 {

    private WebDriver driver;   //This line declares a private instance variable driver of type WebDriver, which will be used to control the web browser.

    @org.testng.annotations.Test
    public void testDemo(){

        WebDriverManager.chromedriver().setup();    //This line uses the WebDriverManager library to automatically download and set up the ChromeDriver executable.
                                                    // It ensures that the appropriate version of ChromeDriver is used and available on the system.

        ChromeOptions options = new ChromeOptions();    //This line creates an instance of ChromeOptions,
                                                        // which allows you to set various configuration options for the ChromeDriver.

        options.addArguments("--remote-allow-origins=*");   //This line adds the --remote-allow-origins=* argument to the ChromeOptions.
                                                            // This argument allows remote origins to access the browser via WebDriver.
                                                            // It can be used to overcome cross-origin restrictions during automated testing.

        driver = new ChromeDriver(options);     //This line creates a new instance of ChromeDriver with the provided options and assigns it to the driver variable.
                                                // This initializes the WebDriver instance, which allows you to interact with the Chrome browser programmatically.


        driver.get("https://www.saucedemo.com/");

       // By loginPageHeaderSelector = By.className("login_logo");
       // WebElement loginPageHeader = driver.findElement(loginPageHeaderSelector);
        By usernameField=By.id("user-name");
        driver.findElement(usernameField).sendKeys("standard_user");
        By passwordField = By.id("password");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        By loginButton= By.id("login-button");
        driver.findElement(loginButton).click();
// System.out.println(loginPageHeader.getText());
      //  Assert.assertEquals(loginPageHeader.getText(),"Swag Labs1","login page header does not match requirement");
// driver.quit();

        //add an item in cart
        String genericPathForItems="//div[text()=\"%s\"]/parent::a/parent::div/following-sibling::div[@class=\"pricebar\"]/button";
        String itemName="Sauce Labs Backpack";
        String specificItem=String.format(genericPathForItems,itemName);
        By desiredItem =By.xpath(specificItem);
        driver.findElement(desiredItem).click();

        //go to cart to assert that the item is added
        By cartButton= By.cssSelector(".shopping_cart_badge");
        driver.findElement(cartButton).click();

        By itemAddedInCart=By.cssSelector(".inventory_item_name");
        Assert.assertEquals(driver.findElement(itemAddedInCart).getText(),itemName);


    }
}