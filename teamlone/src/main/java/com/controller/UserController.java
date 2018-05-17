package com.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EClass;
import com.bean.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.EclassServiceImpl;
import com.service.UserService;
import com.service.UserServiceImpl;

import com.util.PageBean;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Controller
@RequestMapping("/admin/users")
public class UserController {
	@Autowired
       UserServiceImpl userServiceImpl;
	@Autowired
     EclassServiceImpl eclassServiceImpl;
	@Autowired
	UserService userService;
//	��ҳ�������ʾ
	@RequestMapping("/list")
	public ModelAndView getlistAll(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request) throws Exception{

		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		PageHelper.startPage(page,10); //��ҳ����ÿҳ��ʾ��
		map=initMap(request, map);
		List<Users> listAllUser = userService.getlistAll(map);
		PageInfo<Users> pageInfo=new PageInfo<>(listAllUser); //��ҳ�����ݴ��pageinfo
		mv.addObject("list", listAllUser);
		mv.addObject("page", pageInfo);  //��ҳ���洫��
		List<EClass> listc=eclassServiceImpl.getlistAll();
		mv.addObject("listc", listc);
		mv.setViewName("/common/student");

		return mv;	
	}
//   �޸�����
	@RequestMapping("/update")
	public String update(Users users) {
		userServiceImpl.update(users);
		return "redirect:/admin/users/list";

	}
//  ����  ����
	@RequestMapping("/updateid/{id}/{is_avalible}")
	public String updateid(@PathVariable("id")int id,@PathVariable("is_avalible")int is_avalible) {
		Users users = new Users();
		users.setUser_id(id);
		if (is_avalible==0) {
			is_avalible=1;
			users.setIs_avalible(is_avalible);
		}else if (is_avalible==1) {
			is_avalible=0;
			users.setIs_avalible(is_avalible);
		}
		userServiceImpl.updateid(users);
		return "redirect:/admin/users/list";
	}
//  ģ����Ѱ
	private Map initMap(HttpServletRequest request,Map map) throws Exception {
		String pname = request.getParameter("pname");
		String is_avalible = request.getParameter("is_avalible");
		String class_id = request.getParameter("class_id");
		String start =request.getParameter("start");
		String end =request.getParameter("end");
		if (pname!=null&&pname.length()>0) {
			map.put("pname", pname);
			request.setAttribute("pname", pname);
		}
		if (is_avalible!=null&&is_avalible.length()>0) {
			map.put("is_avalible", Integer.valueOf(is_avalible));
			request.setAttribute("is_avalible", is_avalible);
		}if (class_id!=null&&class_id.length()>0) {
			map.put("class_id", Integer.valueOf(class_id));
			request.setAttribute("class_id", class_id);
		}if (start!=null&&start.length()>0) {
			map.put("start", start);
			request.setAttribute("start", start);
		}
		if (end!=null&&end.length()>0) {
			map.put("end", end);
			request.setAttribute("end", end);
		}
		return map;
	}
	  
	@RequestMapping("/toexcel")
    public String toExcel(){
    	return "/common/parseExcel";
    }
   
   @RequestMapping("/parseExcel")
//	����excil��   д�뵽���ݿ�
	 private String readExcel(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws Exception{  
	      //����������  
	        InputStream stream = file.getInputStream(); 
	        //��ȡExcel�ļ�����  
	        Workbook  rwb = Workbook.getWorkbook(stream);  
	      //��ȡ�ļ���ָ�������� Ĭ�ϵĵ�һ��  
	       Sheet sheet = rwb.getSheet(0);    
	       //����(��ͷ��Ŀ¼����Ҫ����1��ʼ)  
	       List<Users> list  = new ArrayList<Users>();
	        for(int i=2; i<sheet.getRows(); i++){   
	             //����һ������ �����洢ÿһ�е�ֵ  
	           String[] str = new String[sheet.getColumns()];  
	             Cell cell = null;  
	            //����  
	         	Users users = new Users();
	           for(int j=0; j<sheet.getColumns(); j++){  
	              //��ȡ��i�У���j�е�ֵ  
	              cell = sheet.getCell(j,i);      
	              str[j] = cell.getContents(); 
	              if (j==0) {
	            	  if(str[j]==null||str[j].equals("")){
	            		  return "redirect:/admin/users/list";
	            	  }
		          		users.setMobile(str[j]);
						} if (j==1) {
					
							users.setEmail(str[j]);
						}
						
		              if (j==2) {
		            	
							users.setPassword(str[j]);
						}
		              if (j==3) {
		            	
							users.setUser_name(str[j]);
						}
		              if (j==4) {
		            
		            	  users.setShow_name(str[j]);
						
					}
		              if (j==5) {
		            
		            	  users.setSex(Integer.valueOf(str[j]));
						
					}
		              if (j==6) {
  	
		            	  users.setAge(Integer.valueOf(str[j]));
					}  if (j==7) {
						EClass eClass=eclassServiceImpl.getById(Integer.valueOf(str[j]));
		            	  users.setId(eClass);
					}  if (j==8) {
						String date = str[j];
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		                users.setCreate_time(sdf.parse(date));
		                users.setLast_system_time(sdf.parse(date));
					}
		             
	            }  
//             list.add(users);
	           userServiceImpl.insave(users);
	         }  
	       	return "redirect:/admin/users/list";
  	
	     }
//   ����ģ��
   @RequestMapping("/down")
	public String downAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		java.io.OutputStream o = response.getOutputStream();
		byte b[] = new byte[500];
		java.io.File fileLoad = new java.io.File(request.getRealPath("/Excel/user.xls"));
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("content-disposition",
				"attachment; filename=text.xls");
		long fileLength = fileLoad.length();
		String length1 = String.valueOf(fileLength);
		response.setHeader("Content_Length", length1);
		java.io.FileInputStream in = new java.io.FileInputStream(fileLoad);
		int n;
		while ((n = in.read(b)) != -1) {
			o.write(b, 0, n);
		}
		in.close();
		o.close();

		return null;
	}
   
// ����Excel
   @RequestMapping("/getAction")
public String getAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
    // ��һ��������һ��webbook����Ӧһ��Excel�ļ�    
    HSSFWorkbook wb = new HSSFWorkbook();    
    // �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet    
    HSSFSheet sheet = wb.createSheet("ѧ����һ");    
    // ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short    
    HSSFRow row = sheet.createRow((int) 0);    
    // ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����    
    HSSFCellStyle style = wb.createCellStyle();    
    style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ    

    HSSFCell cell = row.createCell(0);  
	cell.setCellValue("�û�Id");  
	cell = row.createCell(1);  
	cell.setCellValue("�ֻ���");  
	cell=row.createCell(2);  
	cell.setCellValue("�����");  
	cell=row.createCell(3);  
	cell.setCellValue("�û���"); 
	cell=row.createCell(4);  
	cell.setCellValue("�ǳ�"); 
	cell=row.createCell(5);  
//	cell.setCellValue("�Ա�"); 
//	cell=row.createCell(6);  
//	cell.setCellValue("����"); 
//	cell=row.createCell(7);  
//	cell.setCellValue("״̬"); 
    
    
    // ���岽��д��ʵ������ ʵ��Ӧ������Щ���ݴ����ݿ�õ���    
    Map map = new HashMap<>();

	map=initMap(request, map);
	List<Users> list = userService.getlistAll(map);   
    for (int i = 0; i < list.size(); i++)    
    {    
        row = sheet.createRow((int) i + 1);    
        Users stu = (Users) list.get(i);    
        // ���Ĳ���������Ԫ�񣬲�����ֵ    
        row.createCell(0).setCellValue((double) stu.getUser_id());    
        row.createCell(1).setCellValue(stu.getMobile());    
        row.createCell(2).setCellValue(stu.getEmail());  
        row.createCell(3).setCellValue(stu.getUser_name()); 
        row.createCell(4).setCellValue(stu.getShow_name()); 
    }    
    // �����������ļ��浽ָ��λ��    

    OutputStream out = null;    
    try {        
        out = response.getOutputStream();    
        String fileName = "enroll.xls";// �ļ���    
        response.setContentType("application/x-msdownload");    
        response.setHeader("Content-Disposition", "attachment; filename="    
                                                + URLEncoder.encode(fileName, "UTF-8"));    
        wb.write(out);    
    } catch (Exception e) {    
        e.printStackTrace();    
    } finally {      
        try {       
            out.close();      
        } catch (IOException e) {      
            e.printStackTrace();    
        }      
    }
  System.out.println("�ɹ�"); 
	return "redirect:/admin/users/list";
}    

		    }
