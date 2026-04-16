package re.validation.dto;

import jakarta.validation.constraints.NotNull;
import re.validation.validator.MultipleOfTenThousand;

public class WithdrawRequestDTO {

    @NotNull(message = "withdrawAmount is required")
    @MultipleOfTenThousand
    private Long withdrawAmount;

    public Long getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(Long withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}
