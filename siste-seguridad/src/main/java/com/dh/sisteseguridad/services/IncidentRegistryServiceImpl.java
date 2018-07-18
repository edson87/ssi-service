package com.dh.sisteseguridad.services;

import com.dh.sisteseguridad.model.IncidentRegistry;
import com.dh.sisteseguridad.repositories.IncidentRegistryRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentRegistryServiceImpl extends GeneralServiceImpl<IncidentRegistry> implements IncidentRegistryService {
    IncidentRegistryRepository incidentRegistryRepository;

    public IncidentRegistryServiceImpl(IncidentRegistryRepository incidentRegistryRepository) {
        this.incidentRegistryRepository = incidentRegistryRepository;
    }

    @Override
    protected CrudRepository<IncidentRegistry, Long> getRepository() {
        return incidentRegistryRepository;
    }

    @Override
    public List<IncidentRegistry> findByName(String name) {
        List<IncidentRegistry> results = new ArrayList<>();
        incidentRegistryRepository.findByName(name).get().iterator().forEachRemaining(results::add);
        return results;
    }
}
