package nl.inholland.myfirstapi;

import nl.inholland.myfirstapi.model.Brand;
import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.model.Stock;
import nl.inholland.myfirstapi.service.BrandService;
import nl.inholland.myfirstapi.service.GuitarService;
import nl.inholland.myfirstapi.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
public class GuitarShopApplicationRunner implements ApplicationRunner {

    @Autowired
    private GuitarService guitarService;
    @Autowired
    private StockService stockService;
    @Autowired
    private BrandService brandService;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Brand fender = new Brand("Fender");
        Brand gibson = new Brand("Gibson");

        List<Guitar> guitars = Arrays.asList(
                new Guitar(fender, "Telecaster", 899.00),
                new Guitar(fender, "Stratocaster", 1299.00),
                new Guitar(gibson, "Les Paul", 2999.00)
        );

        for(Guitar guitar : guitars){
            guitarService.addGuitars(guitar);
        }

        Stock stock1 = new Stock(guitars.get(0),20);
        Stock stock2 = new Stock(guitars.get(1),30);
        Stock stock3 = new Stock(guitars.get(2),40);

        brandService.addBrand(fender);
        brandService.addBrand(gibson);


        stockService.addStock(stock1);
        stockService.addStock(stock2);
        stockService.addStock(stock3);

        stockService.getAllStocks().forEach(System.out::println);


    }
}
