package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on For You page*/
public class Podcasts {
    /*
    These are identifiers of elements
     */
    public static String podcastsPage_ID = "collection-podcasts";
    public static String podcastPlayButton_ID = "LISTEN";
    public static String podcastsIndicator_ID="";
    /*
    These return element directly
     */
    public static MobileElement podcastPage()
    {
        return (MobileElement) driver.findElementById(podcastsPage_ID);
    }
    public static MobileElement playButton()
    {
        return (MobileElement) driver.findElementById(podcastPlayButton_ID);
    }
    public static MobileElement podcastIndicator()
    {
        return (MobileElement) driver.findElementById(podcastsIndicator_ID);
    }
}
