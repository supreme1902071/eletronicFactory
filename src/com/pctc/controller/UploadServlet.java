package com.pctc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pctc.dao.UploadDao;
import com.pctc.dao.UploadDaoImpl;
import com.pctc.model.Upload;
import com.pctc.model.User;
import com.pctc.service.UploadService;
import com.pctc.service.UploadServiceImpl;
import com.pctc.util.DateUtil;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	//�ϴ��ļ��洢Ŀ¼
	private static final String UPLOAD_DIRECTORY="upload";
	
	//�ϴ�����
	//�����ڴ��ٽ�ֵ-������������ʱ�ļ����洢����ʱĿ¼��  3MB
	private static final int MEMORY_THRESHOLD=1024*1024*3; 
	
	//��������ļ��ϴ�ֵ  40MB
	private static final int MAX_FILE_SIZE=1024*1024*40;
	
	//�����������ֵ�������ļ��ͱ����ݣ�    50MB
	private static final int MAX_REQUEST_SIZE=1024*1024*50;
	
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");//����÷�����getWriter()����������֮ǰ���ã���ô��Ӧ���ַ����뽫���Ӹ������������� �����á�
		
		PrintWriter out=response.getWriter();
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		
		
		//����Ƿ�Ϊ��ý���ϴ�
		if(!ServletFileUpload.isMultipartContent(request)){
			 // ���������ֹͣ
			PrintWriter writer=response.getWriter();
			
			writer.println("ERROR:��������� enctype=Multipart/form-data");
			writer.flush();
			return;
		}
		
		
		//�����ϴ�����
		DiskFileItemFactory factory=new DiskFileItemFactory();
		
		//�����ڴ��ٽ�ֵ-������������ʱ�ļ����洢����ʱĿ¼��  3MB
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		
		//�ϴ��ļ��洢Ŀ¼            System.getProperty("java.io.tmpdir")----��ȡϵͳ����ʱĿ¼
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		System.out.println("��ʱ�洢Ŀ¼��"+System.getProperty("java.io.tmpdir"));
		
		ServletFileUpload upload=new ServletFileUpload(factory);
		
		// ��������ļ��ϴ�ֵ,  �������ֵ�������ļ��ͱ����ݣ�
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		//���Ĵ���
		upload.setHeaderEncoding("utf-8");
		
		
		
		//������ʱ·�����洢�ϴ����ļ� 
		// ���·����Ե�ǰӦ�õ�Ŀ¼
		//File.separator �������൱�� '\',�� File.separator ��֤�����κ�ϵͳ�²������
		
		String uploadPath=this.getServletContext().getRealPath("./")+File.separator + UPLOAD_DIRECTORY;
		System.out.println(this.getServletContext().getRealPath("./"));
		System.out.println(uploadPath);
		
		
		 //���Ŀ¼�������򴴽�
		File uploadDir=new File(uploadPath);
		if(!uploadDir.exists()){
			uploadDir.mkdirs();
		}
		
		
		String fileName=null;
		try {
			//���������������ȡ�ļ�����
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);
			
			if(formItems!=null && formItems.size()>0){
				//����������
				for(FileItem item:formItems){
					// ������е��ļ��ֶ�
					if(!item.isFormField()){
						fileName=new File(item.getName()).getName();
						
						//���Զ�fileName����
						String filePath=uploadPath+ File.separator +fileName;
						File storeFile=new File(filePath);
						
						
						System.out.println(filePath);
						
						
						try {
							//�����ļ���Ӳ��
							item.write(storeFile);
							
							
							map.put("fileName", filePath); //�������� key ��Ӧ�� value �Ѿ����ڣ���ִ�� value �滻���������ؾɵ� value ֵ�������������ִ�в��룬���� null��


						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else {
						
						String field=item.getFieldName();
						String value=item.getString();
						
						System.out.println(field);
						System.out.println(value);
						
						System.out.println(new String(value.getBytes("iso-8859-1"),"utf-8"));
					
					}
				}
				
				request.setAttribute("message", "�ļ��ϴ��ɹ�");
				
				//����ϴ���¼
				UploadDao uploadDao=new UploadDaoImpl();
				UploadService uploadService=new UploadServiceImpl(uploadDao);
				HttpSession session=request.getSession();
				
				User user=(User)session.getAttribute("user");
				String username=user.getUserName();
				
				String dateString=DateUtil.date2String(new Date());
				Date uploadtime=DateUtil.string2Date(dateString);
				
				Upload upload2=new Upload(0,fileName,username,uploadtime);
				try {
					int count=uploadService.addUpload(upload2);
					System.out.println(count);
					request.getRequestDispatcher("Fileupload.jsp").forward(request, response);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			request.setAttribute("message", "������Ϣ��"+e.getMessage());
		}
		out.flush();
		out.close();
		
	}

}
