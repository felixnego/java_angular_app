package client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import fel.web.dto.SaleDto;
import fel.web.dto.SalesDto;

@Service
public class SaleServiceClient {
    private static final String url = "http://localhost:8080/api/sales";

    @Autowired
    private RestTemplate restTemplate;

    public SalesDto getAllSales() {
        return restTemplate.getForObject(url, SalesDto.class);
    }

    public SaleDto saveSale(SaleDto saleDto) {
        return restTemplate.postForObject(
                url,
                saleDto,
                SaleDto.class);
    }
}
