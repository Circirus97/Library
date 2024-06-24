package com.riwi.library.infraestructure.abstract_service;

import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.response.LoanAllInfoResponse;
import com.riwi.library.api.dto.response.LoanResponse;

public interface ILoanService extends
        CrudService<LoanRequest, LoanResponse, Long>{

    LoanAllInfoResponse findById(Long id);
}