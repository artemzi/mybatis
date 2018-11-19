package ru.innopolis.stc12.hibernate.dao;

import org.apache.ibatis.annotations.*;
import ru.innopolis.stc12.hibernate.dao.dto.Owner;

import java.util.List;

public interface OwnerMapper {
    @Select("Select * from owner where owner_id=#{ownerId}")
    Owner getOwner(@Param("ownerId") Integer ownerId);

    @Insert("Insert into owner(owner_id, name, age) " +
            "values (#{owner_id}, #{name}, #{age})")
    void insertOwner(Owner owner);

    @Select("Select * from owner")
    List<Owner> getAllOwners();

    @Update("Update owner " +
            "set name = #{name}, " +
            "age = #{age}, " +
            "where owner_id=#{owner_id} ")
    void updateOwner(Owner mobile);

    @Delete("delete from owner where owner_id=#{owner_id}")
    void deleteOwner(Integer ownerId);
}
