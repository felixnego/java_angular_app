package fel.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class BookDto extends BaseDto {
    private String title;
    private String author;
    private int price;
    private int year;
}
