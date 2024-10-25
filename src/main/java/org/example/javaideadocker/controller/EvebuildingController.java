package org.example.javaideadocker.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.example.javaideadocker.dao.EvebuildingDao;
import org.example.javaideadocker.pojo.Evestudent;
import org.example.javaideadocker.pojo.page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller //标识一个Java类是一个控制器 来接收SpringMVC的请求
public class EvebuildingController {

    @Resource //注入依赖
    EvebuildingDao buildingDao;

    //企业查询
    @RequestMapping("/buildinglistplas")
    @ResponseBody
    public Object buildinglistplas(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return buildingDao.getListEvebuildingsplas();
    }

    //势力查询
    @RequestMapping("/forcelist")
    @ResponseBody
    public Object forcelist(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return buildingDao.getListEveforce();
    }

    //学生查询
    @RequestMapping("/studentlist")
    @ResponseBody
    public Object studentlist(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        return buildingDao.getListEvestudent();
    }

    //学生查询-分页-总页数
    @RequestMapping("/studentlistpage")
    @ResponseBody
    public Object studentlistpage(HttpServletResponse response,int index){
        response.addHeader("Access-Control-Allow-Origin","*");
        List<Evestudent> list=buildingDao.getListEvestudentplas((index-1)*10);
        int count=buildingDao.getListEvestudentplaspage();
        return new page(index,count,list);
    }

    //学生查询-分页-总页数-条件查询
    @RequestMapping("/studentlistpageplas")
    @ResponseBody
    public Object studentlistpageplas(HttpServletResponse response,int index,String names,String number,String state2,String levels){
        response.addHeader("Access-Control-Allow-Origin","*");
        List<Evestudent> list=buildingDao.getListEvestudentplaswhere((index-1)*10,names,number,state2,levels);
        int count=buildingDao.getListEvestudentplaspagewhere(names,number,state2,levels);
        return new page(index,count,list);
    }

    //学生-添加
    @RequestMapping("/insertstudent")
    @ResponseBody
    public Object insertstudent(HttpServletResponse response,String names,String number,String state1,String state2){
        response.addHeader("Access-Control-Allow-Origin","*");
        return buildingDao.setaddEvestudent(names,number,state1,state2);
    }

    //学生-修改
    @RequestMapping("/updatestudent")
    @ResponseBody
    public Object updatestudent(HttpServletResponse response,int index,String names,String number,String levels,String state1,String state2){
        if (state1.equals("帝国")){
           state1="1";
        }
        switch (state2) {
            case "艾玛帝国（Amarr Empire）" -> state2 = "1";
            case "加达里合众国（Caldari State）" -> state2 = "2";
            case "盖伦特联邦（Gallente Federation）" -> state2 = "3";
            case "米玛塔尔共和国（Minmatar Republic）" -> state2 = "4";
        }
        response.addHeader("Access-Control-Allow-Origin","*");
        return buildingDao.setupdateEvestudent(index,names,number,levels,state1,state2);
    }

    //学生-删除
    @RequestMapping("/deletestudent")
    @ResponseBody
    public Object deletestudent(HttpServletResponse response,int index){
        response.addHeader("Access-Control-Allow-Origin","*");
        return buildingDao.setdeleteEvestudent(index);
    }

}