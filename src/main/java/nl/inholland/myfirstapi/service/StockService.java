package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.Repository.StockRepository;
import nl.inholland.myfirstapi.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks(){
        List<Stock> stocks = (List<Stock>) stockRepository.findAll();
        return stocks;
    }
    public void addStock(Stock stock){
        stockRepository.save(stock);
    }
    public Integer getValueOfStockByGuitarId(Long id){
        return stockRepository.getValueOfStocksByGuitarId(id);
    }
}
