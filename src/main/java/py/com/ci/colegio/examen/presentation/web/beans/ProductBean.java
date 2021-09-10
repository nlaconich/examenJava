package py.com.ci.colegio.examen.presentation.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import py.com.ci.colegio.examen.product.controller.ProductController;
import py.com.ci.colegio.examen.product.entities.Product;

@Named("productBean")
@SessionScoped
public class ProductBean implements Serializable{

    private Product product;
    private ProductController productController;
    private List<Product> productList;

    @PostConstruct
    public void init() {
        product = new Product();
        productController = new ProductController();
        productList = productController.getAll();

        logProduct();
    }

    private void logProduct() {
        if (productList != null && !productList.isEmpty()) {
            System.out.println("ProductBean  - init > " + productList.size());
        } else {
            System.out.println("ProductBean  - init > no result found");
        }
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    public void addProduct(){
        productController.add(product);
        init();
    }
    
    public void updateProduct(){
        productController.update(product);
        init();
    }
    
    public void deleteProduct(){
        productController.delete(product);
        init();
    }
    
    public void onSelect(SelectEvent event) {
        this.product = (Product) event.getObject();

        FacesMessage msg = new FacesMessage("Product Selected id", String.valueOf(product.getProductId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("ProductBean > Select Row > " + this.product);

    }
}
