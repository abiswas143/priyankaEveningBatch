package scripts;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestValidLogin extends BaseTest{
	@Test
	public void validLogin() throws InterruptedException{
		LoginPage login = new LoginPage(driver);
		//enter the username
		String un = Lib.getCellValue("inputdata", "ValidLogin", 1, 0);
		login.setUsername(un);
		// enter password
		String pwd = Lib.getCellValue("inputdata", "ValidLogin", 1, 1);
		login.setPassword(pwd);
		//click on login button
		login.clickLogin();
		Thread.sleep(4000);
		Assert.fail();
	}
}
