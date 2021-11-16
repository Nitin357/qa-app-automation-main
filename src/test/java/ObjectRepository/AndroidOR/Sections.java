package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

/*Contains all the elements on For You page*/
public class Sections {
    /*
    These are identifiers of elements
     */
    public static String mostPopular_ID = "title_sections";
    public static String searchButton_AccessiblityID = "Search";
    public static String searchField_ID = "search_src_text";
    public static String searchResultArticleHeadings_ID = "row_search_headline";
    public static String recentlyViewedArticleHeadings_ID = "row_recently_viewed_headline";
    public static String mostPopularHeader_Xpath = "//*[@text='Most Popular']";
    /*
    These return element directly
     */
    //Most popular icon at section page
    public static MobileElement mostPopular() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(0);
    }
    public static MobileElement Photos() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(12);
    }

    //"IMMERSIVE" option in sections
    public static MobileElement immersive() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(14);
    }

    //"Saved for later" option in sections
    public static MobileElement savedForLater() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(35);
    }

    //"Saved for later" option in sections
    public static MobileElement recentlyViewed() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(40);
    }

    //Search button on top right
    public static MobileElement searchButton() {
        MobileElement searchButton = (MobileElement) driver.findElementByAccessibilityId(searchButton_AccessiblityID);
        return searchButton;
    }

    //"PODCAST" option in sections
    public static MobileElement podcast() {
        List<MobileElement> bottomNavigation = (List<MobileElement>) driver.findElementsById(mostPopular_ID);
        return bottomNavigation.get(36);
    }


    //Search field that appears on clicking search button
    public static MobileElement searchField()
    {
        MobileElement searchField = (MobileElement) driver.findElementById(searchField_ID);
        return searchField;
    }

    //Headings of articles that appear on search
    public static List<MobileElement> searchResultArticleHeadings()
    {
        List <MobileElement> searchResultAtricleHeadings = (List<MobileElement>) driver.findElementsById(searchResultArticleHeadings_ID);
        return  searchResultAtricleHeadings;
    }
    //Headings of articles that appear on ercently viewed section
    public static List<MobileElement> recentlyviewedArticleHeadings()
    {
        List <MobileElement> recentlyViewedSectionAtricleHeadings = (List<MobileElement>) driver.findElementsById(recentlyViewedArticleHeadings_ID);
        return recentlyViewedSectionAtricleHeadings;
    }
    //Headings of articles that appear on most popular section
    public static MobileElement mostPopularSectionHeader()
    {
        MobileElement mostPopularHeading = (MobileElement) driver.findElementsByXPath(mostPopularHeader_Xpath);
        return mostPopularHeading;
    }
}
