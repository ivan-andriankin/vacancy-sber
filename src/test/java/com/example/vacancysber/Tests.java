package com.example.vacancysber;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

@Tag("vacancy_tests")
public class Tests extends TestBase {

    @Severity(SeverityLevel.NORMAL)
    @MethodSource("menuItems")
    @ParameterizedTest(name="AT - Проверить набор кнопок {0} верхней панели на английском и на русском")
    void checkSetOfButtonsInTopMenuInEnglishAndRussian(List<String> buttons) {
        siteObjects.openPage()
                .changeLanguage()
                .checkButtonsInTopMenu(buttons)
        ;
    }


    @Severity(SeverityLevel.NORMAL)
    @DisplayName("AT - Найти вакансию 'QA Automation Engineer' в 'SberTech'")
    @Test
    void findVacancyInSberTech() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit(searchValueSberTech)
                .unsetCurrentCityFromFilter(currentCityRus)
                .goToCompanyPageFromVacancyCard(searchValueSberTech)
//                .expandVacanciesDropDownCategories("Вакансии в других регионах")
                .expandVacanciesDropDownCategories("Тестировщик")
                .clickOnTheVacancy("QA Automation Engineer")
                .checkVacancyTitle("QA Automation Engineer")
                .clickVacancyResponseButton()
        ;
    }


    @Severity(SeverityLevel.NORMAL)
    @DisplayName("AT - Найти текст в секции описания вакансии")
    @Test
    void findTextInVacancyDescriptionSection() {
        siteObjects.openPage()
            .putValueInSearchFieldAndSubmit(searchValueSberTech)
//            .unsetCurrentCityFromFilter(currentCityRus)
            .goToCompanyPageFromVacancyCard(searchValueSberTech)
//            .expandVacanciesDropDownCategories("Вакансии в других регионах")
            .expandVacanciesDropDownCategories("Тестировщик")
            .clickOnTheVacancy("QA Automation Engineer")
            .findTextInVacancyDescription("QA Engineer")
        ;
    }


    @Severity(SeverityLevel.NORMAL)
    @DisplayName("AT - Проверить наличие кнопки 'Госуслуги' на странице вакансии")
    @Test
    void checkGosuslugiAccountButtonOnVacancyPage() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit(searchValueSberTech)
//                .unsetCurrentCityFromFilter(currentCityRus)
                .goToCompanyPageFromVacancyCard(searchValueSberTech)
//                .expandVacanciesDropDownCategories("Вакансии в других регионах")
                .expandVacanciesDropDownCategories("Тестировщик")
                .clickOnTheVacancy("QA Automation Engineer")
                .checkGosuslugiAccountButtonPresent()
        ;
    }


    @Severity(SeverityLevel.NORMAL)
    @DisplayName("AT - Проверить кнопку 'Я хочу тут работать'")
    @Test
    void checkButtonIWantToWorkHere() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit(searchValueSberTech)
//                .unsetCurrentCityFromFilter(currentCityRus)
                .goToCompanyPageFromVacancyCard(searchValueSberTech)
                .clickOnButtonIWantToWorkHere()
                .checkEnterTheSiteHeader()
        ;
    }

}
