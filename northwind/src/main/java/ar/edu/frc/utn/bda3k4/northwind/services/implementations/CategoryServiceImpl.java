package ar.edu.frc.utn.bda3k4.northwind.services.implementations;

import ar.edu.frc.utn.bda3k4.northwind.entities.Category;
import ar.edu.frc.utn.bda3k4.northwind.repositories.CategoryRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category add(Category entity) {
        return this.categoryRepository.save(entity);
    }

    @Override
    public Category update(Category entity) {
        Category category = this.categoryRepository.findById(entity.getId())
                .orElseThrow(()->
                new IllegalArgumentException("Category not found"));
        category.setDescription(entity.getDescription());
        category.setName(entity.getName());
        category.setPicture(entity.getPicture());
        category.setProducts(entity.getProducts());
        return this.categoryRepository.save(category);
    }

    @Override
    public Category delete(Integer id) {
        Category category = this.categoryRepository.findById(id)
                .orElse(null);
        if(category != null){
            this.categoryRepository.delete(category);
            return category;
        }
        throw new IllegalArgumentException("Category not found");
    }

    @Override
    public Category findById(Integer id) {
        return this.categoryRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Category not found"));
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}
