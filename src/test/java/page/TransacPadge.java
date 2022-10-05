package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransacPadge {
    private SelenideElement heading = $("[data-test-id=\"dashboard\"]");
    private SelenideElement summ = $(".money-input__value");
    private SelenideElement from = $("[data-test-id=\"from\"]");
    private SelenideElement to = $("[data-test-id=\"to\"]");
    private SelenideElement button = $("[data-test-id=\"action-transfer\"]");
    private SelenideElement buttonCansel = $("[data-test-id=\"action-cancel\"]");

    public TransacPadge() {
        heading.shouldBe(visible);
    }
    public DashboardPage shouldGetTravsCards(int amount, DataHelper.CardsInfo cardsInfo) {
        summ.setValue(String.valueOf(amount));
        from.setValue(cardsInfo.getCardNumber());
        button.click();
        return new DashboardPage();

    }


}
