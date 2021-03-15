package Parent;

import org.testng.annotations.Test;

import static Utils.CommonUtils.*;
/*Contains all the methods to be initialised before test suite*/
public class BeforeSuite {
   @Test
   public void BeforeSuite()
   {
      getCredentialsFromExcel();
   }
}