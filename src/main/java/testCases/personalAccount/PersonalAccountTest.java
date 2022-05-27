package testCases.personalAccount;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import testPages.PersonalAccountPage;


import java.util.UUID;

public class PersonalAccountTest extends PersonalAccountPage {
    public PersonalAccountTest() throws Exception {
    }

    //проверки в Личном кабинете для ЕРП

    /**
     * Цель: Создание шаблона обязательных требований
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=43
     *
     * @author Troickij D.A. 04.2022
     */
    @Test(description = "Создание шаблона обязательных требований")
    public void createTemplateMandatoryRequirementsERPTest() throws Exception {
        authorization("supervisor");
        System.out.printf("Идентификатор создаваемого обязательного требования %s%n", prefixName);
        clickPersonalAccount();
        scrollTopHtml();
        goToMandatoryRequirementsMenu();
        createTemplateMandatoryRequirements(prefixName);
        templateMandatoryRequirements = prefixName + templateName;
        checkTemplateMandatoryRequirements(prefixName, true);
        logout();
    }

    /**
     * Цель: Редактирование шаблона обязательных требований
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=295
     *
     * @author Troickij D.A. 04.2022
     */
    @Test(description = "Редактирование шаблона обязательных требований")
    public void editTemplateMandatoryRequirementsERPTest() throws Exception {
        String lastPrefix = UUID.randomUUID().toString();
        String newPrefix = UUID.randomUUID().toString();
        authorization("supervisor");
        clickPersonalAccount();
        scrollTopHtml();
        goToMandatoryRequirementsMenu();
        System.out.printf("Старый идентификатор редактируемого обязательного требования %s, новый %s%n", lastPrefix,
                newPrefix);
        createTemplateMandatoryRequirements(lastPrefix);
        editTemplateMandatoryRequirements(lastPrefix, newPrefix);
        checkTemplateMandatoryRequirements(newPrefix, true);
        checkTemplateMandatoryRequirements(lastPrefix, false);
        logout();
    }

    /**
     * Цель: Удаление шаблона обязательных требований
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=289
     *
     * @author Troickij D.A. 04.2022
     */
    @Test(description = "Удаление шаблона обязательных требований")
    public void deleteTemplateMandatoryRequirementsERPTest() throws Exception {
        String prefix = UUID.randomUUID().toString();
        authorization("supervisor");
        clickPersonalAccount();
        scrollTopHtml();
        goToMandatoryRequirementsMenu();
        System.out.printf("Удаляемое обязательное требование %s%n", prefix);
        createTemplateMandatoryRequirements(prefix);
        deleteTemplateMandatoryRequirementsOrSheets(prefix);
        checkTemplateMandatoryRequirements(prefix, false);
        logout();
    }

    /**
     * Цель: Создание шаблонов проверочных листов
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=42
     *
     * @author Troickij D.A. 04.2022
     */
    @Test(description = "Создание шаблона проверочных листов")
    public void createTemplateSheetsERPTest() throws Exception {
        authorization("supervisor");
        System.out.printf("Идентификатор создаваемого проверочного листа %s%n", prefixName);
        clickPersonalAccount();
        scrollTopHtml();
        goToCheckSheetsMenu();
        templateSheets = prefixName + templateName;
        createTemplateSheets(prefixName);
        checkTemplateSheets(prefixName, true);
        logout();
    }

    /**
     * Цель: Редактирование шаблона проверочных листов
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=296
     *
     * @author Troickij D.A. 04.2022
     */
    @Test(description = "Редактирование шаблона проверочных листов")
    public void editTemplateSheetsERPTest() throws Exception {
        String lastPrefix = UUID.randomUUID().toString();
        String newPrefix = UUID.randomUUID().toString();
        authorization("supervisor");
        clickPersonalAccount();
        scrollTopHtml();
        goToCheckSheetsMenu();
        System.out.printf("Старый ID редактируемого проверочного листа %s, новый %s%n", lastPrefix, newPrefix);
        createTemplateSheets(lastPrefix);
        editTemplateSheets(lastPrefix, newPrefix);
        checkTemplateSheets(newPrefix, true);
        checkTemplateSheets(lastPrefix, false);
        logout();
    }

    /**
     * Цель: Удаление шаблона проверочных листов
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=290
     *
     * @author Troickij D.A. 04.2022
     */
    @Test(description = "Удаление шаблона проверочных листов")
    public void deleteTemplateSheetsERPTest() throws Exception {
        String prefix = UUID.randomUUID().toString();
        authorization("supervisor");
        clickPersonalAccount();
        scrollTopHtml();
        goToCheckSheetsMenu();
        System.out.printf("Удаляемый проверочный лист %s%n", prefix);
        createTemplateSheets(prefix);
        deleteTemplateMandatoryRequirementsOrSheets(prefix);
        checkTemplateSheets(prefix, false);
        logout();
    }

    /**
     * Цель: Создание уполномоченных на проведение КНМ
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=41
     *
     * @author Troickij D.A. 04.2022
     */
    @Test(description = "Создание уполномоченных на проведение КНМ")
    public void addRepresentativesERPTest() throws Exception {
        authorization("supervisor");
        System.out.printf("Идентификатор создаваемого уполномоченного %s%n", prefixName);
        clickPersonalAccount();
        scrollTopHtml();
        setOrganization(nameKNO);
        scrollTopHtml();
        goToAuthorizedToConductMenu();
        representative = prefixName + representativeTemplate;
        createRepresentatives(prefixName);
        checkRepresentatives(prefixName, true);
        logout();
    }

    /**
     * Цель: Редактирование уполномоченных на проведение КНМ
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=294
     *
     * @author Troickij D.A. 04.2022
     */
    @Test(description = "Редактирование уполномоченных на проведение КНМ")
    public void editRepresentativesERPTest() throws Exception {
        String lastPrefix = UUID.randomUUID().toString();
        String newPrefix = UUID.randomUUID().toString();
        authorization("supervisor");
        clickPersonalAccount();
        scrollTopHtml();
        goToAuthorizedToConductMenu();
        System.out.printf("Старый ID редактируемого уполномоченного %s, новый %s%n", lastPrefix, newPrefix);
        createRepresentatives(lastPrefix);
        editRepresentatives(lastPrefix, newPrefix);
        checkRepresentatives(newPrefix, true);
        checkRepresentatives(lastPrefix, false);
        logout();
    }

    /**
     * Цель: Удаление шаблона проверочных листов
     * HP ALM td://ерп.default.10.215.0.15:8080/qcbin/TestPlanModule-00000000395028973?EntityType=ITest&EntityID=291
     *
     * @author Troickij D.A. 04.2022
     */
    @Test(description = "Удаление шаблона проверочных листов")
    public void deleteRepresentativesERPTest() throws Exception {
        String prefix = UUID.randomUUID().toString();
        authorization("supervisor");
        clickPersonalAccount();
        scrollTopHtml();
        goToAuthorizedToConductMenu();
        System.out.printf("Удаляемый уполномоченный %s%n", prefix);
        createRepresentatives(prefix);
        deleteRepresentatives(prefix);
        checkRepresentatives(prefix, false);
        logout();
    }
}
