package com.example.vacancysber;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SiteObjects {

    private SelenideElement element
    ;

    private ElementsCollection
            languageButton = $$(".lang--N5GSKUyI3fBf0bLLxFVh"),
            buttonsInTopMenu = $$(".supernova-navi-item.supernova-navi-item_lvl-1")
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

}
