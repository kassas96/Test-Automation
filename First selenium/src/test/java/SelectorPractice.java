import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectorPractice {
    //Variables
        WebDriver driver;
        String url="https://the-internet.herokuapp.com/login";

        //locators
            By usernameField= By.id("username");            // The selector is the id
            By passwordField=By.name("password");           // The selector is the name
            By paragraph =By.className("subheader");        // The selector is the class
            By loginBtn = By.cssSelector("button.radius");  // The selector is the css element (element type + " . " + class name)

    @BeforeTest
    public void openingTheBrowser(){
        driver=new ChromeDriver();      //open chrome
        driver.get(url);
        //driver.navigate().to(url);

    }


    @Test
    public void userNameTest(){
        driver.findElement(usernameField).sendKeys("medo@yahoo.com");
        driver.findElement(passwordField).sendKeys("dasd123");
        String parag =driver.findElement(paragraph).getText().toUpperCase();
        driver.findElement(loginBtn).click();
        WebElement validationStatus= driver.findElement(By.id("flash"));

        Assert.assertTrue(validationStatus.getText().contains("invalid"));
    }

    @AfterTest
    public void closeBrowser(){
       // driver.quit();
        //driver.close();
    }


}
