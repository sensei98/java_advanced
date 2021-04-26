package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.Repository.BrandRepository;
import nl.inholland.myfirstapi.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands(){
        return (List<Brand>) brandRepository.findAll();
    }

    public Brand addBrand(Brand brand){
        return brandRepository.save(brand);
    }
    //finding by name
    public Brand findBrandByName(String name){
        return brandRepository.findBrandByName(name);
    }
}
