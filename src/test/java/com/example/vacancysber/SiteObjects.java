package com.example.vacancysber;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SiteObjects {

    private SelenideElement
            searchInput = $("#a11y-search-input"),
            vacancyTitle = $("div[class=vacancy-title]"),
            vacancyResponseLink = $("a[data-qa=vacancy-response-link-top]"),
            gosuslugiAccountButton = $("a[data-qa=account-account-login-social-esia"),
            vacancyDescription = $("div[class=vacancy-description]"),
            buttonIWantToWorkHere = $("a[data-qa=resumeservice-button__targetemployer]")
    ;

    private ElementsCollection
            languageButton = $$(".lang--N5GSKUyI3fBf0bLLxFVh"),
            buttonsInTopMenu = $$(".supernova-navi-item.supernova-navi-item_lvl-1"),
            locationForVacancy = $$("span[data-qa=serp__novafilter-title]"),
            allDivElements = $$("div"),
            companyNameInVacancyCard = $$("a[data-qa=vacancy-serp__vacancy-employer]"),
            allButtonsForVacanciesInProfile = $$("button[data-qa=vacancies-in-prof-role-switch]"),
            particularVacancy = $$(".bloko-link"),
            enterTheSiteHeader = $$(".bloko-header-section-2")
    ;


    public SiteObjects openPage() {
        open("/");
        return this;
    }

    public SiteObjects changeLanguage() {
        languageButton.last().click();
        return this;
    }

    public SiteObjects checkButtonsInTopMenu(List<String> value) {
        buttonsInTopMenu.shouldHave(texts(value));
        return this;
    }

    public SiteObjects putValueInSearchFieldAndSubmit(String value) {
        searchInput.setValue(value);
        $("[data-qa=search-button]").click();
        return this;
    }

    public SiteObjects unsetCurrentCityFromFilter(String value) {
        locationForVacancy.findBy(text(value)).click();
        return this;
    }

    public SiteObjects clickOnCompanyCardInSearchResults(String value) {
        allDivElements.findBy(text(value)).click();
        return this;
    }

    public SiteObjects goToCompanyPageFromVacancyCard(String value) {
        companyNameInVacancyCard.findBy(text(value)).click();
        return this;
    }

    public SiteObjects expandVacanciesDropDownCategories(String value) {
        allButtonsForVacanciesInProfile.findBy(text(value)).click();
        return this;
    }

    public SiteObjects clickOnTheVacancy(String value) {
        particularVacancy.findBy(text(value)).click();
        return this;
    }

    public SiteObjects checkVacancyTitle(String value) {
        vacancyTitle.shouldHave(text(value));
        return this;
    }

    public SiteObjects clickVacancyResponseButton() {
        vacancyResponseLink.click();
        return this;
    }

    public SiteObjects findTextInVacancyDescription(String value) {
        vacancyDescription.shouldHave(text(value));
        return this;
    }

    public SiteObjects clickOnGosuslugiAccountButton() {
        gosuslugiAccountButton.click();
        return this;
    }

    public SiteObjects verifyPageUrl(String value) {
        assertEquals(value, url());
        return this;
    }

    public SiteObjects clickOnButtonIWantToWorkHere() {
        buttonIWantToWorkHere.click();
        return this;
    }

    public SiteObjects checkEnterTheSiteHeader() {
        enterTheSiteHeader.first().shouldHave(text("Войдите на сайт"));
        return this;
    }

}
