package com.dh.sisteseguridad.repositories;

import org.springframework.data.repository.CrudRepository;
import com.dh.sisteseguridad.model.Training;

import java.util.BitSet;
import java.util.List;
import java.util.Optional;

public interface TrainingRepository extends CrudRepository<Training, Long> {
    Optional<List<Training>>findByCode(String code);
    @Override
    List<Training> findAll();
}
