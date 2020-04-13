package fel.core.service;

import fel.core.model.Sale;
import fel.core.repository.SaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    public static final Logger log = LoggerFactory.getLogger(SaleServiceImpl.class);

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> getAllSales(){
        log.trace("getAllSales --- method entered");

        List<Sale> results = saleRepository.findAll();

        log.trace("getAllSales: results={}", results);

        return results;
    }

    @Override
    public Sale saveSale(Sale sale){
        log.trace("saveSale --- method entered");
        log.trace("saving Sale={}", sale);

        return saleRepository.save(sale);
    }
    
}
