package pl.adshares.adpanel.pages.publisher;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pl.adshares.adpanel.tools.RandomPage;

import java.util.List;
import java.util.Random;

public class SiteAdditionalTargeting {

  @FindBy(css = "[data-test='publisher-edit-site-save-and-continue']")  private WebElement saveButtonPublisherCampaign;
  @FindBy(css = "[data-test='publisher-edit-site-save-as-draft']")      private WebElement backButtonPublisherCampaign;
  @FindBy(css = "div.targeting-select-wrapper")                         private WebElement publisherList;
  @FindBy(xpath = "//button[contains(text(), 'Add Selected')]")         private WebElement addSelectedButton;
  @FindBy(xpath = "//div[@data-test='common-targeting-select-navigate-to-parent-button']/following-sibling::div[@class='ng-star-inserted']") private WebElement subTypes;
  @FindBy(css = "[data-test='publisher-edit-site-navigate-back']")      private WebElement back;
  @FindBy(css = "[data-test='publisher-edit-site-save-as-draft']")      private WebElement saveAsDraft;

  private WebDriver driver;
  private WebDriverWait wait;

  public SiteAdditionalTargeting(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 5000);
    PageFactory.initElements(driver, this);
  }

  /**
   * default List index
   * 1st index = creative type
   * 2nd index = Language
   * 3rd index = Screen
   * 4th index = Js support
   */
  public void publisherRequiresCreativeType() throws InterruptedException {
    wait.until(ExpectedConditions.visibilityOf(publisherList));
    Thread.sleep(1000);
    List<WebElement> pubList = publisherList.findElements(By.cssSelector("[data-test='common-targeting-select-option']"));
    WebElement creaviteType = pubList.get(0);
    creaviteType.click();
    List<WebElement> od = publisherList.findElements(By.xpath("//div[@data-test='common-targeting-select-navigate-to-parent-button']/following-sibling::div[@class='ng-star-inserted']"));
    for (int i = 0; i < 4; i++) {
      int random = (int) (Math.random() * (1) + (-4));
      Random rand = new Random();
      int randomProduct = rand.nextInt(od.size());
      od.get(randomProduct).click();
      Assert.assertTrue(addSelectedButton.isEnabled());
    }
    addSelectedButton.click();
  }

  public void publisherRequiresLanguage() {
    wait.until(ExpectedConditions.visibilityOf(publisherList));
    List<WebElement> pubList = publisherList.findElements(By.cssSelector("[data-test='common-targeting-select-option']"));
    WebElement requiresLanguage = pubList.get(1);
    requiresLanguage.click();
    List<WebElement> od = publisherList.findElements(By.xpath("//div[@data-test='common-targeting-select-navigate-to-parent-button']/following-sibling::div[@class='ng-star-inserted']"));
    for (int i = 0; i < 3; i++) {
      int random = (int) (Math.random() * (1) + (-3));
      Random rand = new Random();
      int randomProduct = rand.nextInt(od.size());
      od.get(randomProduct).click();
      Assert.assertTrue(addSelectedButton.isEnabled());
    }
    addSelectedButton.click();
  }

  public void publisherRequiresScreen() {
    wait.until(ExpectedConditions.visibilityOf(publisherList));
    List<WebElement> pubList4 = publisherList.findElements(By.cssSelector("[data-test='common-targeting-select-option']"));
    WebElement requiresScreen4 = pubList4.get(2);
    requiresScreen4.click();
//    Height/Width
    wait.until(ExpectedConditions.visibilityOf(publisherList));
    List<WebElement> pubList3 = publisherList.findElements(By.cssSelector("[data-test='common-targeting-select-option-label']"));
    WebElement requiresScreen3 = pubList3.get(1);
    requiresScreen3.click();
    List<WebElement> od = publisherList.findElements(By.xpath("//div[@data-test='common-targeting-select-navigate-to-parent-button']/following-sibling::div[@class='ng-star-inserted']"));
    for (int i = 0; i < 2; i++) {
      int random = (int) (Math.random() * (1) + (-2));
      Random rand = new Random();
      int randomProduct = rand.nextInt(od.size());
            od.get(randomProduct).click();
      Assert.assertTrue(addSelectedButton.isEnabled());
    }
    addSelectedButton.click();
  }

  public void publisherRequiresJsSupport() {
    wait.until(ExpectedConditions.visibilityOf(publisherList));
    List<WebElement> pubList = publisherList.findElements(By.cssSelector("[data-test='common-targeting-select-option']"));
    WebElement requiresJsSupport = pubList.get(3);
    requiresJsSupport.click();
    List<WebElement> od = publisherList.findElements(By.xpath("//div[@data-test='common-targeting-select-navigate-to-parent-button']/following-sibling::div[@class='ng-star-inserted']"));
    for (int i = 0; i < 1; i++) {
      int random = (int) (Math.random() * (1) + (-1));
      Random rand = new Random();
      int randomProduct = rand.nextInt(od.size());
      od.get(randomProduct).click();
      Assert.assertTrue(addSelectedButton.isEnabled());
    }
    addSelectedButton.click();
  }

  public void goToCreateAds() {
    wait.until(ExpectedConditions.visibilityOf(saveButtonPublisherCampaign));
    saveButtonPublisherCampaign.click();
    int id = (int) RandomPage.getFromId("id");
    System.out.println(id+". Additional Targeting - OK"); id=id+1;
    RandomPage.createId();
    RandomPage.id("id", id);

  }
  public void saveAsDraft() {
    wait.until(ExpectedConditions.visibilityOf(saveAsDraft));
    saveAsDraft.click();
    int id = (int) RandomPage.getFromId("id");
    System.out.println(id+". Additional Targeting - SaveAsDraft"); id=id+1;
    RandomPage.createId();
    RandomPage.id("id", id);
  }
  public void back() {
    wait.until(ExpectedConditions.visibilityOf(back));
    back.click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
    int id = (int) RandomPage.getFromId("id");
    System.out.println(id+". Back Additional Targeting - OK"); id=id+1;
    RandomPage.createId();
    RandomPage.id("id", id);
  }
}