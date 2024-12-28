package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {
    Stock create(Stock stock);
    Stock update(Long id,Stock stock);
    Stock getById(Long id);
    Stock delete(Long id);
    List<Stock>getAll();
}
