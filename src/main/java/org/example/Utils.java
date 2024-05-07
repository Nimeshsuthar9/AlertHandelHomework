package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage
{
    // Create New Click On Element Method For Reusability
    public static void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }
    // Create New Type Text Method For Reusability
    public static void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    // Create New Get Text From Element Method For Reusability
    public static String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }
    public static String randomDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyhhmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    // Create Method For Screen Shot
    public  static void takeSnapShot(String text)
    {
        //Convert Web Driver Object To Take Screen Shot
        TakesScreenshot scrShot =((TakesScreenshot)driver );
        //Call Get Screenshot As Method To Create Image File
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        // Copy File Destination
        try
        {
            FileUtils.copyFile(SrcFile, new File("src/ScreenShot/"+text+randomDate()+".png"));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    //Create Implicit Wait Method For Reusability
    public static void toDriverWaitForFewSecond()
    {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
    //Create Method For Alert Accept Message
    public static void alertMessageAccept()
    {
        driver.switchTo().alert().accept();
    }
    //sleep method
    public static void elementSleep()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
    //method to use Explicit Wait for Cookies For Facebook
    public static void elementToBeClickableForCookies()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20) );
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='x1n2onr6 x1ja2u2z x78zum5 x2lah0s xl56j7k x6s0dn4 xozqiw3 x1q0g3np xi112ho x17zwfj4 x585lrc x1403ito x972fbf xcfux6l x1qhh985 xm0m39n x9f619 xn6708d x1ye3gou xtvsq51 x1r1pt67']"))).click();
    }
}