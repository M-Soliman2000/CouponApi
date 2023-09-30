package couponapi.service.implemetation;

import couponapi.model.ConsumptionHistory;
import couponapi.model.Coupon;
import couponapi.repository.ComsumptionHistorryRepository;
import couponapi.service.CouponHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CouponHistoryServiceImple implements CouponHistory {
    @Autowired
    ComsumptionHistorryRepository comsumptionHistorryRepository;

    public List<ConsumptionHistory> getCouponHistory( String couponCode )
    {
        Coupon coupon = new Coupon();
        coupon.setCouponCode( couponCode );
        return comsumptionHistorryRepository.findByCoupon(coupon)
                .orElseThrow( ()-> new NoSuchElementException( "threr is no Coupon with the id = " + couponCode ) );
    }

    public List<ConsumptionHistory> getProductHistoryWithinPeriod( Date start, Date end )
    {
        return comsumptionHistorryRepository.findByDateBetween( start, end )
                .orElseThrow(()-> new NoSuchElementException( "threr is no coupons " ) );
    }
}
