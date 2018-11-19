package ru.innopolis.stc12.hibernate.dao;

import org.apache.ibatis.annotations.*;
import ru.innopolis.stc12.hibernate.dao.dto.Mobile;

import java.util.List;

public interface MobileMapper {
    @Select("Select * from mobile where mobile_id=#{mobileId}")
    Mobile getMobile(@Param("mobileId") Integer mobileId);

    @Insert("Insert into mobile(mobile_id, cost, manufacturer, model) " +
            "values (#{mobile_id}, #{cost}, #{developer}, #{model})")
    void insertMobile(Mobile mobile);

    @Select("Select * from mobile")
    List<Mobile> getAllMobiles();

    @Update("Update mobile " +
            "set cost = #{cost}, " +
            "manufacturer = #{developer}, " +
            "model = #{model} " +
            "where mobile_id=#{mobile_id} ")
    void updateMobile(Mobile mobile);

    @Delete("delete from mobile where mobile_id=#{mobile_id}")
    void deleteMobile(Integer mobileId);
}
