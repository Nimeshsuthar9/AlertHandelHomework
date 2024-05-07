package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class FacebookPageVerificationResult extends Utils
{
    // Create Object For Load Properties Class
    LoadProp loadProp = new LoadProp();
    String expectedNameOfProduct = loadProp.getProperty("FacebookPageName");
    //create Object For Locator
    private By _pageName = By.xpath("//div[@class='x1e56ztr x1xmf6yo']//h1");

    //Create Method To Verify Page name
    public void verifyPageName()
    {
        Assert.assertEquals(getTextFromElement(_pageName),expectedNameOfProduct,"You Open Different  Facebook Page");
    }
    public void verifyPageUrl()
    {
        String URl = driver.getCurrentUrl();
        Assert.assertTrue(URl.contains("facebook"),"Your URL Does Not Contains Facebook");
    }
}