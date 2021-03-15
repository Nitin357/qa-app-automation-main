package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;

import static Parent.Constants.driver;

/*Contains all the elements on For You page*/
public class ForYou {

    //Settings icon at top right in for you page
    public static MobileElement settingsIcon()
    {return (MobileElement) driver.findElementByAccessibilityId("Settings");}
    //Greeting message element at top of for you page
    public static MobileElement greetingMessage()
    {return (MobileElement) driver.findElementById("textViewSalutation");}
    //Completion moment message at bottom of for you page
    public static MobileElement completionMomentComponent()
    {return (MobileElement) driver.findElementById("completionHeadline");}
}
