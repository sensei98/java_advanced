package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Stock;
import nl.inholland.myfirstapi.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    public ResponseEntity<List<Stock>> getAllStocks(){
        return new ResponseEntity<List<Stock>>(stockService.getAllStocks(), HttpStatus.OK);
    }

    @RequestMapping(value="total/{id}")
    public ResponseEntity<Map<String, Integer>>getValueOfStockByGuitarId(@PathVariable Long id){
        Map<String, Integer> responseObj = new HashMap<>();
        responseObj.put("Quantity",stockService.getValueOfStockByGuitarId(id));
        return new ResponseEntity<Map<String,Integer>>(responseObj,HttpStatus.OK);
    }

}
