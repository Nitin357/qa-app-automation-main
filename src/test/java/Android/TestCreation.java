package Android;
import ObjectRepository.AndroidOR.ForYou;
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
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;

import static ObjectRepository.AndroidOR.CommonElements.forYouIcon;
import static ObjectRepository.AndroidOR.ForYou.completionMomentComponent;
import static Utils.CommonUtils.launchNYTApp;
import static Utils.CommonUtils.skipInitialAccountSetup;
import static Parent.Constants.*;
import static ObjectRepository.AndroidOR.ForYou.*;
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
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        Launch the application
//        driver.get("http://demo.guru99.com/test/guru99home/");

        //Find element by link text and store in variable "Element"
//        WebElement Element = driver.findElement(By.linkText("Linux"));
//
        //This will scroll the page till the element is found
//        js.executeScript("arguments[0].scrollIntoView();", Element);

/*        WebDriver driver2=new SafariDriver();
        driver2.navigate().to("https://install.appcenter.ms/");
        Thread.sleep(10000);
        //Click on sign in with email instead option
        driver2.findElement(By.xpath("//*[@id='content']/div/div[3]/div/div[1]/div[4]/a[1]/div")).click();
        //enter email id and password
        driver2.findElement(By.name("email")).sendKeys("manish.mittal@diaspark.com");
        driver2.findElement(By.name("password")).sendKeys("manish1979");
        driver2.findElement(By.className("_3EtH0jXex")).click();
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver2;
        WebElement ele = driver2.findElement(By.xpath("//*[@id='layout-viewport']/div[1]/div[2]/div[2]/div[2]/ul/li[31]/a/div/div/div[2]/span[1]"));
//        js.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();
        Thread.sleep(10000);
        driver2.findElement(By.className("_3EtH0jXex")).click();
        Robot robot = new Robot();
        Thread.sleep(10000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }*/
        launchNYTApp();
        skipInitialAccountSetup();
        Thread.sleep(5000);
        forYouIcon().click();
        Thread.sleep(10000);
        Dimension size = driver.manage().window().getSize();
        int startx = size.getWidth()/2;
        int endx = size.getWidth()/2;
        int starty = (int)(size.getHeight()* 0.80);
        int endy = (int)(size.getHeight()* 0.01);
        new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
        new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
        new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
        new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();
        new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();

//        new TouchAction( driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(endx, endy)).release().perform();

//.moveTo(moveToOptions().withElement(element(settingsIcon()))).perform();
//        new TouchAction( driver).tap(tapOptions().withElement(element(settingsIcon()))).perform();



        System.out.println("++"+ForYou.completionMomentComponent().getText()+"++");
    }}
