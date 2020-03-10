package com.qualitest.core.util;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.thucydides.core.webdriver.DriverSource;

public class MobileDriver implements DriverSource{

/*	   
	    public WebDriver newDriver() {
	    	System.setProperty("webdriver.chrome.driver","C:\\UpdateAutomationScripts\\Qualitest-PVH\\src\\test\\resources\\drivers\\win\\chromedriver.exe");
	        @SuppressWarnings("deprecation")
			DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
			// Add
			return new PhantomJSDriver(PhantomJSDriverService.createDefaultService(),

capabilities); }

	     
	    public boolean takesScreenshots() {
	        return true;
	    }
	   */
	@Override
	public WebDriver newDriver() {
//		System.setProperty("webdriver.chrome.driver","C:\\UpdateAutomationScripts\\Qualitest-PVH\\src\\test\\resources\\drivers\\win\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\c-mmarup\\git\\Qualitest-PVH-CK-R\\Full_Reg_Suite\\src\\test\\resources\\drivers\\win\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Grids\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Grid\\chromedriver.exe");
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    Map<String, String> mobileEmulation = new HashMap<>();
	    mobileEmulation.put("deviceName", "iPhone X");
//	    mobileEmulation.put("deviceName", "Galaxy S5");
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	    chromeOptions.merge(capabilities);
		// Add
		return new ChromeDriver(chromeOptions);
	}
	@Override
	public boolean takesScreenshots() {
	    return true;
	}
	
//	public void pageRefresh() {
//		newDriver().navigate().refresh();
	}

/*
	public static void mobileTest() throws Exception{
    	Map<String, String> mobileEmulation = new HashMap<>();

    	mobileEmulation.put("deviceName", "iPhone X");

    	ChromeOptions chromeOptions = new ChromeOptions();
    	chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
    	
    	@SuppressWarnings("unused")
		WebDriver driver = new ChromeDriver(chromeOptions);
    	}
*/

