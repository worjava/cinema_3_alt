package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.models.entitys.CollectionCategories;
import com.kata.cinema.base.repository.CollectionCategoryRepository;
import com.kata.cinema.base.service.entity.CollectionCategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionCategoryServiceImpl implements CollectionCategoryService {

    private final CollectionCategoryRepository collectionCategoryRepository;

    public CollectionCategoryServiceImpl(CollectionCategoryRepository collectionCategoryRepository) {
        this.collectionCategoryRepository = collectionCategoryRepository;
    }

    @Override
    public List<CollectionCategories> getAllCollectionCategories() {
        return collectionCategoryRepository.findAll();
    }

    @Override
    public CollectionCategories getCollectionCategoriesById(Long id) {
        return collectionCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCollectionCategories(CollectionCategories collectionCategories) {
        if (!collectionCategoryRepository.existsById(collectionCategories.getId())) {
            throw new EntityNotFoundException("Category with id " + collectionCategories.getId() + " not found");
        }
        collectionCategoryRepository.delete(collectionCategories);
    }

    @Override
    public void createCollectionCategories(CollectionCategories collectionCategories) {
        collectionCategoryRepository.save(collectionCategories);
    }


    @Override
    public void updateCollectionCategories(CollectionCategories collectionCategories) {
        collectionCategoryRepository.save(collectionCategories);
    }
}
