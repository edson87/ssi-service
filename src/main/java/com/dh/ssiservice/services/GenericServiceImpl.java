package com.dh.ssiservice.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T> implements GenericService<T> {

    @Override
    public List<T> findAll() {
        List<T> results = new ArrayList<>();
        getRepository().findAll().forEach(results::add);
        return results;
    }


    @Override
    public T findById(Long id) {
        Optional<T> optional = getRepository().findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException(
                    getType() + " NotFound");
        }
        return optional.get();
    }

    @Override
    public T save(T model) {
        return getRepository().save(model);
    }

    @Override
    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    private String getType() {
        String typeName = (((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
        typeName = typeName.substring(typeName.lastIndexOf(".") + 1);
        return typeName;
    }


    protected abstract CrudRepository<T,Long> getRepository();
}
