package com.dh.sisteseguridad.services;

import com.dh.sisteseguridad.model.Inventary;
import com.dh.sisteseguridad.repositories.InventaryRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventaryServiceImpl extends GeneralServiceImpl<Inventary> implements InventaryService {
    InventaryRepository inventaryRepository;

    public InventaryServiceImpl(InventaryRepository inventaryRepository) {
        this.inventaryRepository = inventaryRepository;
    }



    @Override
    protected CrudRepository<Inventary, Long> getRepository() {
        return inventaryRepository;
    }

    @Override
    public List<Inventary> findByCode(String code) {
        List<Inventary>  inventaries = new ArrayList<>();
        inventaryRepository.findByCode(code).get().iterator().forEachRemaining(inventaries::add);
        return inventaries;
    }
}
