package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void addProduct(Product product) {
        int t = products.length + 1;
        Product[] tmp = new Product[t];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void removeById (int id) {
       Product[] tmp = new Product[products.length - 1];
       int j = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() != id) {
                tmp[j] = products[i];
                j++;
            } else {
                
            }
        }
        products = tmp;
     }

    public Product[] findAll() {
        return products;    
    }
    
    
}
