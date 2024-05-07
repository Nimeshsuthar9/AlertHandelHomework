package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class TwitterPageVerificationResult extends Utils
{
    // Create Object For Load Properties Class
    LoadProp loadProp = new LoadProp();
    String expectedNameOfProduct = loadProp.getProperty("TwitterPageName");
    //create Object For Locator
    private By _pageName = By.xpath("//div[@class='css-1rynq56 r-bcqeeo r-qvutc0 r-37j5jr r-adyw6z r-135wba7 r-1vr29t4 r-1awozwy r-6koalj r-1udh08x']");

    //Create Method To Verify Product Name Is Same as You Add Product In To Cart
    public void verifyPageName()
    {
        String actual = getTextFromElement(_pageName);
        Assert.assertEquals(actual,expectedNameOfProduct,"You Open Different Page");
    }
    //Create Method To Verify page Url
    public void verifyPageUrl()
    {
        String URl = driver.getCurrentUrl();
        Assert.assertTrue(URl.contains("twitter"),"Your URL Does Not Contains Facebook");
    }

    public void toOpenTwitterVerifyAndComeBackOnMainSite()
    {
        String MainWindow=driver.getWindowHandle();
        // To handle all new opened window.
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();
        while(i1.hasNext())
        {
            String ChildWindow=i1.next();
            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {
                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                //Verify Twitter Page Title
                verifyPageName();
                //Verify page Url Contains Twitter
                verifyPageUrl();
                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }
}
