package com.tka.listeners.driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.support.events.WebDriverListener;

public class TrackBrowserActivities implements WebDriverListener {
	
	@Override
	public void afterClose(WebDriver driver) {
		System.out.println("browser closed");
	}
	
	@Override
	public void afterAccept(Alert alert) {
		System.out.println("Alert accepted..");
	}
	
	@Override
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		System.out.println("Element Found....");
	}
	
	@Override
	public void afterFullscreen(Window window) {
		System.out.println("window maximize...");
	}
	@Override
	public void beforeAlert(TargetLocator targetLocator) {
	System.out.println("Alert was called");
	}

}
