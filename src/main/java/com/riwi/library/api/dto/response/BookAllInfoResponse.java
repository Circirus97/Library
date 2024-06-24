package com.riwi.library.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookAllInfoResponse {


    private Long id;

    private String title;

    private String author;

    private Integer publicationYear;

    private String genre;

    private String isbn;

    private List<ReservationResponse> reservationList;

    private List<LoanResponse> loans;

}
