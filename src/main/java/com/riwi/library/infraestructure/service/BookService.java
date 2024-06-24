package com.riwi.library.infraestructure.service;

import com.riwi.library.api.dto.request.BookRequest;
import com.riwi.library.api.dto.response.BookAllInfoResponse;
import com.riwi.library.api.dto.response.BookResponse;
import com.riwi.library.domain.entities.Book;
import com.riwi.library.domain.repositories.BookRepository;
import com.riwi.library.infraestructure.abstract_service.IBookService;
import com.riwi.library.infraestructure.mappers.BookMapper;
import com.riwi.library.utils.exception.BadRequestException;
import com.riwi.library.utils.message.ErrorMessages;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookAllInfoResponse findById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::bookToBookAllInfoResponse)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("Book")));
    }

    @Override
    public BookResponse create(BookRequest request) {

        Book book = bookMapper.bookRequestToBook(request);

        return bookMapper.bookToBookResponse(bookRepository.save(book));
    }

    @Override
    public Page<BookResponse> getAll(int page, int size) {

        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.bookRepository.findAll(pagination)
                .map(bookMapper::bookToBookResponse);
    }

    @Override
    public BookResponse update(BookRequest request, Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.IdNotFound("User")));

        Book bookRequest = bookMapper.bookRequestToBook(request);
        bookRequest.setId(book.getId());

        return bookMapper.bookToBookResponse(bookRepository.save(bookRequest));
    }

    @Override
    public void delete(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.IdNotFound("User")));

        this.bookRepository.deleteById(book.getId());


    }
}
