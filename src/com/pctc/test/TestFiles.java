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


        //�õ�������Ϣ
        /*try {
            List<Files> list = filesDao.getAllFiles();
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        //����id����
        /*Files files = null;
        try {
            files = filesDao.getFilesId(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(files);*/

        //���
//        FilesVo filesVo = new FilesVo(null,2021,"100001","����л�緼ͬ־���������","������","A101","�ܲ�","���µ���","����","������");
//        int count = 0;
//        try {
//            count = filesDao.addFilesVo(filesVo);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(count);
//    }

       //�޸�
//        FilesVo filesVo = new FilesVo(3,2021,"100001","л�緼ͬ־���������","������","A102","����","���µ���","��ͨ","������");
//        int count = 0;
//        try {
//            count = filesDao.editFilesVo(filesVo);
//            System.out.println(count);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //����idɾ��
        /*try {
            int count= filesDao.dropFiles(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        //���ݵ������id����
       /* Files files = null;
        try {
            files = filesDao.getFilesType(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(files);*/

        //���ݵ���λ�ò���
        List<FilesVo> files = null;
        try {
            files = filesDao.getFilesPositionVo("A101");
            System.out.println(files);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //�õ�������Ϣ,,���
       /* try {
            List<FilesVo> list = filesDao.getAllFilesVo();
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
        //����id����,,���
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
