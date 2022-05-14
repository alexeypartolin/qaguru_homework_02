package com.alexeypartolin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormTest extends TestBase {

    @Test
    void newTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://demoqa.com/automation-practice-form");
        $("#userForm").$("#firstName").setValue("Alexey");
        $("#userForm").$("#lastName").setValue("Partolin");
        $("#userForm").$("#userEmail").setValue("alexeypartolin@yahoo.com");
        $("[for='gender-radio-1']").click();
        $(By.id("userNumber")).setValue("9163322170");
        $(By.id("subjectsInput")).setValue("Computer").pressEnter();
        $("#subjectsContainer").shouldHave(text("Computer Science"));
//        File pic = new File("src/test/resources/upload-folder/homeAlone.jpeg");
//        $("#uploadPicture").uploadFile(pic);
        $("#uploadPicture").uploadFromClasspath("upload-folder/homeAlone.jpeg");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2021");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#currentAddress").setValue("Ovchinnikovskaya наб., 6 стр1, Москва, 19128");
        $("#submit").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        executeJavaScript("$('footer').remove()"); // убираем рекламный баннер который мешает кликнуть на кнопку submit
        executeJavaScript("$('fixedban').remove()");
        $("#submit").scrollTo().click();

        // Asserts

        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Alexey"), text("Partolin"), text("Alexey"),
                text("alexeypartolin@yahoo.com"), text("01 July,2021"), text("Male"), text("Sports, Music"), text("NCR Noida"),
                text("9163322170"), text("homeAlone.jpeg"), text("Ovchinnikovskaya наб., 6 стр1, Москва, 19128"));
    }
}