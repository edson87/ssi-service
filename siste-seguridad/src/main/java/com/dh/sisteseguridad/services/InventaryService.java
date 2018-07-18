package com.dh.sisteseguridad.services;

import com.dh.sisteseguridad.model.Inventary;
import com.dh.sisteseguridad.repositories.InventaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InventaryService extends GeneralService<Inventary> {
    List<Inventary> findByCode(String code);
}
