package couponapi.controller;

import couponapi.dto.CouponDto;
import couponapi.dto.CouponResponse;
import couponapi.service.implemetation.CouponServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    CouponServiceImple couponServiceImple;
    @GetMapping
    public ResponseEntity<CouponResponse> getCoupons(
            @RequestParam( value = "pageNo", defaultValue = "0", required = false ) int pageNo,
            @RequestParam( value = "pageSize", defaultValue = "10", required = false ) int pageSize )
    {
        CouponResponse couponResponse = couponServiceImple.getCoupons( pageNo, pageSize );
        return new ResponseEntity<>( couponResponse, HttpStatus.OK );
    }

    @GetMapping( "/{couponCode}" )
    public ResponseEntity<CouponDto> getCoupon( @PathVariable String couponCode )
    {
        CouponDto couponDto = couponServiceImple.getCoupon( couponCode );
        return new ResponseEntity<>( couponDto, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity< CouponDto > addCoupon( @RequestBody CouponDto couponDto )
    {
        CouponDto returnedCouponDto = couponServiceImple.addCoupon( couponDto );
        return new ResponseEntity<>( returnedCouponDto, HttpStatus.OK );
    }

    @DeleteMapping( "/{couponCode}" )
    public ResponseEntity< Void > deleteCoupon( @PathVariable String couponCode )
    {
        couponServiceImple.deleteCoupon( couponCode );
        return new ResponseEntity<>( HttpStatus.OK );
    }

   @PutMapping
    public ResponseEntity< CouponDto > updateCoupon( @RequestBody CouponDto couponDto )
    {
        CouponDto updatedCoupon = couponServiceImple.updateCoupon( couponDto );
       return new ResponseEntity<>( updatedCoupon, HttpStatus.OK );
    }

    @GetMapping( "/validate/{couponCode}" )
    public ResponseEntity<Boolean> couponValidation(@PathVariable String couponCode )
    {
        Boolean couponValidate = couponServiceImple.couponValiadation( couponCode );
        return new ResponseEntity<>( couponValidate, HttpStatus.OK );
    }

    @GetMapping( "/consumption/{couponCode}/{orderId}" )
    public ResponseEntity<Float> couponConsumption(@PathVariable String couponCode, @PathVariable int orderId )
    {
        float value = couponServiceImple.CouponConsumption( couponCode, orderId );
        return new ResponseEntity<>( value, HttpStatus.OK );
    }

}


