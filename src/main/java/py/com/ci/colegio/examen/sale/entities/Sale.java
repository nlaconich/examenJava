
package py.com.ci.colegio.examen.sale.entities;

/**
 *
 * @author nick
 */
public class Sale {
    private int saleId;
    private int clientId;
    private int productId;

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Sale{" + "saleId=" + saleId + ", clientId=" + clientId + ", productId=" + productId + '}';
    }
    
    
    
}
