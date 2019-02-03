package steps;

import pages.InsuranceTravelPage;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;


public class InsuranceTravelStep {
    //WebDriver driver;

    @Step("Проверка на ошибки")
    public void checkSP(String errorMessage){
        new InsuranceTravelPage(BaseStep.getDriver()).checkSP();
    }

    @Step("Переход на новую вкладку")
    public void changeWindow () {
        new InsuranceTravelPage(BaseStep.getDriver()).changeWindow();
    }

}