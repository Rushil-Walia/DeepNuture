package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Get all stock details of Facebook in the month of September 2019
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // Get all google stock details where the stock price was greater than 1250
    List<Stock> findByCodeAndCloseGreaterThan(String code, java.math.BigDecimal closePrice);

    // Find the top 3 dates which had highest volume of transactions
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Identify three dates when Netflix stocks were the lowest
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
