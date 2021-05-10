package Android;

import org.testng.annotations.Test;

import static Utils.CommonUtils.installApk;

public class TestNewFunctionality {
    @Test
    public static void checkNewFunctionality() throws Exception
    {
        installApk();
    }
}
