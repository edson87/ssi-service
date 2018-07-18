package com.dh.sisteseguridad.services;

import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GeneralServiceImpl<T> implements GeneralService<T> {

    @Override
    public List<T> findAll() {
        List<T> results = new ArrayList<>();
        getRepository().findAll().forEach(results::add);
        return results;
    }

    @Override
    public T findById(Long id) {
        Optional<T> results = getRepository().findById(id);
        if (!results.isPresent()){
            throw new RuntimeException(
                    getType() + " NotFound");
        }
        return results.get();
    }

    private String getType() {
        String typeName = (((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
        typeName = typeName.substring(typeName.lastIndexOf(".") + 1);
        return typeName;
    }

    public T save(T model){
       return getRepository().save(model);
    }


    protected abstract CrudRepository<T, Long> getRepository();

}
