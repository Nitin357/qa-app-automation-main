package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;

import java.util.Iterator;
import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on For You page*/
public class ForYou {
    //These are identifiers of elements
    public static String settingsIcon_ID="Settings";
    public static String greetingMessage_ID="textViewSalutation";
    public static String completionMomentComponent_ID="completionHeadline";
    public static String channelNames_ForYou_ID="kicker";
    public static String settings_GamesSection_ID = "gameEnd";

    //These return element directly
    //Settings icon at top right in for you page
    public static MobileElement settingsIcon()
    {return (MobileElement) driver.findElementByAccessibilityId(settingsIcon_ID);}
    //Greeting message element at top of for you page
    public static MobileElement greetingMessage()
    {return (MobileElement) driver.findElementById(greetingMessage_ID);}
    //Completion moment message at bottom of for you page
    public static MobileElement completionMomentComponent()
    {return (MobileElement) driver.findElementById(completionMomentComponent_ID);}
    //returns list of channel names of articles on for you tab
    public static List<MobileElement> channelNames_ForYou()
    {return (List<MobileElement>) driver.findElementsById(channelNames_ForYou_ID); }
    //Completion moment message at bottom of for you page
    public static MobileElement settingsGameSection()
    {return (MobileElement) driver.findElementById(settings_GamesSection_ID);}

}
