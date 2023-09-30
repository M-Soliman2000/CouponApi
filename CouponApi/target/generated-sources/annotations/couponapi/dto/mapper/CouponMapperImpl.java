package couponapi.dto.mapper;

import couponapi.dto.CouponDto;
import couponapi.model.Coupon;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-28T23:00:02+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class CouponMapperImpl implements CouponMapper {

    @Override
    public Coupon couponDtoToCoupon(CouponDto couponDto) {
        if ( couponDto == null ) {
            return null;
        }

        Coupon coupon = new Coupon();

        coupon.setCouponCode( couponDto.getCouponCode() );
        coupon.setMaxNoOfUsage( couponDto.getMaxNoOfUsage() );
        coupon.setExpiryDate( couponDto.getExpiryDate() );
        coupon.setValue( couponDto.getValue() );
        coupon.setValueType( couponDto.getValueType() );

        return coupon;
    }

    @Override
    public CouponDto couponToCouponDto(Coupon coupon) {
        if ( coupon == null ) {
            return null;
        }

        CouponDto couponDto = new CouponDto();

        couponDto.setCouponCode( coupon.getCouponCode() );
        couponDto.setMaxNoOfUsage( coupon.getMaxNoOfUsage() );
        couponDto.setExpiryDate( coupon.getExpiryDate() );
        couponDto.setValue( coupon.getValue() );
        couponDto.setValueType( coupon.getValueType() );

        return couponDto;
    }
}
