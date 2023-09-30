package couponapi.repository;

import couponapi.model.ConsumptionHistory;
import couponapi.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ComsumptionHistorryRepository extends JpaRepository<ConsumptionHistory,Integer>
{
    Optional<List<ConsumptionHistory>> findByCoupon(Coupon coupon);
    Optional<List<ConsumptionHistory>> findByDateBetween(Date start, Date end );

}

