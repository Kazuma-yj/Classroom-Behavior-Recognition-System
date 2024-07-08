package com.example.dangerbehaviordetect.Mapper;

import com.example.dangerbehaviordetect.entity.Camera;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CameraMapper {

    @Select("select * from Camera where cID = #{cID}")
    public Camera getByID(int cID);

    @Options(keyProperty = "cID", useGeneratedKeys = true)
    @Insert("insert into Camera(addr, content, ownerID, axis, ip, zone) VALUES (#{addr}, #{content}, #{ownerID}, #{axis}, #{ip}, #{zone})")
    public void addCamera(Camera camera);

    @Update("update Camera set zone=#{zone} where cID=#{cID}")
    public int addZone(String zone, int cID);

    @Select("select axis from Camera where cID=#{cID}")
    public String getAxis(int cID);
    
    @Update("update Camera set axis=#{axis} where cID=#{cID}")
    public void setAxis(int cID, String axis);

    @Select("select * from Camera where cID in (select cID from Member where memberID=#{uID})")
    public List<Camera> getAxises(int uID);

    @Select("select flush from Camera where cID = #{cID}")
    public String getImg(int cID);
}
