package ObjectRepository.AndroidOR;

import Parent.Constants;
import org.openqa.selenium.*;
import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the common elements (not page specific)*/
public class CommonElements {
        /*
        *These are identifiers of elements
         */
        public static String accountSelectionPopUp_ID="credential_picker_layout";
        public static String noneOfTheAboveAccountSelection_ID="cancel";
        public static String createAccountButton_ID="createAccountButton";
        public static String continueWithoutAccountButton_ID="continueButton";
        public static String continueWithoutSubscribeButton_ID="continueButton";
        public static String subscribeOptionsButton_ID="subscribeOptionsButton";
        public static String todayIcon_ID="icon";
        public static String forYouIcon_ID="icon";
        public static String sectionIcon_ID="icon";
        public static String subscriptionPopup_createAccountButton_ID="cardButton";
        public static String subscriptionPopup_loginButton_ID="login";
        public static String subscriptionPopUp_ID="card";
        public static String articleFrontSaveButton_ID="article_front_save";
        public static String articleFrontShareButton_ID="action_share";
        public static String articleFrontCommentButton_ID="action_comments";
        public static String commentFlagButton_ID="flagComment";
        public static String commentRecommendButton_ID="recommendComment";
        public static String commentReplyButton_ID="replyToComment";
        public static String flagWindow_ID="action_bar_root";
        public static String flagWindow_cancelButton_ID = "button2";
        public static String authorNameReply_ID="author_name";
        public static String savedLaterArticleHeadings_ID = "row_sf_headline";
        public static String shareMessageAndroid_Xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/com.android.internal.widget.ViewPager/android.widget.RelativeLayout/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView";
        public static String moreOptionsArticleFront_ID = "More options";
        public static String textSizeOptionArticleFront_ID = "content";
        public static String textSize_Jumbo_Xpath = "//*[@text='Jumbo']";
        public static String textSize_ExtraLarge_Xpath = "//*[@text='Extra Large']";
        public static String textSize_Large_Xpath = "//*[@text='Large']";
        public static String textSize_Medium_Xpath = "//*[@text='Medium']";
        public static String textSize_Small_Xpath = "//*[@text='Small']";
        public static String okButton_TextSizeWindow_ID = "//*[@text='OK']";
        public static String articleFront_OpinionBanner_Xpath = "//*[@text='OPINION']";
        public static String articleHeaing_Xpath = "//*[@text='How Joe Biden Can Win a Nobel Peace Prize']";
        public static String textSizeIcon_Xpath = "//*[@text='Text Size']";
        public static String getContinueWithoutAccountButton_NewAcct_ID="buttonCancel";
        public static String loginbutton_ArticleFront_Save_ID ="android:id/button1";
        public static String adSlug_Text_Xpath= "//*[@text='ADVERTISEMENT']";

        /*
        *These return element directly
         */
        //The popup for selection of account that comes at first launch of app
        public static MobileElement accountSelectionPopUp()
        {
                return (MobileElement) driver.findElementById(accountSelectionPopUp_ID);
        }

        //Option to select none of the accounts from account selection popup
        public static MobileElement noneOfTheAboveAccountSelection()
        {
                return (MobileElement) driver.findElementById(noneOfTheAboveAccountSelection_ID);
        }

        //Button to create a new account while launhing the app for the first time
        public static MobileElement createAccountButton()
        {
                return (MobileElement) driver.findElementById(createAccountButton_ID);
        }

        //Button to continue without account creation while launhing the app for the first time
        public static MobileElement continueWithoutAccountButton()
        {
                return (MobileElement) driver.findElementById(continueWithoutAccountButton_ID);
        }

        //Button to continue without subscription while launhing the app for the first time
        public static MobileElement continueWithoutSubscribeButton()
        {
                return (MobileElement) driver.findElementById(continueWithoutSubscribeButton_ID);
        }

        //Button to view subscription options while launhing the app for the first time
        public static MobileElement subscribeOptionsButton()
        {
                return (MobileElement) driver.findElementById(subscribeOptionsButton_ID);
        }

        //Today icon at bottom of application
        public static MobileElement todayIcon()
        {
                List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(todayIcon_ID);
                return bottomNavigation.get(0);
        }

        //For You icon at bottom of application
        public static MobileElement forYouIcon()
        {
                List <MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(forYouIcon_ID);
                return bottomNavigation.get(2);
        }

        //Sections icon at bottom of application
        public static MobileElement sectionsIcon()
        {
                List <MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(sectionIcon_ID);
                return bottomNavigation.get(3);
        }

        //Create account button on subscription popup window
        public static MobileElement subscriptionPopup_createAccountButton()
        {
                return (MobileElement) driver.findElementById(subscriptionPopup_createAccountButton_ID);
        }

        //Log in button on subscription popup window
        public static MobileElement subscriptionPopup_loginButton()
        {
                return (MobileElement) driver.findElementById(subscriptionPopup_loginButton_ID);
        }

        //Create account button on subscription popup window
        public static MobileElement subscriptionPopup()
        {
                return (MobileElement) driver.findElementById(subscriptionPopUp_ID);
        }

        //Save button on article front
        public static MobileElement articleFrontSaveButton()
        {
                return (MobileElement) driver.findElementById(articleFrontSaveButton_ID);
        }

        //Share button on article front
        public static MobileElement articleFrontShareButton()
        {
                return (MobileElement) driver.findElementById(articleFrontShareButton_ID);
        }

        //Comment button on article front
        public static MobileElement articleFrontCommentButton()
        {
                return (MobileElement) driver.findElementById(articleFrontCommentButton_ID);
        }

        //Flag button on Comment window
        public static MobileElement commentFlagButton()
        {
                MobileElement commentFlagButtons = (MobileElement)  driver.findElementById(commentFlagButton_ID);
                return commentFlagButtons;
        }

        //Recommend button on Comment window
        public static MobileElement commentRecommendButton()
        {
                MobileElement commentRecommendButtons = (MobileElement)  driver.findElementById(commentRecommendButton_ID);
                return commentRecommendButtons;
        }

        //Reply button on Comment window
        public static MobileElement commentReplyButton()
        {
                MobileElement commentReplyButtons = (MobileElement)  driver.findElementById(commentReplyButton_ID);
                return commentReplyButtons;
        }

        //Comment flag window
        public static MobileElement flagWindow()
        {
                return (MobileElement) driver.findElementById(flagWindow_ID);
        }

        //Cancel button on Comment flag window
        public static MobileElement flagWindow_cancelButton()
        {
                return (MobileElement) driver.findElementById(flagWindow_cancelButton_ID);
        }

        //Author name field for replying to a comment
        public static MobileElement authorNameToReply()
        {
                return (MobileElement) driver.findElementById(authorNameReply_ID);
        }

        //Article headings of all the articles in "Saved for later" section
        public static List<MobileElement> savedLaterArticleHeadings()
        {
                return (List<MobileElement>) driver.findElementsById(savedLaterArticleHeadings_ID);
        }

        //Share message on clicking share button on android TAB
        public static MobileElement shareMessageAndroid()
        {
                return (MobileElement) driver.findElementByXPath(shareMessageAndroid_Xpath);
        }

        //More options list in article front
        public static MobileElement moreOptionsArticleFront()
        {
                return (MobileElement) driver.findElementByAccessibilityId(moreOptionsArticleFront_ID);
        }

        //Text size option in article front
        public static MobileElement textSize_Articlefront()
        {
                return (MobileElement) driver.findElementsById(textSizeOptionArticleFront_ID).get(0);
        }

        //Login/SignUp option on article front
        public static MobileElement loginSignup_Articlefront()
        {
                return (MobileElement) driver.findElementsById(textSizeOptionArticleFront_ID).get(3);
        }

        //small text size option while changing text sizes
        public static MobileElement small_TextSize()
        {
                return (MobileElement) driver.findElementByXPath(textSize_Small_Xpath);
        }

        //medium text size option while changing text sizes
        public static MobileElement medium_TextSize()
        {
                return (MobileElement) driver.findElementByXPath(textSize_Medium_Xpath);
        }

        //large text size option while changing text sizes
        public static MobileElement large_TextSize()
        {
                return (MobileElement) driver.findElementByXPath(textSize_Large_Xpath);
        }

        //extra large text size option while changing text sizes
        public static MobileElement extraLarge_TextSize()
        {
                return (MobileElement) driver.findElementByXPath(textSize_ExtraLarge_Xpath);
        }

        //jumbo text size option while changing text sizes
        public static MobileElement jumbo_TextSize()
        {
                return (MobileElement) driver.findElementByXPath(textSize_Jumbo_Xpath);
        }

        //OK button on text size changing windoe
        public static MobileElement okButton_TextSizeWindow()
        {
                return (MobileElement) driver.findElementById("android:id/button1");
        }

        //Article heading of expected article "How Joe Biden ..."
        public static MobileElement articleHeaing()
        {
                return (MobileElement) driver.findElementById(articleHeaing_Xpath);
        }

        //Opinion banner on article front
        public static MobileElement opinionBannerArticleFront()
        {
                return (MobileElement) driver.findElementByXPath(articleFront_OpinionBanner_Xpath);
        }

        //text size button on article front
        public static MobileElement textSizeIcon()
        {
                return (MobileElement) driver.findElementByXPath(textSizeIcon_Xpath);
        }

        //Continue without subscription button for new user
        public static MobileElement continueWithoutSubscription_NewUser()
        {
                return (MobileElement) driver.findElementById(getContinueWithoutAccountButton_NewAcct_ID);
        }

        //Login button on tapping save on article front for anonymus user
        public static MobileElement loginButton_ArticleFront_Save()
        {
                return (MobileElement) driver.findElementById(loginbutton_ArticleFront_Save_ID);
        }

        //Text "Advertisement" used to identify ad banner
        public static MobileElement adSlug_Text()
        {
                return (MobileElement) driver.findElementByXPath(adSlug_Text_Xpath);
        }


}