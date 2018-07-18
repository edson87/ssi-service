package com.dh.sisteseguridad.services;

import com.dh.sisteseguridad.model.Training;
import com.dh.sisteseguridad.repositories.TrainingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingServiceImpl extends GeneralServiceImpl<Training> implements TrainingService {
    TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }


    @Override
    protected CrudRepository<Training, Long> getRepository() {
        return trainingRepository;
    }

    @Override
    public List<Training> findByCode(String code) {
        List<Training> results = new ArrayList<>();
        trainingRepository.findByCode(code).get().iterator().forEachRemaining(results::add);
        return results;
    }
}
