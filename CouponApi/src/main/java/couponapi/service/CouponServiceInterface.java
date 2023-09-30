package couponapi.service;

import couponapi.dto.CouponDto;
import couponapi.dto.CouponResponse;

public interface CouponServiceInterface {

     CouponResponse getCoupons(int pageNo, int pageSize);
     CouponDto getCoupon(String couponCode) ;
     CouponDto addCoupon(CouponDto couponDto);
     void deleteCoupon(String couponCode);
     CouponDto updateCoupon(CouponDto couponDto);
     Boolean couponValiadation(String couponCode);
     float CouponConsumption(String couponCode, int orderId);

}
