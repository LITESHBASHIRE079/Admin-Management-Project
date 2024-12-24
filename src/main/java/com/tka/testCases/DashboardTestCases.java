package com.tka.testCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tka.utilities.SeleniumUtilities;
import com.tka.utilities.excel.ExcelReader;
import com.tka.utilities.prop.PropUtil;

public class DashboardTestCases {
	WebDriver driver =null;
	@BeforeClass
	public void openurl() {
		driver= SeleniumUtilities.openBrowser();
		SeleniumUtilities.OpenANyUrl(driver, PropUtil.valueofAnyKey("Dashboardurl"));
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	
	@Test()
	public void checkHeading() {
		String ActResult =SeleniumUtilities.getAnyText(driver, "/html/body/div/div[1]/section[1]/h1");
		
		Assert.assertEquals(ActResult,"Dashboard");
	}
	
	@Test()
	public void CheckCourseName() {
		List<WebElement> list = SeleniumUtilities.getListofElements(driver, "//div[@class='inner']/h3");
		ArrayList<String> aclist = new ArrayList<String>();
		for (WebElement webElement : list) {
			String data= webElement.getText();
			aclist.add(data); 
		}
		
		List<String> exList = new ArrayList<String>();
		exList.add("Selenium");
		exList.add("Java / J2EE"); 
		exList.add("Python");
		exList.add("Php");
		
		Assert.assertEquals(aclist, exList);
		
	}
	
	@Test()
	public void checkCourseTechnology() {
		List<WebElement> list = SeleniumUtilities.getListofElements(driver, "//div[@class='inner']/p");
		ArrayList<String> aclist = new ArrayList<String>();
		for (WebElement webElement : list) {
			String data= webElement.getText();
			aclist.add(data); 
		}
		
		List<String> Exlist = new ArrayList<String>();
		int row= ExcelReader.getRowCount("DashboardPageSheet");
		int col = ExcelReader.getColCount("DashboardPageSheet");
		
		for(int i= 1; i<=4;i++) {
			for(int j=0;j<col;j++) {
				String data = ExcelReader.getcellvalue("DashboardPageSheet", i ,j);
				Exlist.add(data);
			}
		}
		
		Assert.assertEquals(aclist, Exlist);
	}
	
	@Test()
	public void checkSyllabusSelenium() {
		SeleniumUtilities.clickButtom(driver, "/html/body/div/div[1]/section[2]/div/div[1]/div/a");
		
		String ExResult="";
		Set<String> windIds = driver.getWindowHandles();
		Iterator<String> ids = windIds.iterator();
		String currentWid = ids.next();
		String newWid = ids.next();
		
		driver.switchTo().window(newWid);
		String AcResult = driver.getTitle();
		driver.switchTo().window(newWid).close();
		driver.switchTo().window(currentWid);
		
		Assert.assertEquals(AcResult, ExResult);
	}
	
	@Test()
	public void checkSyllabusJava() {
		SeleniumUtilities.clickButtom(driver, "/html/body/div/div[1]/section[2]/div/div[2]/div/a");
		
		String ExResult="";
		Set<String> windIds = driver.getWindowHandles();
		Iterator<String> ids = windIds.iterator();
		String currentWid = ids.next();
		String newWid = ids.next();
		
		driver.switchTo().window(newWid);
		String AcResult = driver.getTitle();
		
		driver.switchTo().window(newWid).close();
		driver.switchTo().window(currentWid);
		
		Assert.assertEquals(AcResult, ExResult);
	}
	
	@Test()
	public void checkSyllabusPython() {
		SeleniumUtilities.clickButtom(driver, "/html/body/div/div[1]/section[2]/div/div[3]/div/a");
		
		String ExResult="";
		Set<String> windIds = driver.getWindowHandles();
		Iterator<String> ids = windIds.iterator();
		String currentWid = ids.next();
		String newWid = ids.next();
		
		driver.switchTo().window(newWid);
		String AcResult = driver.getTitle();
		
		driver.switchTo().window(newWid).close();
		driver.switchTo().window(currentWid);
		
		Assert.assertEquals(AcResult, ExResult);
	}
	
	@Test()
	public void checkSyllabusPhp() {
		SeleniumUtilities.clickButtom(driver, "/html/body/div/div[1]/section[2]/div/div[4]/div/a");
		
		String ExResult="JavaByKiran | Dashboard";
		Set<String> windIds = driver.getWindowHandles();
		Iterator<String> ids = windIds.iterator();
		String currentWid = ids.next();
		String newWid = ids.next();
		
		driver.switchTo().window(newWid);
		String AcResult = driver.getTitle();
		
		driver.switchTo().window(newWid).close();
		driver.switchTo().window(currentWid);
		
		Assert.assertEquals(AcResult, ExResult);
	}
	
	@Test()
	public void checkSideMenuName() {
		List<WebElement> list = SeleniumUtilities.getListofElements(driver, "//ul[@class='sidebar-menu']//a/span");
		ArrayList<String> Aclist = new ArrayList<String>();
		for (WebElement webElement : list) {
			String data= webElement.getText();
			Aclist.add(data); 
		}
		
		List<String> Exlist = new ArrayList<String>();
		int row= ExcelReader.getRowCount("DashboardPageSheet");
		int col = ExcelReader.getColCount("DashboardPageSheet");
		
		for(int i= 7; i<row;i++) {
			for(int j=0;j<col;j++) {
				String data = ExcelReader.getcellvalue("DashboardPageSheet", i ,j);
				Exlist.add(data);
			}
		}
		
		Assert.assertEquals(Aclist, Exlist);
	}
	
	@Test()
	public void checkUserPageTab() {
		SeleniumUtilities.clickButtom(driver, "/html/body/div/aside/section/ul/li[3]/a");
		
		String AcRseult = SeleniumUtilities.getAnyText(driver, "//h1");
		
		String ExResult ="Users"; //heading of tab
		
		driver.navigate().back();
		
		Assert.assertEquals(AcRseult, ExResult);
	}
	
	@Test()
	public void checkOperatorsPageTab() {
		SeleniumUtilities.clickButtom(driver, "/html/body/div/aside/section/ul/li[4]/a");
		
		String AcRseult = SeleniumUtilities.getAnyText(driver, "//h1");
		
		String ExResult ="Operators"; //heading of tab
		
		driver.navigate().back();
		
		Assert.assertEquals(AcRseult, ExResult);
	}
	
	@Test()
	public void checkDownloadPageTab() {
		SeleniumUtilities.clickButtom(driver, "/html/body/div/aside/section/ul/li[6]/a");
		
		String AcRseult = SeleniumUtilities.getAnyText(driver, "//h1");
		
		String ExResult ="Downloads"; //heading of tab
		
		driver.navigate().back();
		
		Assert.assertEquals(AcRseult, ExResult);
	}
	
	@Test(priority =100)
	public void CheckLogoutButton() {
		SeleniumUtilities.clickButtom(driver, "/html/body/div/aside/section/ul/li[7]/a");
		
		String AcRseult = SeleniumUtilities.getAnyText(driver, "/html/body/div/div[2]/p[2]");
		String ExResult ="Logout successfully";
		
		//driver.navigate().back();
		
		Assert.assertEquals(AcRseult, ExResult);
	}
}
