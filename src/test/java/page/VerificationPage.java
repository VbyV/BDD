package page;

import com.codeborne.selenide.Condition;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
        $("[data-test-id=code] input").setValue(verificationCode.getCode()).shouldBe(visible);
        $("[data-test-id=action-verify]").click();
        return new DashboardPage();
    }
}
