package com.tka.testCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tka.utilities.SeleniumUtilities;
import com.tka.utilities.excel.ExcelReader;

public class UserTabTestCases {
	WebDriver driver =null;
	@BeforeClass
	public void openurl(){
		driver = SeleniumUtilities.openBrowser();
		SeleniumUtilities.OpenANyUrl(driver, "https://javabykiran.com/liveproject/pages/examples/users.html");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	
	
	@Test
	public void Checkheading() {
		String AcResult= SeleniumUtilities.getAnyText(driver, "//h3");
		
		String ExResult = "User List";
		
		Assert.assertEquals(AcResult, ExResult);
	}
	
	@Test
	public void  checkUserTableHeading() {
		List<WebElement> list = SeleniumUtilities.getListofElements(driver, "//table[@class='table table-hover']//th");
		ArrayList<String> AcList = new ArrayList<String>();
		for (WebElement webElement : list) {
			String data = webElement.getText();
			AcList.add(data);
		}
		
		ArrayList<String> ExList = new ArrayList<String>();
		
		int row= ExcelReader.getRowCount("UserPageSheet");
		int col= ExcelReader.getColCount("UserPageSheet");
		
		for(int i=1;i<row;i++) {
			for (int j=0;j<col;j++) {
				String data = ExcelReader.getcellvalue("UserPageSheet", i, j);
				ExList.add(data);
			}
		}
		
		Assert.assertEquals(AcList, ExList);
	}
	
	@Test
	public void checkDeleteDefaultUser() {
		SeleniumUtilities.clickButtom(driver, "/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[2]/td[8]/a/span");
		String AcResult =driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String ExResult = "You can not delete Default User";
		
		Assert.assertEquals(AcResult, ExResult);
	}
	
	@Test
	public void checkAddNewUser() {
		SeleniumUtilities.clickButtom(driver, "/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button");
		SeleniumUtilities.enterText(driver, "//*[@id=\"username\"]", "Admin1");
		SeleniumUtilities.enterText(driver, "//*[@id=\"mobile\"]", "9876543210");
		SeleniumUtilities.enterText(driver, "//*[@id=\"email\"]", "admin@gmail.com");
		SeleniumUtilities.enterText(driver, "//*[@id=\"course\"]", "Testing");
		SeleniumUtilities.clickButtom(driver, "//*[@id=\"Male\"]");
		
		SeleniumUtilities.selectOption(driver, "/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select", "Maharashtra");
		
		SeleniumUtilities.enterText(driver, "//*[@id=\"password\"]", "pass123");
		SeleniumUtilities.clickButtom(driver, "//*[@id=\"submit\"]");
		String ExResult = "User Added Successfully";
		
		String AcResult =driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		SeleniumUtilities.clickButtom(driver, "/html/body/div/div[1]/section[2]/div/div/div/form/div[2]/a/span");
		
		Assert.assertEquals(AcResult, ExResult);
	}

}
