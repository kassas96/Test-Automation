package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocumentPage {
    String priceSelector="//span[@class='price-amount' and contains(text(),%s)]/parent::div/parent::div/div[@class='left']";
    String docSelector="//div[@class='left' and contains (text(),'%s')]";
    String priceByDocSelector="//div[@class='left' and contains (text(),'%s')]/following-sibling::div/span[@class='price-amount']";
    WebDriver driver;

    public DocumentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkPrice(String docName){
        WebElement document = driver.findElement(By.xpath( String.format(priceByDocSelector,docName)));
        String actualPrice= document.getText();
        return  actualPrice;
    }

    public void selectDocByPrice(String price){
        WebElement document = driver.findElement(By.xpath(String.format(priceSelector, price)));
        document.click();
    }

    public WebElement getDocElementByPrice(String price) {
        WebElement document = driver.findElement(By.xpath(String.format(priceSelector, price)));
        return document;
    }


}
