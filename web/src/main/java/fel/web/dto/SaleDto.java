package fel.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class SaleDto extends BaseDto {
    private Long clientId;
    private Long bookId;
}
