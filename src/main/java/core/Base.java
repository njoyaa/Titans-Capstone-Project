package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	private String ConfigPath = ".\\src\\test\\resources\\Input\\config.properties";
	private String Log4JPath = ".\\src\\test\\resources\\Input\\Log4j.properties";

	public Base() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(ConfigPath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		logger = Logger.getLogger(Log4JPath);
		PropertyConfigurator.configure(Log4JPath);

	}

	public static String getURL() {
		String url = properties.getProperty("url");
		return url;
	}

	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;

	}

	public static void openBrowser() {
		driver.get(getURL());
	}

	public static void selectBrowser() {
		switch (getBrowser()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		default:
			System.out.println("The browser is not supported");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
