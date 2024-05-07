package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CameraAnsPhotoPage extends Utils
{
    //create Object For Locator
    private By _addToCartButton = By.xpath("//button[@class='button-2 product-box-add-to-cart-button']");

    public void verifyEachProductShouldHaveAddToCartButton()
    {
        //Store Product TitleList name
        List<WebElement> productTitleElementList = driver.findElements(_addToCartButton);

        //use For Each Loop
        for (WebElement element:productTitleElementList)
        {
            Assert.assertNotNull(element.getText(),"one of the product Add To Cart Button Missing");
        }
        System.out.println("One Of The Product Add To Cart Button Missing");
    }
}
