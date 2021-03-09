package Parent;

import org.testng.annotations.Test;

import static Utils.CommonUtils.getCredentialsFromExcel;

public class AfterSuite {
    @Test
    public void AfterSuite()
    {
        Reporting.closeReporting();
    }
}
