package com.alexeypartolin;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SomeNewTest {


    @Test
    void newTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alexeypartolin@yahoo.com");
        $("#currentAddress").setValue("some address");
        $("#permanentAddress").setValue("another address");

        $("#submit").scrollTo().click();


                //userName
                //userEmail
                //currentAddress
                //permanentAddress
    }
}