package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on For You page*/
public class Sections {
    //These are identifiers of elements
    public static String mostPopular_ID="title_sections";


    //These return element directly
    //Settings icon at top right in for you page
    public static MobileElement mostPopular()
    {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(0);
    }
    public static MobileElement immersive()
    {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(14);
    }
    public static MobileElement savedForLater()
    {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(36);
    }
}
