package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection buttonTrans = $$("[data-test-id=\"action-deposit\"]");
    private SelenideElement buttonUp = $("[data-test-id=\"action-reload\"]");
    private ElementsCollection cards = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
        heading.shouldBe(visible);
    }
    public int getFirstCardBalance(DataHelper.CardsInfo numberForFirstCard) {
        val text = cards.first().text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
    public TransacPadge transacFirstCard() {
     buttonTrans.first().click();
     return new TransacPadge();
    }
    public  TransacPadge transSecondCard() {
        buttonTrans.last().click();
        return new TransacPadge();
    }
    public DashboardPage clicButtonUp() {
        buttonUp.click();
        return new DashboardPage();
    }


}
