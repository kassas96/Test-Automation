package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    String homeUrl ="https://www.levelset.com/";

    String getpaidxpath="//li[@class='top-level-link ml-sm-05 mr-sm-05 relative ml-0'] /a[text()='Get paid ']";
    String priceSelector="//span[@class='price-amount' and contains(text(),%s)]/parent::div/parent::div/div[@class='left']";
    String docSelector="//div[@class='left' and contains (text(),'%s')]";

    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void navigateHome(){

        driver.get(homeUrl);

        WebElement expectedElement= driver.findElement(By.xpath(getpaidxpath));
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(expectedElement));
    }

    public void navigateToGetpaid(){
        WebElement getpaidButton= driver.findElement(By.xpath(getpaidxpath));
        Actions actions = new Actions(driver);
        actions.doubleClick(getpaidButton).perform();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(docSelector,"Exchange a Waiver"))));
    }
}
