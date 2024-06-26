package com.riwi.library.api.controller;

import com.riwi.library.api.dto.request.ReservationRequest;
import com.riwi.library.api.dto.request.ReservationUpdateRequest;
import com.riwi.library.api.dto.response.ReservationAllInfoResponse;
import com.riwi.library.infraestructure.abstract_service.IReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/reservation")
@AllArgsConstructor
@Tag(name = "Reservation")
public class ReservationController {

    private final IReservationService iReservationService;

    @Operation(
            summary = "List all reservations with pagination",
            description = "You must submit the page and the page size to get all the corresponding reservations")
    @GetMapping
    public ResponseEntity<Page<ReservationAllInfoResponse>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size){
        return  ResponseEntity.ok(this.iReservationService.getAll(page -1, size));
    }

    @ApiResponse(responseCode = "400", description = "When the ID is invalid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    @Operation(
            summary = "List a reservation by id",
            description = "You must send the id of the reservation to search for")
    @GetMapping(path = "{id}")
    public ResponseEntity<ReservationAllInfoResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(this.iReservationService.findById(id));
    }

    @Operation(
            summary = "Create a reservation",
            description = "Create a reservation")
    @PostMapping
    public ResponseEntity<ReservationAllInfoResponse> create(@Validated @RequestBody ReservationRequest request){
        return ResponseEntity.ok(this.iReservationService.create(request));
    }

    @ApiResponse(responseCode = "400", description = "When the request is invalid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
            summary = "Update a reservation",
            description = "Update a reservation")
    @PutMapping(path = "{id}")
    public ResponseEntity<ReservationAllInfoResponse> update(
            @Validated
            @RequestBody ReservationUpdateRequest request,
            @PathVariable Long id){
        return ResponseEntity.ok(this.iReservationService.updateRequest(request, id));
    }

    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
            summary = "Delete a reservation by id",
            description = "Delete a reservation by id")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.iReservationService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
