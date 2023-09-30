package couponapi.controller;

import couponapi.model.ConsumptionHistory;
import couponapi.service.implemetation.CouponHistoryServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("couponHistory")
public class ConsumptionHistoryController {
    @Autowired
    CouponHistoryServiceImple couponHistoryServiceImple;

    @GetMapping("/{couponCode}")
    public ResponseEntity<List<ConsumptionHistory>> getCouponHistory(@PathVariable String couponCode)
    {
        List<ConsumptionHistory> histories = couponHistoryServiceImple.getCouponHistory(couponCode);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    @GetMapping("/{start}/{end}")
    public ResponseEntity<List<ConsumptionHistory>> getProductHistoryWithinPeriod(
            @PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end)
    {
        List<ConsumptionHistory> histories = couponHistoryServiceImple.getProductHistoryWithinPeriod(start,end);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }
}
