package py.com.ci.colegio.examen.sale.boundary;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import py.com.ci.colegio.examen.sale.entities.Sale;
import py.com.ci.colegio.examen.utils.ConnectionManager;


/**
 *
 * @author nick
 */
public class SaleManager {

    Sale sale  = new Sale();

    public String getStatement() {
        String statement = "SELECT id_sale, id_client, id_product FROM public.sale";
        return statement;
    }

    public Sale getFromRsProduct(ResultSet rs) {
        try {
            Sale data = new Sale();
            data.setSaleId(rs.getInt("id_sale"));
            data.setClientId(rs.getInt("id_client"));
            data.setProductId(rs.getInt("id_product"));
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void add(Sale sale) {
        String sql = "INSERT INTO public.sale(id_client,id_product) VALUES (?,?)";

        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, sale.getClientId());
            s1.setInt(2, sale.getProductId());
            s1.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Sale> getAll() {
        List<Sale> listSale = new ArrayList();
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try ( ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listSale.add(getFromRsProduct(rs));
                }
            }
            return listSale;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public boolean deleteById(Sale sale) {
        String sql = "DELETE FROM public.sale WHERE id_sale= ?";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, sale.getSaleId());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean updateById(Sale sale) {
        String sql = "UPDATE public.sale SET id_client=?, id_product=? WHERE id_sale=?";
        try ( PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, sale.getClientId());
            s1.setInt(2, sale.getProductId());
            s1.setInt(3, sale.getSaleId());
            s1.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
