package com.TryCloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}


    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();;


    public static WebDriver getDriver(){

        if(driverPool.get() == null){
            String browserType="";
            if(System.getProperty("BROWSER")==null) {
                 browserType = ConfigurationReader.getProperty("browser");
            } else {
                 browserType = System.getProperty("BROWSER");
            }

            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;



                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "localhost"; //CHANGE IT TO YOU ip
                        URL url = new URL("http://"+ gridAddress + ":4445/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    try {
                        // assign your grid server address
                        String gridAddress = "localhost";
                        URL url = new URL("http://"+ gridAddress + ":4445/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }


        return driverPool.get();

    }

    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }






}
