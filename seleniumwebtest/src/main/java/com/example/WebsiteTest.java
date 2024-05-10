package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebsiteTest {

    public static void main(String[] args) {

        
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

       
        WebDriver driver = new ChromeDriver();

       
        driver.get("https://www.apple.com/");

       
        WebDriverWait wait = new WebDriverWait(driver, 10);

        
        testCases(driver, wait);

        
        driver.quit();
    }

    public static void testCases(WebDriver driver, WebDriverWait wait) {
        checkElement(driver, wait, By.xpath("//a[@id='ac-gn-firstfocus']//span[contains(@class, 'apple-logo')]"), "Apple logo");

        checkElement(driver, wait, By.xpath("//a[contains(text(), 'Store')]"), "'Store' menu item");

        clickAndCheckElement(driver, wait, By.xpath("//a[contains(text(), 'Store')]"), By.xpath("//a[contains(text(), 'Shop')]"), "'Shop' button");

        checkElement(driver, wait, By.xpath("//a[contains(text(), 'Mac')]"), "'Mac' menu item");

        clickAndCheckElement(driver, wait, By.xpath("//a[contains(text(), 'Mac')]"), By.xpath("//a[contains(text(), 'MacBook')]"), "'MacBook' link");

        checkElement(driver, wait, By.xpath("//a[contains(text(), 'iPad')]"), "'iPad' menu item");

        clickAndCheckElement(driver, wait, By.xpath("//a[contains(text(), 'iPad')]"), By.xpath("//a[contains(text(), 'iPad Pro')]"), "'iPad Pro' link");

        checkElement(driver, wait, By.xpath("//a[contains(text(), 'iPhone')]"), "'iPhone' menu item");

        clickAndCheckElement(driver, wait, By.xpath("//a[contains(text(), 'iPhone')]"), By.xpath("//a[contains(text(), 'iPhone 13')]"), "'iPhone 13' link");

        checkElement(driver, wait, By.xpath("//a[contains(text(), 'Support')]"), "'Support' menu item");
    }

    // Belirtilen By nesnesiyle bir öğenin varlığını kontrol eden fonksiyon
    public static void checkElement(WebDriver driver, WebDriverWait wait, By by, String elementName) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            if (element.isDisplayed()) {
                System.out.println(elementName + " is displayed.");
            } else {
                System.out.println(elementName + " is not displayed.");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while checking " + elementName + ": " + e.getMessage());
        }
    }

    // Belirtilen By nesnesine tıklayıp ardından başka bir öğenin varlığını kontrol eden fonksiyon
    public static void clickAndCheckElement(WebDriver driver, WebDriverWait wait, By clickBy, By checkBy, String elementName) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickBy));
            element.click();
            WebElement checkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkBy));
            if (checkElement.isDisplayed()) {
                System.out.println(elementName + " is displayed.");
            } else {
                System.out.println(elementName + " is not displayed.");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while checking " + elementName + ": " + e.getMessage());
        }
    }
}