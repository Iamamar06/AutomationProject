package com.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.pojo.GlobalDetailsPojo;

public abstract class BrowserUtility {
	private WebDriver driver;
	private static WebDriver driverForSS;
	private WebDriverWait wait;

	public BrowserUtility(WebDriver driver) {
		this.driver = driver;
		this.driverForSS = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public BrowserUtility(Browsers browser) {
		if (browser == Browsers.CHROME) {
			driver = new ChromeDriver();
		} else if (browser == Browsers.EDGE) {
			driver = new EdgeDriver();
		} else if (browser == Browsers.FIREFOX) {
			driver = new FirefoxDriver();
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.driverForSS = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}

	public void goToWebsite(String url) {
		driver.get(url);
	}

	public String getTitleOfTheWebPage() {
		String title = driver.getTitle();
		return title;
	}

	public String getCurrentpageURL() {
		pauseFor(1);
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public void closeCurrentWindow() {
		driver.close();
	}
	public void terminateBrowserSession() {
		driver.quit();
	}
	
	public void pauseFor(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getVisibleText(By locator){
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String elementText = element.getText();
		return elementText;
	}
	
	public List<String> getAllVisibleText(By locator){
		//pauseFor(1);
		//List<WebElement> elementsList = driver.findElements(locator); 
		List<WebElement> elementsList =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		List<String> dataList = new ArrayList<>();
		for (WebElement e: elementsList) {
			dataList.add(e.getText());
		}
		return dataList;
	}
	
	public void enterTextInto(By locator, String textToEnter){
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(textToEnter);
	}
	public void clickOn(By locator) {
		//WebElement elemen = driver.findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}
	public void clearText(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
	}
	public void enterKeyInto(By locator, Keys keyboardButton) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(keyboardButton);
	}
	public ArrayList<GlobalDetailsPojo> getTableData(By tableLocator, By rowLocator) {
		List<WebElement> rowList = getDriver().findElements(tableLocator);
		List<WebElement> cellList;
		ArrayList<GlobalDetailsPojo> dataList = new ArrayList<>();
		GlobalDetailsPojo details;
		for (WebElement row : rowList) {
			cellList = row.findElements(rowLocator);
			details = new GlobalDetailsPojo(cellList.get(0).getText(), cellList.get(1).getText(), cellList.get(2).getText(),
					cellList.get(3).getText(), cellList.get(4).getText(), cellList.get(5).getText(), cellList.get(6).getText());
			dataList.add(details);
		}
		return dataList;
	}
	
	public static void takeScreenShot(String fileName) {
		File screenShotFile = ((TakesScreenshot) driverForSS).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(System.getProperty("user.dir")+"//screenshots//"+fileName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectFromDropdown(By dropdownLocator, String value) {
		clickOn(dropdownLocator);
		By stateLocator = By.xpath("//span[contains(text(),'"+value+"')]/..");
		clickOn(stateLocator);
	}
}
