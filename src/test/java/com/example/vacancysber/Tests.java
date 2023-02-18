package com.example.vacancysber;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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


    @Test
    void test2() {

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
