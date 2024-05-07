package org.example;

import org.testng.annotations.Test;


public class TestSuits extends BaseTest
{
    //Create Object For Home Page
    HomePage homePage = new HomePage();
    //Create Object For Facebook Page
    FacebookPage facebookPage = new FacebookPage();
   // Create Object For Twitter Page Verification Result page
    TwitterPageVerificationResult twitterPageVerificationResultPage = new TwitterPageVerificationResult();
    // Create Object For Home Page Verification Result page
    HomePageVerification homePageVerification = new HomePageVerification();
    // Create Object For nop Commerce News Release page
    NopCommerceNewReleasePage nopCommerceNewReleasePage = new NopCommerceNewReleasePage();
    //Create Object For Electronics Page
    ElectronicsPage electronicsPage = new ElectronicsPage();
    //Create Object For  Camera And Photo Page
    CameraAnsPhotoPage cameraAnsPhotoPage = new CameraAnsPhotoPage();
    //Create Object For Nike Product Verification Page
    NikeProductPageVerification nikeProductPageVerification = new NikeProductPageVerification();

    @Test
    public void ToVerifySearchAlertAcceptMessage()
    {
        //Click On Search Button
        homePage.clickOnSearchButton();
        elementSleep();
        alertMessageAccept();
    }
    @Test
    public void VerifyVoteAlertAcceptMessage()
    {
        //Click On Vote Button
        homePage.clickOnVoteButton();
        elementSleep();
        alertMessageAccept();
    }
    @Test
    public void toVerifyFacebookPageOpenAndCloseAndComeBackOnMainSitePage()
    {
        //Click On Facebook Button
        homePage.clickOnFacebook();
        //Process After Open Facebook And Verify Page Name And Website Url and Come Back On Main Website Page
        facebookPage.toOpenFacebookVerifyAndComeBackOnMainSite();
        //After Come Back On Main Website Page Verify Page Title
        homePageVerification.verifyHomePageTitle();
    }
    @Test
    public void toVerifyTwitterPageOpenAndCloseAndComeBackOnMainSitePage()
    {
        //click On Twitter Button
        homePage.clickOnTwitter();
        //Process After Open Twitter And Verify Page Name And Website Url and Come Back On Main Website Page
        twitterPageVerificationResultPage.toOpenTwitterVerifyAndComeBackOnMainSite();
        //After Come Back On Main Website Page Verify Page Title
        homePageVerification.verifyHomePageTitle();
    }

    @Test
    public void toVerifyNikeProductSearchIsContainNikeInAllProductNameAndUrl()
    {
        //Type Search Nike in Search Bar
        homePage.searchNikeProduct();
        //Click On Search Button
        homePage.clickOnSearchButton();
        //Verify Product Contains Nike in Name
        nikeProductPageVerification.toVerifyProductNameContainsNike();
        //Verify Page Url Contain Nike
        nikeProductPageVerification.toVerifyProductUrlContainNike();

    }
    @Test
    public void toVerifyAllProductHaveAddToCartButton()
    {
        //Click On Electronics Menu
        homePage.clickOnElectronicsMenu();
        //Click On Camera And Photo Page
        electronicsPage.clickOnCameraAndPhotoPage();
        // Verify If All Product Have Add To Cart Button Its Shows Error Because I Use  Not Null Option  in Assert
        cameraAnsPhotoPage.verifyEachProductShouldHaveAddToCartButton();
    }
    @Test
    public void toVerifyYourCommentIsLastAfterSubmit()
    {
        //Click On Details Button To Write Comment
        homePage.clickOnNopCommerceNewRelease();
        //Enter Comment Details And Click On Submit
        nopCommerceNewReleasePage.enterDetailsOnNewsPage();
    }

    @Test
    public void toVerifyProductPriceSymbolAfterChangeCurrencyIntoUsd()
    {
        //Select Usd From Currency Dropdown
        homePage.selectUsdCurrency();
        //Verify Product Price Change As Per Currency
        homePage.toVerifyProductPriceContainsDollerSign();
    }
    @Test
    public void toVerifyProductPriceSymbolAfterChangeCurrencyIntoEuro()
    {
        //Select Usd From Currency Dropdown
        homePage.selectEuroCurrency();
        //Verify Product Price Change As Per Currency
        homePage.toVerifyProductPriceContainsEuroSign();
    }
}