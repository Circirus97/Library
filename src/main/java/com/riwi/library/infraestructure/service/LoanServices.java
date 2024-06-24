package com.riwi.library.infraestructure.service;

import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.request.LoanUpdateRequest;
import com.riwi.library.api.dto.response.LoanAllInfoResponse;
import com.riwi.library.domain.entities.Book;
import com.riwi.library.domain.entities.Loan;
import com.riwi.library.domain.entities.User;
import com.riwi.library.domain.repositories.BookRepository;
import com.riwi.library.domain.repositories.LoanRepository;
import com.riwi.library.domain.repositories.UserRepository;
import com.riwi.library.infraestructure.abstract_service.ILoanService;
import com.riwi.library.infraestructure.mappers.LoanMapper;
import com.riwi.library.utils.exception.BadRequestException;
import com.riwi.library.utils.message.ErrorMessages;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LoanServices implements ILoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    private final LoanMapper loanMapper;


    @Override
    public LoanAllInfoResponse findById(Long id) {

        return loanRepository.findById(id)
                .map(loanMapper::loanToLoanAllInfoResponse)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("Loan")));
    }

    @Override
    public LoanAllInfoResponse updateRequest(LoanUpdateRequest request, Long id) {

        Loan loan = loanMapper.loanUpdateRequestToLoan(request);

        loan.setId(id);

        return loanMapper.loanToLoanAllInfoResponse(loanRepository.save(loan));
    }

    @Override
    public LoanAllInfoResponse create(LoanRequest request) {

        User user = this.userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("User")));

        Book book = this.bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("Book")));


        Loan loan = loanMapper.loanRequestToLoan(request);


        loan.setUser(user);
        loan.setBook(book);

        return this.loanMapper.loanToLoanAllInfoResponse(loanRepository.save(loan));
    }

    @Override
    public Page<LoanAllInfoResponse> getAll(int page, int size) {

        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.loanRepository.findAll(pagination)
                .map(loanMapper::loanToLoanAllInfoResponse);

    }

    @Override
    public LoanAllInfoResponse update(LoanRequest request, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("Loan")));

        loanRepository.deleteById(loan.getId());

    }

    private List<LoanAllInfoResponse> entityToresponseList(List<Loan> reservations){
        return reservations.stream()
                .map(loanMapper::loanToLoanAllInfoResponse)
                .toList();
    }

    @Override
    public List<LoanAllInfoResponse> findAllByUserId(Long userId) {
        return entityToresponseList(loanRepository.findAllByUser_id(userId));

    }
}
