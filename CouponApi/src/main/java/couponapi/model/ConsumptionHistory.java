package couponapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
public class ConsumptionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int orderId;
    Date date;
    @ManyToOne
    Coupon coupon;

    public ConsumptionHistory()
    {
        date = new Date();
    }
}
