package com.dh.sisteseguridad.services;

import com.dh.sisteseguridad.model.Training;

import java.util.List;

public interface TrainingService extends GeneralService<Training> {
    List<Training>findByCode(String code);


}
