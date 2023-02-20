package com.example.vacancysber;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.vacancyhaulmont.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.stream.Stream;

public class TestBase {

    SiteObjects siteObjects = new SiteObjects();

    static String currentCityRus = "Москва";
    static String currentCityEng = "Tolyatti";
    static String searchValueSberTech = "SberTech";
    static String gosuslugiUrl = "https://esia.gosuslugi.ru/login/";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.hh.ru";
        Configuration.browser = System.getProperty("browserName","chrome");
        Configuration.browserVersion = System.getProperty("browserVersion","100.0");
        Configuration.browserSize = System.getProperty("screenSize","1366x768");
        Configuration.remote = System.getProperty("remoteBrowserAddress");  // передается из дженкинса "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);    // окошко в окошке
        capabilities.setCapability("enableVideo", true);  // запись видео
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    static Stream<Arguments> menuItems() {
        return Stream.of(
                Arguments.of(List.of(currentCityEng,
                        "For job seekers",
                        "For employers",
                        "Completed resume",
                        "Career consulting",
                        "All services")),
                Arguments.of(List.of(currentCityRus,
                        "Соискателям",
                        "Работодателям",
                        "Готовое резюме",
                        "Карьерная консультация",
                        "Все сервисы"))
        );
    }

}
