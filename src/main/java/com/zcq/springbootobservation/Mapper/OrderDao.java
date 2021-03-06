package com.zcq.springbootobservation.Mapper;

import com.zcq.springbootobservation.Entity.OrderType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDao {
    @Select("select * from orders ")
    List<OrderType> getAll();

    @Select("select * from orders left join products on products.productID " +
            "= orders.productId where orders.username = #{0}")
    List<OrderType> getListByUserId(String username);

    @Select("select * from orders order by orderId desc limit 1")
    OrderType getMaxIdRecord();

    @Insert("insert into orders values (#{orderId},#{productID},#{username}," +
            "#{orderName},#{orderIntro},#{orderTime})")
    void orderToDataBases(OrderType orderType);

    @Select("select * from orders left join products on products.productID = orders.productId " +
            " where orderName=#{arg0} and orderIntro=#{arg1} and username=#{arg2} and orderTime=#{arg3}")
    List<OrderType> getRecordBySevField(String orderName,String orderIntro,String userName,String orderTime);
}
