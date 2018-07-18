package com.dh.sisteseguridad.repositories;

import org.springframework.data.repository.CrudRepository;
import com.dh.sisteseguridad.model.Incident;

public interface IncidentRepository extends CrudRepository<Incident, Long> {
}
