package com.riwi.library.infraestructure.service;

import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.response.LoanAllInfoResponse;
import com.riwi.library.api.dto.response.LoanResponse;
import com.riwi.library.domain.repositories.LoanRepository;
import com.riwi.library.domain.repositories.UserRepository;
import com.riwi.library.infraestructure.abstract_service.ILoanService;
import com.riwi.library.infraestructure.mappers.LoanMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LoanServices implements ILoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;

    private final LoanMapper loanMapper;


    @Override
    public LoanAllInfoResponse findById(Long id) {
        return null;
    }

    @Override
    public List<LoanAllInfoResponse> findAllByUserId(Long userId) {
        return List.of();
    }

    @Override
    public LoanResponse create(LoanRequest request) {
        return null;
    }

    @Override
    public Page<LoanResponse> getAll(int page, int size) {
        return null;
    }

    @Override
    public LoanResponse update(LoanRequest request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
