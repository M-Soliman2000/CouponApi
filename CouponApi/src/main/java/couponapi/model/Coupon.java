package couponapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
public class Coupon {
    @Id
    private String couponCode;
    private int maxNoOfUsage;

    private int currentNoOfUsage;

    private Date expiryDate;
    private float value;
    private String valueType;
    private Boolean status;

    public Coupon()
    {
        status = true;
    }
}
