package ar.edu.frc.utn.bda3k4.northwind.services.implementations;

import ar.edu.frc.utn.bda3k4.northwind.entities.Product;
import ar.edu.frc.utn.bda3k4.northwind.repositories.ProductRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(Product entity) {
        return this.productRepository.save(entity);
    }

    @Override
    public Product update(Integer id, Product entity) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Product not found"));
        product.update(entity);
        return this.productRepository.save(entity);
    }

    @Override
    public Product delete(Integer id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Product not found"));
        this.productRepository.delete(product);
        return product;
    }

    @Override
    public Product findById(Integer id) {
        return this.productRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Product not found"));
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = this.productRepository.findAll();
        if(products.isEmpty()){throw new IllegalArgumentException("No products found");}
        return products;
    }
}
