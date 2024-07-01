package com.example.dangerbehaviordetect.Mapper;

import com.example.dangerbehaviordetect.entity.VCode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface VCodeMapper {

    @Insert("insert into ValidateCode(mail, code,cTime) VALUES(#{mail}, #{code},#{cTime})")
    public void insert(String mail, String code, LocalDateTime cTime);

    @Select("select * from ValidateCode where mail = #{mail} and code = #{code}")
    public List<VCode> getCode(String mail, String code);
}
