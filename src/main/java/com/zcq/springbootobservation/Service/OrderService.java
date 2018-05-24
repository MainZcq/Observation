package com.zcq.springbootobservation.Service;

import com.zcq.springbootobservation.Entity.OrderType;
import com.zcq.springbootobservation.Mapper.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    public List<OrderType> getAll(){return orderDao.getAll();}
    public OrderType getMaxIdRecord(){return orderDao.getMaxIdRecord();}
    public List<OrderType> getListByUserId(String cardNum){return orderDao.getListByUserId(cardNum);}
    public void orderToDataBases(OrderType orderType){orderDao.orderToDataBases(orderType);}
    public List<OrderType> getRecordBySevField(String orderName,String orderIntro,String username,String orderTime){return orderDao.getRecordBySevField(orderName,orderIntro,username,orderTime);}
}
