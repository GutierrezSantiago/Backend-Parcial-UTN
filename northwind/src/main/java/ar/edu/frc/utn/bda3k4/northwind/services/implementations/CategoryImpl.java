package ar.edu.frc.utn.bda3k4.northwind.services.implementations;

import ar.edu.frc.utn.bda3k4.northwind.entities.Category;
import ar.edu.frc.utn.bda3k4.northwind.repositories.CategoryRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.CategoryService;

import java.util.List;

public class CategoryImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category add(Category entity) {
        return this.categoryRepository.save(entity);
    }

    @Override
    public Category update(Category entity) {
        Category category = this.categoryRepository.findById(entity.getId()).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        return this.categoryRepository.save(category);
    }

    @Override
    public Category delete(Integer id) {
        Category category = this.categoryRepository.findById(id).orElse(null);
        if(category != null){
            this.categoryRepository.delete(category);
            return category;
        }
        return null;
    }

    @Override
    public Category findById(Integer id) {
        return this.categoryRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Category not found"));
    }
}
