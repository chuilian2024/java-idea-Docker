package org.example.javaideadocker.dao;

import org.apache.ibatis.annotations.Param;
import org.example.javaideadocker.pojo.Evebuilding;
import org.example.javaideadocker.pojo.Eveforce;
import org.example.javaideadocker.pojo.Evestudent;
import java.util.List;

public interface EvebuildingDao {

    //企业查询-字段映射
    List<Evebuilding> getListEvebuildingsplas();
    //势力查询-字段映射
    List<Eveforce> getListEveforce();
    //学生查询-字段映射
    List<Evestudent> getListEvestudent();
    //学生查询-字段映射-分页
    List<Evestudent> getListEvestudentplas(@Param("index") int index);
    //学生查询-分页-总条数
    int getListEvestudentplaspage();
    //学生查询-分页-条件-动态sql
    List<Evestudent> getListEvestudentplaswhere(@Param("index") int index,@Param("names") String names,@Param("number") String number,@Param("state2") String state2,@Param("levels") String levels);
    //学生查询-分页-条件-动态sql-总条数
    int getListEvestudentplaspagewhere(@Param("names") String names,@Param("number") String number,@Param("state2") String state2,@Param("levels") String levels);
    //学生-添加
    int setaddEvestudent(@Param("names") String names,@Param("number") String number,@Param("state1") String state1,@Param("state2") String state2);
    //学生-修改
    int setupdateEvestudent(@Param("index") int index,@Param("names") String names,@Param("number") String number,@Param("levels") String levels,@Param("state1") String state1,@Param("state2") String state2);
    //学生-删除
    int setdeleteEvestudent(@Param("index") int index);

}
