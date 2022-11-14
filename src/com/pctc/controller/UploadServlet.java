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
	
	
	
	//上传文件存储目录
	private static final String UPLOAD_DIRECTORY="upload";
	
	//上传配置
	//设置内存临界值-超过将产生临时文件并存储于临时目录中  3MB
	private static final int MEMORY_THRESHOLD=1024*1024*3; 
	
	//设置最大文件上传值  40MB
	private static final int MAX_FILE_SIZE=1024*1024*40;
	
	//设置最大请求值（包含文件和表单数据）    50MB
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
		
		response.setContentType("text/html;charset=UTF-8");//如果该方法在getWriter()方法被调用之前调用，那么响应的字符编码将仅从给出的内容类型 中设置。
		
		PrintWriter out=response.getWriter();
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		
		
		//检测是否为多媒体上传
		if(!ServletFileUpload.isMultipartContent(request)){
			 // 如果不是则停止
			PrintWriter writer=response.getWriter();
			
			writer.println("ERROR:表单必须包含 enctype=Multipart/form-data");
			writer.flush();
			return;
		}
		
		
		//配置上传参数
		DiskFileItemFactory factory=new DiskFileItemFactory();
		
		//设置内存临界值-超过将产生临时文件并存储于临时目录中  3MB
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		
		//上传文件存储目录            System.getProperty("java.io.tmpdir")----获取系统的临时目录
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		System.out.println("临时存储目录："+System.getProperty("java.io.tmpdir"));
		
		ServletFileUpload upload=new ServletFileUpload(factory);
		
		// 设置最大文件上传值,  最大请求值（包含文件和表单数据）
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		//中文处理
		upload.setHeaderEncoding("utf-8");
		
		
		
		//构造临时路径来存储上传的文件 
		// 这个路径相对当前应用的目录
		//File.separator 的作用相当于 '\',用 File.separator 保证了在任何系统下不会出错。
		
		String uploadPath=this.getServletContext().getRealPath("./")+File.separator + UPLOAD_DIRECTORY;
		System.out.println(this.getServletContext().getRealPath("./"));
		System.out.println(uploadPath);
		
		
		 //如果目录不存在则创建
		File uploadDir=new File(uploadPath);
		if(!uploadDir.exists()){
			uploadDir.mkdirs();
		}
		
		
		String fileName=null;
		try {
			//解析请求的内容提取文件数据
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);
			
			if(formItems!=null && formItems.size()>0){
				//迭代表单数据
				for(FileItem item:formItems){
					// 处理表单中的文件字段
					if(!item.isFormField()){
						fileName=new File(item.getName()).getName();
						
						//可以对fileName处理
						String filePath=uploadPath+ File.separator +fileName;
						File storeFile=new File(filePath);
						
						
						System.out.println(filePath);
						
						
						try {
							//保存文件到硬盘
							item.write(storeFile);
							
							
							map.put("fileName", filePath); //如果插入的 key 对应的 value 已经存在，则执行 value 替换操作，返回旧的 value 值，如果不存在则执行插入，返回 null。


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
				
				request.setAttribute("message", "文件上传成功");
				
				//添加上传记录
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
			request.setAttribute("message", "错误信息："+e.getMessage());
		}
		out.flush();
		out.close();
		
	}

}
