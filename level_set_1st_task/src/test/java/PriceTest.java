import org.example.DocumentPage;
import org.example.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriceTest {

    @Test
    public void priceTest() {
        WebDriver driver=new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.navigateHome();
        homePage.navigateToGetpaid();

        DocumentPage doc=new DocumentPage(driver);
        String actualPrice=doc.checkPrice("Exchange a Waiver");
        Assert.assertEquals(actualPrice,"Free");
        
        doc.selectDocByPrice("149");
    }
}