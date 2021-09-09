package py.com.ci.colegio.examen.product.entities;
/**
 *
 * @author nick
 */
public class Product {
    private int productId;
    private String productName;
    private String procuctDescription;

    
    @Override
    public String toString() {
        return "productId=" + productId + 
                ", productName=" + productName + 
                ", procuctDescription=" + procuctDescription ;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProcuctDescription() {
        return procuctDescription;
    }

    public void setProcuctDescription(String procuctDescription) {
        this.procuctDescription = procuctDescription;
    }
    
    
}
