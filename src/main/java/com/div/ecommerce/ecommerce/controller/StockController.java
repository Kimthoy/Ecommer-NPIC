package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.StockDTO;
import com.div.ecommerce.ecommerce.mapper.StockMapper;
import com.div.ecommerce.ecommerce.model.Stock;
import com.div.ecommerce.ecommerce.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    @Autowired
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    @PostMapping
    private ResponseEntity<?>save(@RequestBody StockDTO stockDTO){
        Stock savedStock= StockMapper.INSTANCE.toStockEntity(stockDTO);
        savedStock=stockService.create(savedStock);
        return ResponseEntity.ok(StockMapper.INSTANCE.toStockDTOEntity(savedStock));
    }
    @PutMapping("{id}")
    private ResponseEntity<?>update(@PathVariable Long id, @RequestBody StockDTO stockDTO){
        Stock updatedStock=StockMapper.INSTANCE.toStockEntity(stockDTO);
        updatedStock=stockService.update(id,updatedStock);
        return  ResponseEntity.ok(StockMapper.INSTANCE.toStockDTOEntity(updatedStock));
    }
    @GetMapping("{id}")
    private ResponseEntity<?>getById(@PathVariable Long id){
        return ResponseEntity.ok(stockService.getById(id));
    }
    @GetMapping("/")
    private ResponseEntity<?>getAll(){
        return ResponseEntity.ok(stockService.getAll());
    }
    @DeleteMapping("{id}")
    private ResponseEntity<?>delete(@PathVariable Long id){
        return ResponseEntity.ok(stockService.delete(id));
    }
}
