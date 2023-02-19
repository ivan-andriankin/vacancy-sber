package com.example.vacancysber;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SiteObjects {

    private SelenideElement
            searchInput = $("#a11y-search-input"),
            vacancyTitle = $("[data-qa=vacancy-title]"),
            vacancyResponseLink = $("[data-qa=vacancy-response-link-top]")
    ;

    private ElementsCollection
            languageButton = $$(".lang--N5GSKUyI3fBf0bLLxFVh"),
            buttonsInTopMenu = $$(".supernova-navi-item.supernova-navi-item_lvl-1"),
            locationForVacancy = $$("[data-qa=serp__novafilter-title]"),
            allDivElements = $$("div"),
            companyNameInVacancyCard = $$("[data-qa=vacancy-serp__vacancy-employer]"),
            allButtonsForVacanciesInProfile = $$("button[data-qa=vacancies-in-prof-role-switch]"),
            particularVacancy = $$(".bloko-link")
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

}
