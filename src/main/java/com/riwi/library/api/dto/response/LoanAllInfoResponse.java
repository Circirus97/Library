package com.riwi.library.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanAllInfoResponse {

    private Long id;

    private LocalDate loanDate;

    private LocalDate returnDate;

    private String status;

    private UserResponse user;

    private BookResponse book;

}
