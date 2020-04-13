package fel.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class Book extends BaseEntity<Long> {
    private String title;
    private String author;
    private int price;
    private int year;

}
