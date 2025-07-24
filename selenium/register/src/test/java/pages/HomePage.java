package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
  WebDriver driver;

  By pageLink = By.xpath("//a[@href='/title/1']/p[text()='Graphics & Design']");
  By profileUser = By.xpath("//div[@class='info_profile_label']/p[text()='panda@yopmail.com']");

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public boolean isUserLoggedInIndicatorDisplayed() {
    return driver.findElement(profileUser).isDisplayed();

  }

  public void navigateToGraphicsDesignPage() {
    driver.findElement(pageLink).click();
  }
}