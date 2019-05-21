package scripts;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestInvalidLogin extends BaseTest{
	@Test
	public void validLogin() throws InterruptedException{
		LoginPage login = new LoginPage(driver);
		int totalRowCount = Lib.getTotalRowCount("inputdata", "InvalidLogin");
		System.out.println(totalRowCount);
		for (int i = 1; i <= totalRowCount; i++) {
			//enter the username
			String un = Lib.getCellValue("inputdata", "InvalidLogin", i, 0);
			login.setUsername(un);
			Thread.sleep(1000);
			// enter password
			String pwd = Lib.getCellValue("inputdata", "InvalidLogin", i, 1);
			login.setPassword(pwd);
			Thread.sleep(1000);
			//click on login button
			login.clickLogin();
		}
	}
}
