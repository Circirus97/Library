package com.riwi.library.infraestructure.abstract_service;

import com.riwi.library.api.dto.request.ReservationRequest;
import com.riwi.library.api.dto.request.ReservationUpdateRequest;
import com.riwi.library.api.dto.response.ReservationAllInfoResponse;
import com.riwi.library.api.dto.response.ReservationResponse;
import com.riwi.library.domain.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IReservationService extends
        CrudService<ReservationRequest, ReservationAllInfoResponse, Long>{

    ReservationAllInfoResponse findById(Long id);

    ReservationAllInfoResponse updateRequest(ReservationUpdateRequest request, Long id);

    List<ReservationAllInfoResponse> findAllByUserId(Long userId);

    List<ReservationAllInfoResponse> findAllByBookId(Long bookId);
}
