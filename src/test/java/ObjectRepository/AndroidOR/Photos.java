package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

public class Photos {

    public static String Photos_ID="overlay";
    public static String image_ID="imageView";
    //public static String Photos_ID="overlay";



    public static MobileElement Photo_list_0()
    {
        List<MobileElement> Photo_List = (List<MobileElement>) driver.findElementsById(Photos_ID);
        return Photo_List.get(0);
    }

    public static MobileElement Photo_list_1()
    {
        List<MobileElement> Photo_List = (List<MobileElement>) driver.findElementsById(Photos_ID);
        return Photo_List.get(1);
    }
}