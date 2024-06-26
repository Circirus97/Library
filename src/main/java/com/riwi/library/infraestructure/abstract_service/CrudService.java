package com.riwi.library.infraestructure.abstract_service;

import org.springframework.data.domain.Page;

public interface CrudService <RQ, RS, ID> {

    RS create(RQ request);

    Page<RS> getAll(int page, int size);

    RS update(RQ request, ID id);

    void delete(ID id);
}