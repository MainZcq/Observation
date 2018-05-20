package com.zcq.springbootobservation.Mapper;

import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.ShoppingCartType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShoppingCartDao {

    @Select("select * from shoppingCart where userName=#{0}")
    List<ShoppingCartType> getListByUsername(String username);

    @Select("select * from shoppingCart left join products on products.productID = shoppingCart.productID where userName=#{0}")
    List<AllType> getProductsList(String username);

    @Insert("insert  into shoppingCart (productID,userName) values (#{productID},#{userName})")
    void insertIntoShoppingCart(ShoppingCartType shoppingCartType);

    @Delete("delete  from shoppingCart where productID = #{productID} and userName = #{userName}")
    void deleteRocords(ShoppingCartType shoppingCartType);
}
