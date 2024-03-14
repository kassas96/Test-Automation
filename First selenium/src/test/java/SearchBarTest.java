import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchBarTest {

    //variables
        String url="https://www.google.com/";
        String searchWord="Test Automation";
        WebDriver driver ;
    //Locators
    By searchBar= By.name("q");
    By searchStatus=By.id("result-stats");

       @Test
        public void SearchBarTest (){

           driver =new ChromeDriver();
           driver.get(url);
           driver.findElement(searchBar).sendKeys(searchWord);
           driver.findElement(searchBar).sendKeys(Keys.ENTER);
           WebElement resultStatus=driver.findElement(searchStatus);
           String res= resultStatus.getText();
          // Assert.assertEquals(resultStatus,"2400000000");
          //  Assert.assertTrue(res.contains("2400000000"));
          Assert.assertEquals(res,res.contains("823000000"));

            System.out.println(res);

       }






}
