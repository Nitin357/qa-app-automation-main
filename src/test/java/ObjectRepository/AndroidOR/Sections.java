package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on For You page*/
public class Sections {
    /*
    These are identifiers of elements
     */
    public static String mostPopular_ID = "title_sections";
    public static String searchButton_ID = "Search";
    public static String searchField_ID = "search_src_text";
    public static String searchResultArticleHeadings_ID = "row_search_headline";

    /*
    These return element directly
     */
    //Settings icon at top right in for you page
    public static MobileElement mostPopular() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(0);
    }

    //"IMMERSIVE" option in sections
    public static MobileElement immersive() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(14);
    }

    //"Saved for later" option in sections
    public static MobileElement savedForLater() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(36);
    }

    //"Saved for later" option in sections
    public static MobileElement recentlyViewed() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(41);
    }

    //Search button on top right
    public static MobileElement searchButton() {
        MobileElement searchButton = (MobileElement) driver.findElementById(searchButton_ID);
        return searchButton;
    }

    //Search firld that appears on clicking search button
    public static MobileElement searchField()
    {
        MobileElement searchField = (MobileElement) driver.findElementById(searchField_ID);
        return searchField;
    }

    //Headings of articles that appear on search
    public static List<MobileElement> searchResultArticleHeadings()
    {
        List <MobileElement> searchResultAtricleHeadings = (List<MobileElement>) driver.findElementsById(searchResultArticleHeadings_ID);
        return searchResultAtricleHeadings;
    }

}
