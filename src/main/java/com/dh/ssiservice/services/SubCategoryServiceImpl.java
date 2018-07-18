package com.dh.ssiservice.services;

import com.dh.ssiservice.model.SubCategory;
import com.dh.ssiservice.repository.SubCategoryRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryServiceImpl extends GenericServiceImpl<SubCategory> implements SubCategoryService {
    private SubCategoryRepository subCategoryRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    protected CrudRepository<SubCategory, Long> getRepository() {
        return subCategoryRepository;
    }
}
