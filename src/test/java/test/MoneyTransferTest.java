package test;


import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage;
import page.TransacPadge;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.updateHash;

public class MoneyTransferTest {

    @Test
    void transacToFirstCard() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();

        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val dashboardPage = new DashboardPage();
        val firstCardStartBalance = dashboardPage.getFirstCardBalance();
        val secondCardStartBalance = dashboardPage.getSecondCardBalance();
        val TransacPadge = new TransacPadge();
        val transac = dashboardPage.transacFirstCard();
        val amount = 8000;
        val firstCardNewBalance = firstCardStartBalance + amount;
        val secondCardNewBalance = secondCardStartBalance - amount;
        transac.shouldGetTransCards(Integer.parseInt(String.valueOf(amount)), DataHelper.getNumberForSecondCard());
        Assertions.assertEquals(firstCardNewBalance, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(secondCardNewBalance, dashboardPage.getSecondCardBalance());

    }

    @Test
    void transacToSecondCard() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();

        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val dashboardPage = new DashboardPage();
        val firstCardStartBalance = dashboardPage.getFirstCardBalance();
        val secondCardStartBalance = dashboardPage.getSecondCardBalance();
        val TransacPadge = new TransacPadge();
        val transac = dashboardPage.transSecondCard();
        val amount = 10000;
        val firstCardNewBalance = firstCardStartBalance - amount;
        val secondCardNewBalance = secondCardStartBalance + amount;
        transac.shouldGetTransCards(Integer.parseInt(String.valueOf(amount)), DataHelper.getNumberForFirstCard());
        Assertions.assertEquals(firstCardNewBalance, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(secondCardNewBalance, dashboardPage.getSecondCardBalance());
    }

    @Test
    void shouldAmountBeBiggerThatBalance() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();

        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val dashboardPage = new DashboardPage();
        val firstCardStartBalance = dashboardPage.getFirstCardBalance();
        val secondCardStartBalance = dashboardPage.getSecondCardBalance();
        val TransacPadge = new TransacPadge();
        val transac = dashboardPage.transSecondCard();
        val amount = 11000;
        val firstCardNewBalance = firstCardStartBalance - amount;
        val secondCardNewBalance = secondCardStartBalance + amount;
        transac.shouldGetTransCards(Integer.parseInt(String.valueOf(amount)), DataHelper.getNumberForFirstCard());
        Assertions.assertEquals(firstCardNewBalance, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(secondCardNewBalance, dashboardPage.getSecondCardBalance());

    }
}
