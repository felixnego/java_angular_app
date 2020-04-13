package fel.web.converter;

import fel.core.model.Sale;
import org.springframework.stereotype.Component;
import fel.web.dto.SaleDto;

@Component
public class SaleConverter extends BaseConverter<Sale, SaleDto> {
    @Override
    public Sale convertDtoToModel(SaleDto dto) {
        Sale sale = Sale.builder()
                .clientId(dto.getClientId())
                .bookId(dto.getBookId())
                .build();
        sale.setId(dto.getId());
        return sale;
    }

    @Override
    public SaleDto convertModelToDto(Sale sale){
        SaleDto dto = SaleDto.builder()
                .clientId(sale.getClientId())
                .bookId(sale.getBookId())
                .build();
        dto.setId(sale.getId());
        return dto;
    }
}
