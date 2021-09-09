package py.com.ci.colegio.examen.product.boundary;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import py.com.ci.colegio.examen.product.entities.Product;
import py.com.ci.colegio.examen.utils.ConnectionManager;


/**
 *
 * @author nick
 */
public class ProductManager {

    Product product = new Product();

    public String getStatement() {
        String statement = "SELECT id_product, name_product, description_product FROM public.product";
        return statement;
    }

    public Product getFromRsProduct(ResultSet rs) {
        try {
            Product data = new Product();
            data.setProductId(rs.getInt("id_product"));
            data.setProductName(rs.getString("name_product"));
            data.setProcuctDescription(rs.getString("description_product"));
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void add(Product product) {
        String sql = "INSERT INTO public.product(name_product,description_product) VALUES (?,?)";

        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, product.getProductName());
            s1.setString(2, product.getProcuctDescription());
            s1.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Product> getAll() {
        List<Product> listProduct = new ArrayList();
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listProduct.add(getFromRsProduct(rs));
                }
            }
            return listProduct;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public boolean deleteById(Product product) {
        String sql = "DELETE FROM public.product WHERE id_product= ?";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, product.getProductId());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean updateById(Product product) {
        String sql = "UPDATE public.product SET name_product=?,description_product=?  WHERE id_product=?";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setString(1, product.getProductName());
            s1.setString(2, product.getProcuctDescription());
            s1.setInt(3, product.getProductId());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
