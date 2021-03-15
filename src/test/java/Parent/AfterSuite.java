package Parent;

import org.testng.annotations.Test;

import static Utils.CommonUtils.getCredentialsFromExcel;

/*Contains all the methods to be closed before test suite*/
public class AfterSuite {
    @Test
    public void AfterSuite()
    {
        Reporting.closeReporting();
    }
}
