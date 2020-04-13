package fel.web.controller;

import fel.core.model.Sale;
import fel.core.service.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fel.web.converter.SaleConverter;
import fel.web.dto.SaleDto;
import fel.web.dto.SalesDto;

import java.util.List;

@RestController
public class SaleController {
    public static final Logger log = LoggerFactory.getLogger(SaleController.class);

    @Autowired
    private SaleService saleService;

    @Autowired
    private SaleConverter saleConverter;

    @RequestMapping(value="/sales", method= RequestMethod.GET)
    SalesDto getSale(){
        log.trace("getSales --- method entered");

        List<Sale> sales = saleService.getAllSales();
        SalesDto results = new SalesDto(saleConverter.convertModelsToDtos(sales));

        return results;
    }

    @RequestMapping(value="/sales", method=RequestMethod.POST)
    SaleDto saveSale(@RequestBody SaleDto saleDto){
        log.trace("saveSale --- method entered");

        Sale savedSale = saleService.saveSale(
                saleConverter.convertDtoToModel(saleDto)
        );

        SaleDto result = saleConverter.convertModelToDto(savedSale);

        return result;
    }
}
