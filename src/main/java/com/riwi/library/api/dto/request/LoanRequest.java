package com.riwi.library.api.dto.request;

import com.riwi.library.utils.enums.StatusLoan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {

    private LocalDate loanDate;

    private LocalDate returnDate;

    private StatusLoan status;
    private Long userId;
    private Long bookId;

}
