package com.pctc.test;

import com.pctc.dao.FilesDao;
import com.pctc.dao.FilesDaoImpl;
import com.pctc.model.Files;
import com.pctc.vo.FilesVo;


import java.sql.SQLException;
import java.util.List;

public class TestFiles {
    public static void main(String[] args){
        FilesDao filesDao = new FilesDaoImpl();


        //得到所有信息
        /*try {
            List<Files> list = filesDao.getAllFiles();
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        //根据id查找
        /*Files files = null;
        try {
            files = filesDao.getFilesId(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(files);*/

        //添加
//        FilesVo filesVo = new FilesVo(null,2021,"100001","关于谢淑芳同志的请假申请","钟玉婷","A101","总部","人事档案","保密","张欣怡");
//        int count = 0;
//        try {
//            count = filesDao.addFilesVo(filesVo);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(count);
//    }

       //修改
//        FilesVo filesVo = new FilesVo(3,2021,"100001","谢淑芳同志的请假申请","钟玉婷","A102","财务部","人事档案","普通","张欣怡");
//        int count = 0;
//        try {
//            count = filesDao.editFilesVo(filesVo);
//            System.out.println(count);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //根据id删除
        /*try {
            int count= filesDao.dropFiles(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        //根据档案类别id查找
       /* Files files = null;
        try {
            files = filesDao.getFilesType(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(files);*/

        //根据档案位置查找
        List<FilesVo> files = null;
        try {
            files = filesDao.getFilesPositionVo("A101");
            System.out.println(files);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //得到所有信息,,多表
       /* try {
            List<FilesVo> list = filesDao.getAllFilesVo();
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
        //根据id查找,,多表
//        FilesVo filesVo = null;
//        try {
//            filesVo = filesDao.getFilesVoId(2);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(filesVo);
//    }

    }  
}
