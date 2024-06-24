package com.riwi.library.api.dto.request;

import com.riwi.library.utils.enums.StatusLoan;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanUpdateRequest {

    @Future(message = "The date is invalid, it must be greater than the current date.")
    private LocalDate loanDate;

    private LocalDate returnDate;

    private StatusLoan status;


}