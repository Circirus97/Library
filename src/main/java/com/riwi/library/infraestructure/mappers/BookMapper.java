package com.riwi.library.infraestructure.mappers;

import com.riwi.library.api.dto.request.BookRequest;
import com.riwi.library.api.dto.response.BookAllInfoResponse;
import com.riwi.library.api.dto.response.BookResponse;
import com.riwi.library.domain.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservationList", ignore = true)
    Book bookRequestToBook(BookRequest request);

    BookAllInfoResponse bookToBookAllInfoResponse (Book book);

    BookResponse bookToBookResponse(Book book);

}
