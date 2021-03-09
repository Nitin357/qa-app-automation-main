package Android;

import org.testng.annotations.Test;

import static ObjectRepository.AndroidOR.CommonElements.forYouIcon;
import static ObjectRepository.AndroidOR.ForYou.*;
import static ObjectRepository.AndroidOR.Settings.*;
import static Parent.Constants.loginUserName;
import static Parent.Constants.loginUserPassword;
import static Utils.CommonUtils.launchNYTApp;
import static Utils.CommonUtils.skipInitialAccountSetup;

public class TestCreation {
    @Test
    public void abc() throws Exception{
        launchNYTApp();
        skipInitialAccountSetup();
        Thread.sleep(10000);
        forYouIcon().click();
        Thread.sleep(10000);
        settingsIcon().click();
        Thread.sleep(5000);
        loginOrRegisterButton().click();
        Thread.sleep(5000);
        loginWithEmailInsteadOption().click();
        Thread.sleep(5000);
        emailIdTextField().sendKeys(loginUserName);
        Thread.sleep(5000);
        passwordTextField().sendKeys(loginUserPassword);
        Thread.sleep(5000);
        loginButton().click();
        Thread.sleep(5000);
    }
}
