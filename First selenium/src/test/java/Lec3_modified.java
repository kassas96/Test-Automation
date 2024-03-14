import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

//In this test: add items with a cost lower than 20 then assert the number of items added in cart

public class Lec3_modified {
    // Variables
        WebDriver driver;
        WebDriverWait wait;
        String url = "https://www.saucedemo.com/";
        String username = "error_user";
        String password = "secret_sauce";
        String usernameId = "user-name";
        String passwordId = "password";
        String loginButtonId = "login-button";

        String genericXpathForItems="//div[@class='inventory_item_price' and number(substring-after(., '$')) < %s]/following-sibling::button";
        String itemCost="20";
        String desiredIemsXpath=String.format(genericXpathForItems,itemCost);
        String cartLinkCss="shopping_cart_link";
        String itemsInCartCss= "cart_item_label";


    // Locators
        By usernameFieldLocator = By.id(usernameId);
        By passwordFieldLocator = By.id(passwordId);
        By loginButtonLocator = By.id(loginButtonId);
        By desiredItemsLocator= By.xpath(desiredIemsXpath);
        By cartButtonLocator =By.className(cartLinkCss);
        By itemsInCartLocator = By.className(itemsInCartCss);



    @BeforeClass
    public void openChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority=1)
    public void login() {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldLocator));

        //Elements
            WebElement usernameField = driver.findElement(usernameFieldLocator);
            WebElement passwordField = driver.findElement(passwordFieldLocator);
            WebElement loginButton = driver.findElement(loginButtonLocator);

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Test (priority=2)
    public void addInCartTest() {
        List<WebElement> items=driver.findElements(desiredItemsLocator);
        for(WebElement item:items){
          // System.out.println(item);
            item.click();
        }
    }
    @Test (priority=3)
    public void NumOfItemsInCartTest(){
        WebElement cartButton= driver.findElement(cartButtonLocator);
        cartButton.click();

        List<WebElement> itemsInCart=driver.findElements(itemsInCartLocator);
        int numOfItems=itemsInCart.size();

        //System.out.println(numOfItems);
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(numOfItems,2);
        softAssert.assertAll();

    }

    @AfterTest
    public void closeChrome() {
       // driver.quit();
    }
}
