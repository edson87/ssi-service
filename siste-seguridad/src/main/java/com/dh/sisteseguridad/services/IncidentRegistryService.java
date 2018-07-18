package com.dh.sisteseguridad.services;


import com.dh.sisteseguridad.model.IncidentRegistry;

import java.util.List;

public interface IncidentRegistryService extends GeneralService<IncidentRegistry> {
    List<IncidentRegistry> findByName(String name);
}
