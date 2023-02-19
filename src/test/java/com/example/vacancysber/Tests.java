package com.example.vacancysber;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

@Tag("vacancy_tests")
public class Tests extends TestBase {

    @Severity(SeverityLevel.NORMAL)
    @MethodSource("menuItems")
    @ParameterizedTest(name="AT - Проверить набор кнопок {0} верхней панели на английском и на русском")
    void checkSetOfButtonsInTopMenuInEnglishAndRussian(List<String> buttons) {
        siteObjects.openPage()
                .changeLanguage()
                .checkButtonsInTopMenu(buttons);
    }


    @Severity(SeverityLevel.NORMAL)
    @DisplayName("AT - Найти вакансию 'QA-инженер (web)' в 'X5 Group'")
    @Test
    void test2() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit(searchValueSberTech)
//                .unsetCurrentCityFromFilter(currentCityRus)
                .clickOnCompanyCardInSearchResults(searchValueSberTech)
                .goToCompanyPageFromVacancyCard(searchValueSberTech)
//                .expandVacanciesDropDownCategories("Вакансии в других регионах")
                .expandVacanciesDropDownCategories("Тестировщик")
                .clickOnTheVacancy("QA Automation Engineer")
                .checkVacancyTitle("QA Automation Engineer")
                .clickVacancyResponseButton();
    }


    @Test
    void test3() {

    }


    @Test
    void test4() {

    }


    @Test
    void test5() {

    }

}
