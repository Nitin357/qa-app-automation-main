package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on For You page*/
public class ManageInterests {
    //These are identifiers of elements
    public static String channelHeadings_ID="title";
    public static String healthAndFitnessChannelAddButton_ID="1603697c-f9df-4a85-bdfd-f1a2429648da";


    //These return element directly
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
    {return (MobileElement) driver.findElementsByAccessibilityId(channelHeadings_ID).get(4);}
    //Opinion coloumnists
    public static MobileElement opinionColumnists()
    {return (MobileElement) driver.findElementsByAccessibilityId(channelHeadings_ID).get(5);}
    //Here to help
    public static MobileElement hereToHelp()
    {return (MobileElement) driver.findElementsByAccessibilityId(channelHeadings_ID).get(6);}
    //Health And Fitness
    public static MobileElement healthAndFitnessAddButton()
    {return (MobileElement) driver.findElementsByAccessibilityId(healthAndFitnessChannelAddButton_ID);}


}
