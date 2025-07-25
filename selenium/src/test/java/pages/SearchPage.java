package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchKeyword(String value){
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Try \"building mobile app\"']"));
        searchBox.clear();
        searchBox.sendKeys(value);
        //Nhấn Button Search
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
