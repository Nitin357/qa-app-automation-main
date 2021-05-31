package ObjectRepository.AndroidOR;

import Parent.Constants;
import org.openqa.selenium.*;
import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the common elements (not page specific)*/
public class CommonElements {
        //These are identifiers of elements
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
        public static String flagWindow_ID="alertTitle";
        public static String flagWindow_cancelButton_ID = "button2";
        public static String authorNameReply_ID="author_name";
        public static String savedLaterArticleHeadings_ID = "row_sf_headline";

        public static String shareMessageAndroid_Xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView";

        //These return element directly
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
                return bottomNavigation.get(1);
        }

        //Sections icon at bottom of application
        public static MobileElement sectionsIcon()
        {
                List <MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(sectionIcon_ID);
                return bottomNavigation.get(2);
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
                List <MobileElement> commentFlagButtons = (List<MobileElement>)  driver.findElementById(commentFlagButton_ID);
                return commentFlagButtons.get(0);
        }

        //Recommend button on Comment window
        public static MobileElement commentRecommendButton()
        {
                List <MobileElement> commentRecommendButtons = (List<MobileElement>)  driver.findElementById(commentRecommendButton_ID);
                return commentRecommendButtons.get(0);
        }

        //Reply button on Comment window
        public static MobileElement commentReplyButton()
        {
                List <MobileElement> commentReplyButtons = (List<MobileElement>)  driver.findElementById(commentReplyButton_ID);
                return commentReplyButtons.get(0);
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
                return (MobileElement) driver.findElementsByXPath(shareMessageAndroid_Xpath);
        }
}