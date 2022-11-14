package com.pctc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ�ļ���
	    String filename=request.getParameter("name");
	    
	    //��ֹ��ȡname������
	   // filename=new String(filename.getBytes("iso-8859-1"),"utf-8");
	    
	    //�ڿ���̨��ӡ�ļ���
	    System.out.println("�ļ�����"+filename);
	    
	     //�����ļ�MIME����  
	    response.setContentType(getServletContext().getMimeType(filename)); 
	    
	    //����Content-Disposition  
	   // response.setHeader("Content-Disposition", "attachment;filename="+filename);
	    response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename,"UTF-8"));
	    //��ȡҪ���ص��ļ�����·�����ҵ��ļ����ŵ�WebContent/downloadĿ¼��
	    ServletContext context=this.getServletContext();
	    String fullFileName=context.getRealPath("/upload/"+filename);
	    
	    //������Ϊ��Ŀ�ļ��������ָ�������
	    InputStream is=new FileInputStream(fullFileName);
	    ServletOutputStream os =response.getOutputStream();
	    
	    /*
	     * ���û�����
	     * is.read(b)���ļ�����ʱ����-1
	     */
	    int len=-1;
	    byte[] b=new byte[1024];
	    while((len=is.read(b))!=-1){
	        os.write(b,0,len);
	    }
	    //�ر���
		
	    is.close();
	    os.close();
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
