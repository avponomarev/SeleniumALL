import org.junit.Test;
import pages.MainPage;
import pages.RequestPage;
import pages.InsuranceTravelPage;

public class Task2 extends BaseTest{
    @Test
    public void Task2Selenium(){

        //Инициализация страниц
        MainPage mainPage = new MainPage(driver);
        InsuranceTravelPage insuranceTravelPage = new InsuranceTravelPage(driver);
        RequestPage RequestPage = new RequestPage(driver);

        //Выполнение команд для основной страницы
        mainPage.selectSection("Страхование");
        mainPage.waitElement(mainPage.getTravelInsuranceElement("Путешествия и покупки"));
        mainPage.travelInsurance("Страхование путешественников");

        //Выполнение команд для страницы страхования путешественников
        insuranceTravelPage.checkSP();
        insuranceTravelPage.changeWindow();

        //Выбор минимального макета для страхования на третьей странице
        RequestPage.minrequest("Минимальная");
        RequestPage.PressMin();

        //Ввод данных в заявку по застрахованным
        RequestPage.fillField("фамилия застрахованного", "Petrov");
        RequestPage.fillField("имя застрахованного", "Petr");
        RequestPage.fillField("дата рождения застрахованного", "23.02.1968");

        //Ввод данных в заявку по страхователю
        RequestPage.fillField("фамилия", "Петров");
        RequestPage.fillField("имя", "Петр");
        RequestPage.fillField("отчество", "Петрович");
        RequestPage.fillField("день рождения", "23.02.1968");

        //Ввод данных паспорта
        RequestPage.fillField("серия паспорта", "1111");
        RequestPage.fillField("номер паспорта", "111111");
        RequestPage.fillField("дата выдачи", "12.01.2018");
        RequestPage.fillField("место выдачи", "МВД");


        //Проверка ввода данных в заявку по застрахованным
        RequestPage.checkFields("фамилия застрахованного","Petrov");
        RequestPage.checkFields("имя застрахованного","Petr");
        RequestPage.checkFields("дата рождения застрахованного", "23.02.1968");

        //Проверка ввода данных в заявку по страхователю
        RequestPage.checkFields("фамилия", "Петров");
        RequestPage.checkFields("имя", "Петр");
        RequestPage.checkFields("отчество", "Петрович");
        RequestPage.checkFields("день рождения", "23.02.1968");

        //Проверка ввода данных паспорта
        RequestPage.checkFields("серия паспорта", "1111");
        RequestPage.checkFields("номер паспорта", "111111");
        RequestPage.checkFields("дата выдачи", "12.01.2018");
        RequestPage.checkFields("место выдачи", "МВД");


        //Утверждение данных
        RequestPage.EndRequest();

        //Проверка заполненных полей
        RequestPage.checkZP();

    }
}