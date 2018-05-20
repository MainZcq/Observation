package com.zcq.springbootobservation.Service;


import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.ShoppingCartType;
import com.zcq.springbootobservation.Mapper.ShoppingCartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    public List<AllType> getProductsList(String userName){return shoppingCartDao.getProductsList(userName);}
    public void insertIntoShoppingCart(ShoppingCartType shoppingCartType){shoppingCartDao.insertIntoShoppingCart(shoppingCartType);}
    public List<ShoppingCartType> getListByUsername(String userName){return shoppingCartDao.getListByUsername(userName);}
    public void deleteRocords(ShoppingCartType shoppingCartType){shoppingCartDao.deleteRocords(shoppingCartType);}

}
