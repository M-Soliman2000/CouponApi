package couponapi.service;

import couponapi.model.ConsumptionHistory;

import java.util.Date;
import java.util.List;

public interface CouponHistory {

     List<ConsumptionHistory> getCouponHistory(String couponCode);
     List<ConsumptionHistory> getProductHistoryWithinPeriod(Date start, Date end);
}
