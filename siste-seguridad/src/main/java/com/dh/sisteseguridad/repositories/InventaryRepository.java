package com.dh.sisteseguridad.repositories;

import org.springframework.data.repository.CrudRepository;
import com.dh.sisteseguridad.model.Inventary;

import java.util.BitSet;
import java.util.List;
import java.util.Optional;

public interface InventaryRepository extends CrudRepository<Inventary, Long> {

    Optional<List<Inventary>> findByCode(String code);
    @Override
    List<Inventary> findAll();
}
