package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on For You page*/
public class Sections {
    //These are identifiers of elements
    public static String mostPopular_ID = "title_sections";
    public static String searchButton_ID = "Search";
    public static String searchField_ID = "search_src_text";
    public static String searchResultArticleHeadings_ID = "row_search_headline";

    //These return element directly
    //Settings icon at top right in for you page
    public static MobileElement mostPopular() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(0);
    }

    public static MobileElement immersive() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(14);
    }

    public static MobileElement savedForLater() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(36);
    }

    public static MobileElement searchButton() {
        MobileElement searchButton = (MobileElement) driver.findElementById(searchButton_ID);
        return searchButton;
    }

    public static MobileElement searchField()
    {
        MobileElement searchField = (MobileElement) driver.findElementById(searchField_ID);
        return searchField;
    }

    public static List<MobileElement> searchResultArticleHeadings()
    {
        List <MobileElement> searchResultAtricleHeadings = (List<MobileElement>) driver.findElementsById(searchResultArticleHeadings_ID);
        return searchResultAtricleHeadings;
    }

}
