package com.riwi.library.api.controller;

import com.riwi.library.api.dto.response.ReservationAllInfoResponse;
import com.riwi.library.infraestructure.abstract_service.IReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
@Tag(name = "Books")
public class BookController {

    private final IReservationService iReservationService;




    @Operation(
            summary = "List all reservations by books",
            description = "List all reservations by books")
    @GetMapping(path = "/{book_id}/reservations")
    public ResponseEntity<List<ReservationAllInfoResponse>> getAllReservationByBooks(
            @PathVariable Long book_id) {
        return ResponseEntity.ok(this.iReservationService.findAllByBookId(book_id));
    }
}
