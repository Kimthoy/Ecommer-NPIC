package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.exception.ResourceNotFoundException;
import com.div.ecommerce.ecommerce.model.Product;
import com.div.ecommerce.ecommerce.model.Stock;
import com.div.ecommerce.ecommerce.model.Supplier;
import com.div.ecommerce.ecommerce.repository.ProductRepository;
import com.div.ecommerce.ecommerce.repository.StockRepository;
import com.div.ecommerce.ecommerce.repository.SupplierRepository;
import com.div.ecommerce.ecommerce.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public StockServiceImpl(StockRepository stockRepository,
                            ProductRepository productRepository,
                            SupplierRepository supplierRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Stock create(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock update(Long id, Stock stock) {
        Stock updatedStock=getById(id);

        if (stock.getProduct() != null && stock.getProduct().getId() != null) {
            Product product = productRepository.findById(stock.getProduct().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + stock.getProduct().getId()));
            updatedStock.setProduct(product);
        }
        updatedStock.setQuantity(stock.getQuantity());
        updatedStock.setPrice(stock.getPrice());
        updatedStock.setLocation(stock.getLocation());

        if (stock.getSupplier() != null && stock.getSupplier().getId() != null) {
            Supplier supplier = supplierRepository.findById(stock.getSupplier().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id " + stock.getSupplier().getId()));
            updatedStock.setSupplier(supplier);
        }
        updatedStock.setLastUpdated(stock.getLastUpdated());
        return stockRepository.save(updatedStock);
    }

    @Override
    public Stock getById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found with id "+id ));
    }

    @Override
    public Stock delete(Long id) {
        Stock deleteStock=getById(id);
        stockRepository.delete(deleteStock);
        return deleteStock;
    }

    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }
}
