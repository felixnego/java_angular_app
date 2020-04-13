package fel.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class ClientDto extends BaseDto {
    private String name;
    private String email;
}
