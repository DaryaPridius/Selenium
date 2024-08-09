package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardTest {
    SelenideElement form = $(".form");

    @BeforeEach
    public void SetUp() {
        open("http://localhost:9999");
    }

    @Test
    void sendingFromWithValidData() {
        form.$("[data-test-id=name] input").setValue("Иванов Олег");
        form.$("[data-test-id=phone] input").setValue("+79884555555");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $("[data-test-id=order-success]").shouldHave(Condition.text("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void sendingFormWithDoubleSurname() {
        form.$("[data-test-id=name] input").setValue("Салтыков-Щедрин Михаил");
        form.$("[data-test-id=phone] input").setValue("+79884555555");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $("[data-test-id=order-success]").shouldHave(Condition.text("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
