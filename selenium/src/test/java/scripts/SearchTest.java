package scripts;

import pages.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchTest extends BaseTest {
    SearchPage searchPage;

    @Test
    public void Search_TC04(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Try \"building mobile app\"']"));
        searchBox.clear();
        searchBox.sendKeys("facebook video ads");
        searchBox.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean result = verifyResult();
        Assert.assertTrue(result, "Found");
    }

    @Test
    public void Search_TC05(){
        searchPage = new SearchPage(getDriver());
        searchPage.searchKeyword("facebook video ads");
        boolean result = verifyResult();
        Assert.assertTrue(result, "Found");

    }

    @Test
    public void Search_TC06(){
        searchPage = new SearchPage(getDriver());
        searchPage.searchKeyword("video ads");
        boolean result = verifyResult();
        Assert.assertTrue(result, "Found");

    }

    @Test
    public void Search_TC07(){
        searchPage = new SearchPage(getDriver());
        searchPage.searchKeyword("abcd");
        boolean result = !verifyResult();
        Assert.assertTrue(result, " Not Found");

    }

    @Test
    public void Search_TC08(){
        searchPage = new SearchPage(getDriver());
        searchPage.searchKeyword("@#%%");
        boolean result = !verifyResult();
        Assert.assertTrue(result, " Not Found");

    }

    @Test
    public void Search_TC09(){
        searchPage = new SearchPage(getDriver());
        //URL trang web
        String initialUrl = driver.getCurrentUrl();
        System.out.println(initialUrl);
        searchPage.searchKeyword("");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/result/"));
        //URL sau khi để trống searchbar và nhấn Search
        String finalUrl = driver.getCurrentUrl();
        System.out.println(finalUrl);
        Assert.assertEquals(initialUrl, finalUrl, "Please enter a keyword");

    }

    @Test
    public void Search_TC10(){
        searchPage = new SearchPage(getDriver());
        searchPage.searchKeyword("FACEBOOK VIDEO ADS");
        boolean result = verifyResult();
        Assert.assertTrue(result, "Found");

    }

    private boolean verifyResult() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement found = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'service-card')][1]//div[contains(@class, 'card-body')]")));
            return found.isDisplayed();
        } catch (Exception e) {
            System.out.println("No Results Found: " + e.getMessage());
            return false;
        }
    }

}

