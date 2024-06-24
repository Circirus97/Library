package com.riwi.library.infraestructure.mappers;

import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.api.dto.response.LoanAllInfoResponse;
import com.riwi.library.api.dto.response.LoanResponse;
import com.riwi.library.api.dto.response.UserAllInfoResponse;
import com.riwi.library.api.dto.response.UserResponse;
import com.riwi.library.domain.entities.Loan;
import com.riwi.library.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "user", ignore = true)
    Loan loanRequestToLoan(LoanRequest request);


    LoanAllInfoResponse loanToLoanAllInfoResponse(Loan loan);

    LoanResponse loanToLoanResponse(Loan loan);

}
