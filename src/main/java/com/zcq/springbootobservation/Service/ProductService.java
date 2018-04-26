package com.zcq.springbootobservation.Service;


import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.ProductType;
import com.zcq.springbootobservation.Mapper.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productTypeDao;

    public List<ProductType> getAll(){
        return productTypeDao.getAll();
    }
    public AllType getRecordById(String Id){return productTypeDao.getRecordById(Id);}
    public List<AllType> search(AllType allType){return productTypeDao.search(allType);}
    public void insert(AllType allType){productTypeDao.insert(allType);}
}
