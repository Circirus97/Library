package com.riwi.library.infraestructure.abstract_service;

import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.request.LoanUpdateRequest;
import com.riwi.library.api.dto.response.LoanAllInfoResponse;

import java.util.List;

public interface ILoanService extends
        CrudService<LoanRequest, LoanAllInfoResponse, Long> {

    LoanAllInfoResponse findById(Long id);

    List<LoanAllInfoResponse> findAllByUserId(Long userId);

    LoanAllInfoResponse updateRequest(LoanUpdateRequest request, Long id);


}
