package com.dh.sisteseguridad.repositories;

import org.springframework.data.repository.CrudRepository;
import com.dh.sisteseguridad.model.IncidentRegistry;

import java.util.BitSet;
import java.util.List;
import java.util.Optional;

public interface IncidentRegistryRepository extends CrudRepository<IncidentRegistry, Long> {
    Optional<List<IncidentRegistry>> findByName(String name);
}
