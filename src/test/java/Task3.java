import steps.BaseStep;
import steps.MainStep;
import steps.RequestStep;
import steps.InsuranceTravelStep;
import org.junit.Test;
import java.util.HashMap;



public class Task3 extends BaseStep {

    MainStep mainStep = new MainStep();
    InsuranceTravelStep insuranceTravelStep = new InsuranceTravelStep();
    RequestStep requestStep = new RequestStep();
    HashMap <String, String> testData = new HashMap<>();


    @Test
    public void task3selenuim(){

        mainStep.selectSection("Страхование");
        mainStep.waitElement(mainStep.getTravelInsuranceElement("Путешествия и покупки"));
        mainStep.travelInsurance("Страхование путешественников");


        insuranceTravelStep.checkSP("Страхование путешественников");
        insuranceTravelStep.changeWindow();


        requestStep.minrequest("Минимальная");
        requestStep.PressMin();


        testData.put("фамилия застрахованного", "Petrov");
        testData.put("имя застрахованного", "Petr");
        testData.put("дата рождения застрахованного", "23.02.1968");

        testData.put("фамилия", "Петров");
        testData.put("имя", "Петр");
        testData.put("отчество", "Петрович");
        testData.put("день рождения", "23.02.1968");

        testData.put("серия паспорта", "1111");
        testData.put("номер паспорта", "111111");
        testData.put("дата выдачи", "12.01.2018");
        testData.put("место выдачи", "МВД");


        requestStep.fillFields(testData);

        requestStep.checkFields(testData);

        requestStep.EndRequest();


        requestStep.checkZP();
    }

}