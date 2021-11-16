package ObjectRepository.AndroidOR;

import io.appium.java_client.MobileElement;

import java.util.List;

import static Parent.Constants.driver;

public class Deeplinking {

    public static String TextLink= "android.view.View";


    public static List<MobileElement> link()
    {
        List<MobileElement> link = (List<MobileElement>) driver.findElementsByClassName(TextLink);
        return link;
    }




}
