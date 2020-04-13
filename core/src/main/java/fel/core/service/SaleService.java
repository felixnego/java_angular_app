package fel.core.service;

import fel.core.model.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> getAllSales();

    Sale saveSale(Sale sale);
}
