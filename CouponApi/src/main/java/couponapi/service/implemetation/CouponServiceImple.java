package couponapi.service.implemetation;

import couponapi.dto.CouponDto;
import couponapi.dto.CouponResponse;
import couponapi.dto.mapper.CouponMapper;
import couponapi.model.ConsumptionHistory;
import couponapi.model.Coupon;
import couponapi.repository.ComsumptionHistorryRepository;
import couponapi.repository.CouponRepository;
import couponapi.service.CouponServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CouponServiceImple implements CouponServiceInterface {
    @Autowired
    CouponRepository couponRepository;
    @Autowired
    ComsumptionHistorryRepository comsumptionHistorryRepository;

    public CouponResponse getCoupons(int pageNo, int pageSize)
    {

        Pageable pageable = PageRequest.of( pageNo, pageSize );
        Page<Coupon> coupons = couponRepository.findAll( pageable );
        List<Coupon> couponList = coupons.getContent();

        List< CouponDto > couponDtoList = couponList.stream().map( c -> CouponMapper.INSTANCE.couponToCouponDto(c) ).collect(Collectors.toList());

        CouponResponse couponResponse = new CouponResponse();
        couponResponse.setCouponDtoList( couponDtoList );
        couponResponse.setPageNo( coupons.getNumber() );
        couponResponse.setPageSize( coupons.getSize() );
        couponResponse.setTotalElements( coupons.getTotalElements() );
        couponResponse.setTotalPages( coupons.getTotalPages() );
        couponResponse.setLast( coupons.isLast() );

        return couponResponse;
    }

    public CouponDto getCoupon(String couponCode) {
        Coupon coupon = couponRepository.findById(couponCode)
                .orElseThrow(()-> new NoSuchElementException("There no store with id = "+ couponCode ));
        return CouponMapper.INSTANCE.couponToCouponDto(coupon);
    }

    public CouponDto addCoupon(CouponDto couponDto)
    {
        Coupon coupon = CouponMapper.INSTANCE.couponDtoToCoupon(couponDto);
        Coupon returnedCoupon = couponRepository.save(coupon);
        return CouponMapper.INSTANCE.couponToCouponDto(returnedCoupon);
    }

    public void deleteCoupon(String couponCode)
    {
        couponRepository.deleteById(couponCode);
    }

    public CouponDto updateCoupon(CouponDto couponDto)
    {
        Coupon coupon = CouponMapper.INSTANCE.couponDtoToCoupon(couponDto);
        Coupon returnedCoupon = couponRepository.save(coupon);
        return CouponMapper.INSTANCE.couponToCouponDto(returnedCoupon);
    }

    public Boolean couponValiadation(String couponCode)
    {
        Coupon coupon = couponRepository.findById(couponCode)
                .orElseThrow(()-> new NoSuchElementException("There no store with id = "+ couponCode ));
        Date currentDate = new Date(System.currentTimeMillis());
        if (
                coupon.getStatus() == true
                && coupon.getCurrentNoOfUsage() <= coupon.getMaxNoOfUsage()
                && coupon.getExpiryDate().compareTo(currentDate) >= 0
           )
            return true;
        else
            return false;
    }

    public float CouponConsumption(String couponCode, int orderId)
    {
        if(!couponValiadation(couponCode))
            return 0;

        Coupon coupon = couponRepository.findById(couponCode)
                .orElseThrow(()-> new NoSuchElementException("There no store with id = "+ couponCode ));

        coupon.setCurrentNoOfUsage(coupon.getCurrentNoOfUsage()+1);
        couponRepository.save(coupon);

        ConsumptionHistory consumptionHistory = new ConsumptionHistory();
        consumptionHistory.setCoupon(coupon);
        consumptionHistory.setOrderId(orderId);

        comsumptionHistorryRepository.save(consumptionHistory);

        return coupon.getValue();
    }
}
