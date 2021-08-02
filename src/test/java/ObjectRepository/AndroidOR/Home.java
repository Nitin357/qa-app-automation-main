package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on Home page*/
public class Home {
    /*
    * These are ElementLocators
    */
    public static String homeTabArticles_ID="root_layout";

    /*
    * These return home tab articles list
    */
    //List of articles on home tab
    public static List<MobileElement> homeTabArticles()
    {
        List<MobileElement> homeTabArticles = (List<MobileElement>) driver.findElementsById(homeTabArticles_ID);
        return homeTabArticles;
    }

}
