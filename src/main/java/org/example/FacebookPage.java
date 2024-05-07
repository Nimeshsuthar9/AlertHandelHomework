package org.example;

import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class FacebookPage extends Utils
{
    //create Object For Locator
    private By _clickOnCancelButton = By.xpath("//div[@class='x92rtbv x10l6tqk x1tk7jg1 x1vjfegm']");
    FacebookPageVerificationResult facebookPageVerificationResult = new FacebookPageVerificationResult();
   //Create Method For Click on cancel Button
    public void clickOnCancelButton()
    {
        //Click On Cancel Button
        clickOnElement(_clickOnCancelButton);
    }
    public void toOpenFacebookVerifyAndComeBackOnMainSite()
    {       String MainWindow=driver.getWindowHandle();
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
                //Wait For Element To Be Clickable For Facebook Cookies Accept
                elementToBeClickableForCookies();
                //Click On Cancel Button
                clickOnCancelButton();
                //Verify Facebook Page Title
                facebookPageVerificationResult.verifyPageName();
                //Verify Facebook Page URL
                facebookPageVerificationResult.verifyPageUrl();
                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }
}
