package couponapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponDto {
    private String couponCode;
    private int maxNoOfUsage;
    private Date expiryDate;
    private float value;
    private String valueType;
}
