package docs;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextBoxTests {



    @Test
    @DisplayName("Positive test")
    void FillFromTest() {
        open("https://demoqa.com/text-box");

        $("#userName").val("Vitaly Jonhson");
        $("#userEmail").val("pushkin@kolotushkin.ru");
        $("#currentAddress").val("Moscow, Russia");
        $("#permanentAddress").val("Moscow, Russian Federation");
        $("#submit").pressEnter();
        System.out.printf("");
    }


    @Test
    @DisplayName("Wrong email test") //проверяем некорректность ввода почты
    void WrongEmailTest() {
        open("https://demoqa.com/text-box");

        $("#userName").val("Vitaly Jonhson");
        $("#userEmail").val("pushkinkolotushkin.ru"); //из-за этой строки тест становится негативным. Эти данные не являются корректными для поля почты.
        $("#currentAddress").val("Moscow, Russia");
        $("#permanentAddress").val("Moscow, Russian Federation");
        $("#submit").pressEnter();
        $("#userEmail").shouldHave(cssClass("field-error"));
    }

    @Test
    @DisplayName("Variable test") //используем переменные и проверяем текст всего div'а
    void VariableTest() {
        String userName = "Vitaly Jonhson",
                userEmail = "pushkin@kolotushkin.ru",
                currentAddress = "Moscow, Russia",
                permanentAddress = "Moscow, Russian Federation";

        open("https://demoqa.com/text-box");

        $("#userName").val(userName);
        $("#userEmail").val(userEmail);
        $("#currentAddress").val(currentAddress);
        $("#permanentAddress").val(permanentAddress);
        $("#submit").pressEnter();

        $("#output").shouldHave(text("Name:" + userName + "\n" +
                "Email:" + userEmail + "\n" +
                "Current Address :" + currentAddress + "\n" +
                "Permananet Address :" + permanentAddress));
    }

}