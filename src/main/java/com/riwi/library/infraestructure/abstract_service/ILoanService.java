package com.riwi.library.infraestructure.abstract_service;

import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.response.LoanAllInfoResponse;
import com.riwi.library.api.dto.response.LoanResponse;
import com.riwi.library.domain.entities.Loan;

import java.util.List;

public interface ILoanService extends
        CrudService<LoanRequest, LoanResponse, Long> {

    LoanAllInfoResponse findById(Long id);

    List<LoanAllInfoResponse> findAllByUserId(Long userId);

}
