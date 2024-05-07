package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class NopCommerceNewReleasePage extends Utils
{
    //create Object For Locator
    private By _commentTitle = By.className("enter-comment-title");
    //create Object For Locator
    private By _comment = By.className("enter-comment-text");
    //create Object For Locator
    private By _commentButton = By.name("add-comment");

    public void enterDetailsOnNewsPage()
    {
        //Enter Comment Title
        typeText(_commentTitle,"Guest");
        //Enter Comment Text
        typeText(_comment,"Test");
        //Click On Add Comment Button
        clickOnElement(_commentButton);
    }
}
