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
public class Sale extends BaseEntity<Long> {
    private Long clientId;
    private Long bookId;
}
