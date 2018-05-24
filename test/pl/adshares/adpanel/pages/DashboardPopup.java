package pl.adshares.adpanel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class DashboardPopup {
  private static final Logger LOGGER = Logger.getLogger(DashboardPopup.class);

  @FindBy(xpath = "//h6[contains(text(),'Continue as')]")
  private WebElement userPopUp;
  @FindBy(css = "[data-test='common-account-choose-publisher']")
  private WebElement userPopUpPublisher;
  @FindBy(css = "[data-test='common-account-choose-advertiser']")
  private WebElement userPopUpAdvertiser;

  private WebDriver driver;
  private WebDriverWait wait;

  public DashboardPopup(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 20);
    PageFactory.initElements(driver, this);
  }

  public void popUpPublisher() {
    try {
      wait.until(ExpectedConditions.visibilityOf(userPopUp));
      String textAssertion = driver.findElement(By.xpath("//button[@data-test='common-account-choose-publisher']")).getText();
      Assert.assertEquals(textAssertion, "Continue");
      userPopUpPublisher.click();
//      wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("cdk-overlay-pane"))));
    } catch (TimeoutException te) {
      LOGGER.info("No popup displayed");
    } finally {
      LOGGER.info("User choose publisher dashboard ");
    }
  }

  public void popUpAdvertiser() {
    try {
      wait.until(ExpectedConditions.visibilityOf(userPopUp));
      String textAssertion = driver.findElement(By.xpath("//button[@data-test='common-account-choose-advertiser']")).getText();
      Assert.assertEquals(textAssertion, "Continue");
      userPopUpAdvertiser.click();
//      wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("cdk-overlay-pane"))));
    } catch (TimeoutException te) {
      LOGGER.info("No popup displayed");
    } finally {
      LOGGER.info("User choose advertiser dashboard ");
    }
  }

}
