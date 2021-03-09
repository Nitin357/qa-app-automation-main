package Parent;

import org.testng.annotations.Test;

import static Utils.CommonUtils.*;

public class BeforeSuite {
   @Test
   public void BeforeSuite()
   {
      getCredentialsFromExcel();
   }
}