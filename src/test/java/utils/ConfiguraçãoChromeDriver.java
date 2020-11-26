package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class ConfiguraçãoChromeDriver {
	
	WebDriver driver;
	
	public ConfiguraçãoChromeDriver(WebDriver driver) {

		this.driver = driver;
	}

	public void configuraChromeDriver() {
		// Configura espera de 120 Segundos para qualquer elemento.

//			driver.manage().window().maximize();		
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments(
////					   "--headless"
//					   "--disable-web-security",
//					   "--ignore-certificate-errors",
//					   "--disable-gpu",
//					   "window-size=1200x600",
//					   "disable-popup-blocking",
//					   "disable-infobars"
//					  );
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

}
