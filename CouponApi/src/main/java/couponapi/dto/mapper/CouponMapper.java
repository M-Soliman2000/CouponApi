package couponapi.dto.mapper;

import couponapi.dto.CouponDto;
import couponapi.model.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CouponMapper
{
    CouponMapper INSTANCE = Mappers.getMapper(CouponMapper.class);
    Coupon couponDtoToCoupon (CouponDto couponDto);
    CouponDto couponToCouponDto (Coupon coupon);


}
