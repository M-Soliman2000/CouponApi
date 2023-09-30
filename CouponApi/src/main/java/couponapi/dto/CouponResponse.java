package couponapi.dto;

import lombok.Data;

import java.util.List;
@Data
public class CouponResponse {
    List<CouponDto> couponDtoList;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;



}
