package com.zcq.springbootobservation.Mapper;

import com.zcq.springbootobservation.Entity.AllType;
import com.zcq.springbootobservation.Entity.ProductType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductDao {
    @Select("select * from products")
    List<ProductType> getAll();

    @Select("select * from products " +
            " where products.productID = #{0}")
    AllType getRecordById(String Id);

    @Select("select * from products where satelliteID = #{satelliteID} and sensorID=#{sensorID} and NominalResolution like ifnull(#{nominalResolution},'%%') and cloudPercent like ifnull(#{cloudPercent},'%%')" +
            " and level=#{level} and leftTopLng like ifnull(#{leftTopLng},'%%') and leftTopLat like ifnull(#{leftTopLat},'%%')  and rightBottomLng like ifnull(#{rightBottomLng},'%%') and rightBottomLat like ifnull(#{rightBottomLat},'%%') ")
    List<AllType> search(AllType allType);

    @Insert("insert  ignore  into products values (#{productID},#{satelliteID},#{sensorID},#{produceTime},#{nominalResolution},#{imagingMode},#{level},#{cloudPercent},#{leftTopLng},#{leftTopLat},#{rightBottomLng},#{rightBottomLat},null,null,null,#{sceneID})")
    void insert(AllType allType);
}
