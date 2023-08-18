package com.ui.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utils.Browsers;

public abstract class TestBase {
	protected WebDriver wb;

	public TestBase() {
		// TODO Auto-generated constructor stub
		wb = new ChromeDriver();
	}

	public TestBase(Browsers browser) {
		if (browser == Browsers.CHROME) {
			wb = new ChromeDriver();
		} else if (browser == Browsers.EDGE) {
			wb = new EdgeDriver();
		} else if (browser == Browsers.FIREFOX) {
			wb = new FirefoxDriver();
		}
	}
}
