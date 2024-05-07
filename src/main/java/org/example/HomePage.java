package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class HomePage extends Utils
{

    //Create Method For Click On Search Button
    public void clickOnSearchButton()
    {
        //Click On Search Button
        clickOnElement(By.xpath("//button[@class='button-1 search-box-button']"));
    }
    //Create Method For Click On Vote Button
    public void clickOnVoteButton()
    {
        //Click On Vote Button
        clickOnElement(By.id("vote-poll-1"));
    }
    //Create Method For Click On Facebook Button
    public void clickOnFacebook()
    {
        //Click On Facebook Button
        clickOnElement(By.xpath("//ul/li[@class='facebook']"));
    }
    //Create Method For Click On Twitter Button
    public void clickOnTwitter()
    {
        //Click On Twitter
        clickOnElement(By.xpath("//ul/li[@class='twitter']"));
    }
    //Create Method For Click On nopCommerce News Release1
    public void clickOnNopCommerceNewRelease()
    {
        clickOnElement(By.linkText("nopCommerce new release!"));
    }
    //Create method For Select Euro Currency
    public void selectEuroCurrency()
    {
        Select select = new Select(driver.findElement(By.id("customerCurrency")));
        select.selectByIndex(1);
        elementSleep();
    }
    public void toVerifyProductPriceContainsEuroSign()
    {
        String expectedProductName = getTextFromElement(By.xpath("//div[@class='prices']"));
        Assert.assertTrue(expectedProductName.startsWith("€"),"Product Product Price Does Not Contain €");
    }
    //Create method For Select Usd Currency
    public void selectUsdCurrency()
    {

        WebElement Usd = driver.findElement(By.id("customerCurrency"));
        Select select = new Select(Usd);
        select.selectByIndex(0);

    }
    public void toVerifyProductPriceContainsDollerSign()
    {
        String expectedProductName = getTextFromElement(By.xpath("//div[@class='prices']"));
        Assert.assertTrue(expectedProductName.startsWith("$"),"Product Product Price Does Not Contain $");
    }
    //Create Method For Search Nike Product
    public void searchNikeProduct()
    {
        typeText(By.xpath("//input[@class='search-box-text ui-autocomplete-input']"),"Nike");
    }
    //Create Method For Click On Electronics
    public void clickOnElectronicsMenu()
    {
        clickOnElement(By.linkText("Electronics"));
    }
}