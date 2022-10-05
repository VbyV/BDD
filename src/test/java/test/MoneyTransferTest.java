package test;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {
    @Test
    void loginToAccount() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();

        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void showBalanceToCard() {
            open("http://localhost:9999");
            var loginPage = new LoginPage();

            var authInfo = DataHelper.getAuthInfo();
            var verificationPage = loginPage.validLogin(authInfo);
            var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
            verificationPage.validVerify(verificationCode);
            var dashboardPage = new DashboardPage();
            var firstCardBalance = dashboardPage.getFirstCardBalance(DataHelper.getNumberForFirstCard());

    }

    }
