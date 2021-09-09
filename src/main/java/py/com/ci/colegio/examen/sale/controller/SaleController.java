package py.com.ci.colegio.examen.sale.controller;

import java.util.List;
import py.com.ci.colegio.examen.sale.boundary.SaleManager;
import py.com.ci.colegio.examen.sale.entities.Sale;


/**
 * @author nick
 */
public class SaleController {

    SaleManager saleManager = new SaleManager();

    public void add(Sale sale) {
        saleManager.add(sale);
    }

    public List<Sale> getAll() {
        List<Sale> saleList= saleManager.getAll();
        return saleList;
    }

    public boolean update(Sale sale) {
        boolean ban=saleManager.updateById(sale);
        return ban;
    }

    public boolean delete(Sale sale) {
        boolean ban=saleManager.deleteById(sale);
        return ban;
    }
    
}
