package com.tka.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtilities {

	public static WebDriver openBrowser() {
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public static void OpenANyUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public static void clickButtom(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void enterText(WebDriver driver, String xpath, String data) {
		driver.findElement(By.xpath(xpath)).sendKeys(data);
	}

	public static String getAnyText(WebDriver driver, String xpath) {
		String txt = driver.findElement(By.xpath(xpath)).getText();
		return txt;
	}
	
	public static List<WebElement> getListofElements(WebDriver driver, String xpath){
		return driver.findElements(By.xpath(xpath));
	}
	
	public static void selectOption(WebDriver driver, String xpath,String option) {
		WebElement wbe = driver.findElement(By.xpath(xpath));
		Select select = new Select(wbe);
		select.selectByValue(option);
	
	}
}
