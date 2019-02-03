import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Task1 {
    private WebDriver driver;
    private String baseUrl;
    //SimpleDateFormat today = new SimpleDateFormat("dd.MM.yyyy");

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = " http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        Wait<WebDriver> wait = new WebDriverWait(driver, 7, 1500);
        driver.get(baseUrl);

        driver.get("https://www.sberbank.ru/ru/person");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Узнать подробнее'])[2]/following::span[2]")).click();
        driver.findElement(By.linkText("Путешествия и покупки")).click();
        assertEquals("Страхование путешественников",
                driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div[1]/div/div/div/div[1]/div/div[2]/div/div[2]/div/div[1]/div/div/div/div/div/h3")).getText());
        String winHandleBefore = driver.getWindowHandle();
        driver.findElement(By.linkText("Оформить онлайн")).click();
        for (String winHandle : driver.getWindowHandles())
            driver.switchTo().window(winHandle);
        {
            wait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите сумму страховой защиты'])[1]/following::div[4]"))));
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите сумму страховой защиты'])[1]/following::div[4]")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='i'])[13]/following::span[2]")).click();
            driver.findElement(By.name("insured0_surname")).click();
            driver.findElement(By.name("insured0_surname")).clear();
            driver.findElement(By.name("insured0_surname")).sendKeys("Petrov");
            driver.findElement(By.name("insured0_name")).click();
            driver.findElement(By.name("insured0_name")).clear();
            driver.findElement(By.name("insured0_name")).sendKeys("Petr");
            driver.findElement(By.name("insured0_birthDate")).click();
            driver.findElement(By.name("insured0_birthDate")).sendKeys("23.02.1968");
            driver.findElement(By.name("surname")).click();
            driver.findElement(By.name("surname")).clear();
            driver.findElement(By.name("surname")).sendKeys("Петров");
            driver.findElement(By.name("name")).click();
            driver.findElement(By.name("name")).clear();
            driver.findElement(By.name("name")).sendKeys("Петр");
            driver.findElement(By.name("middlename")).click();
            driver.findElement(By.name("middlename")).clear();
            driver.findElement(By.name("middlename")).sendKeys("Петрович");
            driver.findElement(By.name("birthDate")).click();
            driver.findElement(By.name("birthDate")).sendKeys("23.02.1968");
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения не верна. Исправлено.'])[1]/following::fieldset[1]")).click();
            driver.findElement(By.name("passport_series")).sendKeys("1111");
            driver.findElement(By.name("passport_number")).click();
            driver.findElement(By.name("passport_number")).clear();
            driver.findElement(By.name("passport_number")).sendKeys("111111");
            driver.findElement(By.name("issueDate")).click();
            driver.findElement(By.name("issueDate")).clear();
            driver.findElement(By.name("issueDate")).sendKeys("12.01.2018");
            driver.findElement(By.xpath("//div")).click();
            driver.findElement(By.name("issuePlace")).click();
            driver.findElement(By.name("issuePlace")).clear();
            driver.findElement(By.name("issuePlace")).sendKeys("МВД");
            driver.findElement(By.name("insured0_name")).getAttribute("value");
            driver.findElement(By.name("insured0_surname")).getAttribute("value");
            driver.findElement(By.name("insured0_birthDate")).getAttribute("value");
            driver.findElement(By.name("name")).getAttribute("value");
            driver.findElement(By.name("surname")).getAttribute("value");
            driver.findElement(By.name("birthDate")).getAttribute("value");
            driver.findElement(By.name("passport_series")).getAttribute("value");
            driver.findElement(By.name("passport_number")).getAttribute("value");
            driver.findElement(By.name("issueDate")).getAttribute("value");
            driver.findElement(By.name("issuePlace")).getAttribute("value");
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Вернуться'])[1]/following::span[1]")).click();
            assertEquals("Заполнены не все обязательные поля",
                    driver.findElement(By.xpath("//*[@id=\"views\"]/section/form/section/section[5]/div[2]/div[1]")).getText());

        }
    }
}