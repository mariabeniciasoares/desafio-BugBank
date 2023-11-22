package Suporte;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

public class GerenciadorDriver {
    private static WebDriver driver;

    private static WebDriver getGerenciadorDriver(TipoDriver tipoDriver){
        switch (tipoDriver){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--window-size(1366,768)");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case HEADLESS:
                WebDriverManager.chromedriver().setup();
                ChromeOptions headless = new ChromeOptions();
                headless.addArguments("--headless");
                driver = new ChromeDriver(headless);
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                MutableCapabilities capabilities = new MutableCapabilities();
                capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.IE);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true );
                driver = new InternetExplorerDriver();
                break;
            default:
                break;
        }
        return driver;
    }

    public static WebDriver getDriver(TipoDriver tipoDriver){
        if(driver == null){
            driver = getGerenciadorDriver(tipoDriver);
        }
        return driver;
    }

    public static void encerrarDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}

