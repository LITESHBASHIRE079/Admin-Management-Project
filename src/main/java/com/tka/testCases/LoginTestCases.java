package com.tka.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tka.utilities.SeleniumUtilities;
import com.tka.utilities.excel.ExcelReader;
import com.tka.utilities.prop.PropUtil;

public class LoginTestCases {
	WebDriver driver = null;

	@BeforeClass
	public void openurl() {
		driver = SeleniumUtilities.openBrowser();
		SeleniumUtilities.OpenANyUrl(driver, PropUtil.valueofAnyKey("url"));
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	

	@Test(enabled = false)
	public void checkSubheadingText() {
		String actText = SeleniumUtilities.getAnyText(driver, "/html/body/div/div[2]/p[1]");

		String expText = "Sign in to start your session";// from BRD

		Assert.assertEquals(actText, expText);

	}

	@Test(enabled = false)
	public void testHeadingText() {
		String actText = SeleniumUtilities.getAnyText(driver, "/html/body/div/div[1]/a/b");
		String expText = "Java By Kiran";

		Assert.assertEquals(actText, expText);
	}

	@Test(enabled = false)
	public void checkloginPageTitle() {
		String actText = driver.getTitle();
		String expText = PropUtil.valueofAnyKey("loginPageTitle");

		Assert.assertEquals(actText, expText);
	}

	@Test(dataProvider = "logindata")
	public void checkinvalidCredentialMessage(String u, String p) {

		SeleniumUtilities.enterText(driver, "//*[@id=\"email\"]", u);
		SeleniumUtilities.enterText(driver, "//*[@id=\"password\"]", p);
		SeleniumUtilities.clickButtom(driver, "//*[@id=\"form\"]/div[3]/div/button");
		String ActResult = SeleniumUtilities.getAnyText(driver, "//*[@id=\"email_error\"]");

		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();

		String ExpectedemailError = "Please enter email";

		Assert.assertEquals(ActResult, ExpectedemailError);
	}

	/*
	 * if (check.equals("1")) { String ActualemailError =
	 * SeleniumUtilities.getAnyText(driver, "//*[@id=\"email_error\"]"); String
	 * ExpectedemailError = "Please enter email";
	 * 
	 * Assert.assertEquals(ActualemailError, ExpectedemailError); } else if
	 * (check.equals("2")) { String ActualemailError =
	 * SeleniumUtilities.getAnyText(driver, "//*[@id=\"password_error\"]"); String
	 * ExpectedemailError = "Please enter password";
	 * 
	 * Assert.assertEquals(ActualemailError, ExpectedemailError); } else if
	 * (check.endsWith("3")) { String ActualemailError =
	 * SeleniumUtilities.getAnyText(driver, "//*[@id=\"email_error\"]"); String
	 * ExpectedemailError = "Please enter valid email.";
	 * 
	 * Assert.assertEquals(ActualemailError, ExpectedemailError); } else if
	 * (check.endsWith("4")) { String ActualemailError =
	 * SeleniumUtilities.getAnyText(driver, "//*[@id=\"password_error\"]"); String
	 * ExpectedemailError = "Please enter valid password.";
	 * 
	 * Assert.assertEquals(ActualemailError, ExpectedemailError); } else if
	 * (check.endsWith("5")) { String ActualemailError =
	 * SeleniumUtilities.getAnyText(driver, "//*[@id=\"email_error\"]"); String
	 * ExpectedemailError = "Invalid Username And Password";
	 * 
	 * Assert.assertEquals(ActualemailError, ExpectedemailError); }
	 * 
	 * }
	 */

	@Test(enabled = false)
	public void checkRegisterNewMember() {

		SeleniumUtilities.clickButtom(driver, "/html/body/div/div[2]/a");
		SeleniumUtilities.enterText(driver, "//*[@id=\"name\"]", "Admin1");
		SeleniumUtilities.enterText(driver, "//*[@id=\"mobile\"]", "1234567899");
		SeleniumUtilities.enterText(driver, "//*[@id=\"email\"]", "123@gamil.com");
		SeleniumUtilities.enterText(driver, "//*[@id=\"password\"]", "pass1234");

		SeleniumUtilities.clickButtom(driver, "//*[@id=\"form\"]/div[5]/div/button");

		String Actresult = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String Expresult = "User registered successfully.";

		driver.navigate().back();
		Assert.assertEquals(Actresult, Expresult);

	}

	@Test(priority = 99, enabled = false)
	public void verfiyloginCredential() {
		SeleniumUtilities.enterText(driver, "//*[@id=\"email\"]", ExcelReader.getcellvalue("LoginPageSheet", 2, 0));

		SeleniumUtilities.enterText(driver, "//*[@id=\"password\"]", ExcelReader.getcellvalue("LoginPageSheet", 2, 1));
		SeleniumUtilities.clickButtom(driver, "//*[@id=\"form\"]/div[3]/div/button");

		String ActResult = driver.getTitle();

		Assert.assertEquals(ActResult, PropUtil.valueofAnyKey("DashboardPageTitel"));
	}

	@Test(priority = 100, enabled = false)
	public void verfiylogout() {

		SeleniumUtilities.clickButtom(driver, "/html/body/div/aside/section/ul/li[7]/a/span");

		String ActResult = SeleniumUtilities.getAnyText(driver, "/html/body/div/div[2]/p[2]");
		Assert.assertEquals(ActResult, "Logout successfully");

	}

	/*
	 * @DataProvider public Object[][] logindata() { return new Object[][] { new
	 * Object[] { " ", "123456", "1" }, new Object[] { "kiran@gmail.com", " ", "2"},
	 * new Object[] { "xyz", "123456", "3" }, new Object[] {
	 * "kiran@gmail.com","123", "4" }, new Object[] { "admin1", "password", "5" },
	 * }; }
	 */

	@DataProvider
	public Object[][] logindata() {
		int row = ExcelReader.getRowCount("LoginPageSheet");
		int col = ExcelReader.getColCount("LoginPageSheet");

		String[][] data = new String[row - 3][col];

		for (int i = 3; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 3][j] = ExcelReader.getcellvalue("LoginPageSheet", i, j);
				// data[i-3][j] =text;

			}
		}
		return data;
	}

}
