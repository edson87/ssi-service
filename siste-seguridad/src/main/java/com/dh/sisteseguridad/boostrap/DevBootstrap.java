package com.dh.sisteseguridad.boostrap;


import com.dh.sisteseguridad.model.Incident;
import com.dh.sisteseguridad.model.IncidentRegistry;
import com.dh.sisteseguridad.model.Inventary;
import com.dh.sisteseguridad.model.Training;
import com.dh.sisteseguridad.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    BuyOrderRepository buyOrderRepository;
    IncidentRegistryRepository incidentRegistryRepository;
    IncidentRepository incidentRepository;
    InventaryRepository inventaryRepository;
    TrainingRepository trainingRepository;

    public DevBootstrap(BuyOrderRepository buyOrderRepository, IncidentRegistryRepository incidentRegistryRepository, IncidentRepository incidentRepository, InventaryRepository inventaryRepository, TrainingRepository trainingRepository) {
        this.buyOrderRepository = buyOrderRepository;
        this.incidentRegistryRepository = incidentRegistryRepository;
        this.incidentRepository = incidentRepository;
        this.inventaryRepository = inventaryRepository;
        this.trainingRepository = trainingRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){
        Incident drop = new Incident();
        drop.setNombre("BROKEN FOOT");
        drop.setCode("AA1");
        incidentRepository.save(drop);

        IncidentRegistry i1 = new IncidentRegistry();
        i1.setName("JUAN RAFAEL");
        i1.setIncident(drop);
        i1.setDate(new Date(2018,7,11));
        i1.setReason("Cleaning the windows");
        incidentRegistryRepository.save(i1);

        Inventary pens = new Inventary();
        pens.setCode("P11");
        pens.setEstado("EXISTENTE");
        pens.setNombre("PENCIL");
        pens.setQuantity("50");
        inventaryRepository.save(pens);

        Inventary mouse = new Inventary();
        pens.setCode("M11");
        pens.setEstado("EXISTENTE");
        pens.setNombre("MOUSE");
        pens.setQuantity("30");
        inventaryRepository.save(pens);

        Training QA = new Training();
        QA.setCode("187");
        QA.setArea("INFORMATICA");
        QA.setName("JUAN SANCHES");
        QA.setSkill("BASIC DEV");
        trainingRepository.save(QA);
    }
}
