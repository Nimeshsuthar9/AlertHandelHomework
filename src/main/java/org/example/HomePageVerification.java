package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePageVerification extends Utils
{
    // Create Object For Load Properties Class
    LoadProp loadProp = new LoadProp();
    String expectedNameOfProduct = loadProp.getProperty("HomePageTitle");
    //create Object For Locator
    private By _homePageTitle = By.xpath("//div[@class='topic-block-title']/h2");

    //Create Method To Verify Home Page Title
    public void verifyHomePageTitle()
    {
        String actual = getTextFromElement(_homePageTitle);
        Assert.assertEquals(actual,expectedNameOfProduct,"You Back On Different Page");
    }
}