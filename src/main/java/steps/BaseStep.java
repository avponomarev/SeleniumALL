package steps;

import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.concurrent.TimeUnit;
import ru.yandex.qatools.allure.annotations.Step;

public class BaseStep {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    @Before
    public void startScenario(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.sberbank.ru/ru/person/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Attachment(type = "image/jpeg", value = "Screenshot")
    public static byte[] AllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterClass
    public static void afterMethod(){
        driver .quit();
    }
}