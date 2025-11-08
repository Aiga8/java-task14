package ru.netology.repository;

import ru.netology.manager.ProductManager;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;


public class ProductRepositoryTest {
    private ProductManager manager;
    private ProductRepository repository;
    Product firstProduct;
    Product secondProduct;
    

    @BeforeEach
    public void setUp() {
        repository = new ProductRepository();
        manager = new ProductManager(repository);
        firstProduct = new Product();
        secondProduct = new Product();
    }
   
    
    @Test
    void addProduct_shouldAddNewProduct() {
        manager.add(firstProduct);

        int expected = 1;
        int actual = repository.findAll().length;

        assertEquals(expected, actual);

    }

    @Test
    void removeById_shouldRemoveProductById() {
        manager.add(firstProduct);
        manager.add(secondProduct);
        firstProduct.setId(1);
        secondProduct.setId(2);
        
        repository.removeById(1);

        int expectedId = 2;
        int actualId = repository.findAll()[0].getId();
        
        assertEquals(expectedId, actualId);

    }

    @Test
    void findAll_shouldReturnAllProducts() {
        manager.add(firstProduct);
        manager.add(secondProduct);
        

        int expected = 2;
        int actual = repository.findAll().length;

        assertEquals(expected, actual);

    }
    
    
}
