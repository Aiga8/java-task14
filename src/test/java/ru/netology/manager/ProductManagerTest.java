package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    private ProductManager manager;
    private ProductRepository repository;
    Product firstProduct;
    Product secondProduct;
    

    @BeforeEach
    public void setUp() {
        repository = new ProductRepository();
        manager = new ProductManager(repository); 
        firstProduct = new Product("first");
        secondProduct = new Product("second");
        manager.add(firstProduct);
        manager.add(secondProduct);  
    }
    
   
    
    @Test
    void searchBy_shouldReturnMatchingProducts() {
        Product[] expected = {firstProduct};
        Product[] actual = manager.searchBy("first");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy_shouldReturnEmptyArrayIfNoMatch() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("third");

        assertArrayEquals(expected, actual);
    }
    
}
