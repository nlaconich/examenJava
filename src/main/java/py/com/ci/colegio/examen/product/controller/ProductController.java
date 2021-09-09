package py.com.ci.colegio.examen.product.controller;

import java.util.List;
import py.com.ci.colegio.examen.product.boundary.ProductManager;
import py.com.ci.colegio.examen.product.entities.Product;


/**
 * @author nick
 */
public class ProductController {

    ProductManager productManager = new ProductManager();

    public void add(Product product) {
        productManager.add(product);
    }

    public List<Product> getAll() {
        List<Product> productList= productManager.getAll();
        return productList;
    }

    public boolean update(Product product) {
        boolean ban=productManager.updateById(product);
        return ban;
    }

    public boolean delete(Product product) {
        boolean ban=productManager.deleteById(product);
        return ban;
    }
    
}
