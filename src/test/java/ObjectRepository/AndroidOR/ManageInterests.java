package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on For You page*/
public class ManageInterests {
    /*
    *These are identifiers of elements
     */
    public static String channelHeadings_ID="title";
    public static String healthAndFitnessChannel_XPATH="//*[@text='Health & Fitness']";
    public static String topicsOfInterestChannel_XPATH="//*[@text='Topics of Interest']";
    /*
    *These return element directly
     */
    //Columns and features
    public static MobileElement colsASndFeatures()
    {return (MobileElement) driver.findElementsByAccessibilityId(channelHeadings_ID).get(0);}
    //Games
    public static MobileElement games()
    {return (MobileElement) driver.findElementsByAccessibilityId(channelHeadings_ID).get(1);}
    //The Issues
    public static MobileElement theIssues()
    {return (MobileElement) driver.findElementsByAccessibilityId(channelHeadings_ID).get(2);}
    //around the world
    public static MobileElement aroundTheWorld()
    {return (MobileElement) driver.findElementsByAccessibilityId(channelHeadings_ID).get(3);}
    //Topics of interest
    public static MobileElement topicsOfInterest()
    {return (MobileElement) driver.findElementByXPath(topicsOfInterestChannel_XPATH);}
    //Opinion coloumnists
    public static MobileElement opinionColumnists()
    {return (MobileElement) driver.findElementsByAccessibilityId(channelHeadings_ID).get(5);}
    //Here to help
    public static MobileElement hereToHelp()
    {return (MobileElement) driver.findElementsByAccessibilityId(channelHeadings_ID).get(6);}
    //Health And Fitness
    public static MobileElement healthAndFitnessAddButton()
    {return (MobileElement) driver.findElementByXPath(healthAndFitnessChannel_XPATH);}
}