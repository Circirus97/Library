package com.riwi.library.api.dto.request;

import com.riwi.library.utils.enums.StatusReservation;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationUpdateRequest {


    @NotNull(message = "Required reservation date")
    @Future(message = "The date is invalid, it must be greater than the current date.")
    private LocalDate reservationDate;

    @NotNull(message = "Required status")
    private StatusReservation status;

}
