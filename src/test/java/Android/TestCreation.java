package Android;
import ObjectRepository.AndroidOR.ForYou;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.poi.poifs.property.Parent;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static ObjectRepository.AndroidOR.CommonElements.*;
import static ObjectRepository.AndroidOR.ForYou.completionMomentComponent;
import static ObjectRepository.AndroidOR.Sections.immersive;
import static ObjectRepository.AndroidOR.Sections.mostPopular;
import static Parent.Constants.*;
import static ObjectRepository.AndroidOR.ForYou.*;
import static Utils.CommonUtils.*;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.awt.SystemColor.window;

/*
*
*  This class is used to test code before creating a test case
*  The code here is not included in test execution
*
*/
public class TestCreation {
    @Test
    public void abc() throws Exception {
//        driver.isAppInstalled("com.android.nytimes");
        launchNYTApp();
        /*
        *
        *
        *
        *
        *
        *
        * for apk installation
        *
        *
        *
        *
        *
        * */
//delete all files in a folder


//        Thread.sleep(10000);
//        Thread.sleep(10000);
//        Thread.sleep(10000);
//        Thread.sleep(10000);
//        Thread.sleep(10000);
//        Thread.sleep(10000);
//
//
//        File myFile = new File("/Users/webdunia/Downloads/NytApp.apk");
//        myFile.renameTo(new File(System.getProperty("user.dir")+"\\Nyt.apk"));
//
//        tempFile = new File(System.getProperty("user.dir")+"\\Nyt.apk");
//        exists = tempFile.exists();
//        System.out.println(exists);
//
//
/*
*
*
* share functionality
*
*
*
*
* */

//        launchNYTApp();
//        skipInitialAccountSetup();
//        Thread.sleep(5000);
//        login();
//        Thread.sleep(5000);
//        sectionsIcon().click();
//        Thread.sleep(10000);
//        mostPopular().click();
//        Thread.sleep(10000);
//        java.util.List<MobileElement> homeTabArticles = (List<MobileElement>) driver.findElementsById("tablet_grid_item");
//        homeTabArticles.get(1).click();
//        Thread.sleep(5000);


//        Thread.sleep(5000);
//        homeTabArticles.get(1).click();
//
//
//        MobileElement el1 = (MobileElement) driver.findElementById("//[starts-with(@id,\"link\")]");

//        Thread.sleep(10000);


//        MobileElement el1 = (MobileElement)driver.findElements(By.xpath("//[starts-with(@id, ‘link-’)]"));
//        el1.getText();





//        articleFrontShareButton().click();
//        Thread.sleep(10000);
//
//
//        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/com.android.internal.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView");
//        el2.click();

    }
}
