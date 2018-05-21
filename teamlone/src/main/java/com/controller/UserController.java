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
import javax.servlet.http.HttpSession;

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
//	锟斤拷页锟斤拷锟斤拷锟斤拷锟绞�
	@RequestMapping("/list")
	public ModelAndView getlistAll(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request) throws Exception{

		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		PageHelper.startPage(page,10); //锟斤拷页锟斤拷锟斤拷每页锟斤拷示锟斤拷
		map=initMap(request, map);
		List<Users> listAllUser = userService.getlistAll(map);
		PageInfo<Users> pageInfo=new PageInfo<>(listAllUser); //锟斤拷页锟斤拷锟斤拷锟捷达拷锟絧ageinfo
		mv.addObject("list", listAllUser);
		mv.addObject("page", pageInfo);  //锟斤拷页锟斤拷锟芥传锟斤拷
		mv.addObject("map",map);
//		List<EClass> listc=eclassServiceImpl.getlistAll();
//		mv.addObject("listc", listc);
		mv.setViewName("/common/student");
		return mv;	
	}
//   锟睫革拷锟斤拷锟斤拷
	@RequestMapping("/update")
	public String update(Users users) {
		userServiceImpl.update(users);
		return "redirect:/admin/users/list";

	}
//  锟斤拷锟斤拷  锟斤拷锟斤拷
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
//  模锟斤拷锟斤拷寻
	private Map initMap(HttpServletRequest request,Map map) throws Exception {
		String pname = request.getParameter("pname");
		String is_avalible = request.getParameter("is_avalible");
//		String class_id = request.getParameter("class_id");
		String start =request.getParameter("start");
		String end =request.getParameter("end");
		if (pname!=null&&pname.length()>0) {
			map.put("pname", pname);
			request.setAttribute("pname", pname);
		}
		if (is_avalible!=null&&is_avalible.length()>0) {
			map.put("is_avalible", Integer.valueOf(is_avalible));
			request.setAttribute("is_avalible", is_avalible);
		}
//		if (class_id!=null&&class_id.length()>0) {
//			map.put("class_id", Integer.valueOf(class_id));
//			request.setAttribute("class_id", class_id);
//		}
		if (start!=null&&start.length()>0) {
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
//	锟斤拷锟斤拷excil锟斤拷   写锟诫到锟斤拷锟捷匡拷
	 private String readExcel(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws Exception{  
	      //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷  
	        InputStream stream = file.getInputStream(); 
	        //锟斤拷取Excel锟侥硷拷锟斤拷锟斤拷  
	        Workbook  rwb = Workbook.getWorkbook(stream);  
	      //锟斤拷取锟侥硷拷锟斤拷指锟斤拷锟斤拷锟斤拷锟斤拷 默锟较的碉拷一锟斤拷  
	       Sheet sheet = rwb.getSheet(0);    
	       //锟斤拷锟斤拷(锟斤拷头锟斤拷目录锟斤拷锟斤拷要锟斤拷锟斤拷1锟斤拷始)  
	       List<Users> list  = new ArrayList<Users>();
	        for(int i=2; i<sheet.getRows(); i++){   
	             //锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷锟芥储每一锟叫碉拷值  
	           String[] str = new String[sheet.getColumns()];  
	             Cell cell = null;  
	            //锟斤拷锟斤拷  
	         	Users users = new Users();
	           for(int j=0; j<sheet.getColumns(); j++){  
	              //锟斤拷取锟斤拷i锟叫ｏ拷锟斤拷j锟叫碉拷值  
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
//   锟斤拷锟斤拷模锟斤拷
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
   
// 锟斤拷锟斤拷Excel
   @RequestMapping("/getAction")
   public void excel(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map map=new HashMap<>();
		map=initMap(request, map);
		List<Users> list= userService.getlistAll(map);
		////////////////////将ArrayList中的数据写入到本地excel中///////////////////////////          
		//第一步，创建一个workbook对应一个excel文件  
		HSSFWorkbook workbook = new HSSFWorkbook();  
		//第二步，在workbook中创建一个sheet对应excel中的sheet  
		HSSFSheet sheet = workbook.createSheet("用户表一");  
		//第三步，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制  
		HSSFRow row = sheet.createRow(0);  
		//第四步，创建单元格，设置表头  
		HSSFCell cell = row.createCell(0);  
		cell.setCellValue("手机号");  
		cell = row.createCell(1);  
		cell.setCellValue("邮箱号");  
		cell=row.createCell(2);  
		cell.setCellValue("用户名"); 
		cell=row.createCell(3);  
		cell.setCellValue("昵称"); 
		cell=row.createCell(4);  
		cell.setCellValue("性别");
		cell=row.createCell(5);  
		cell.setCellValue("年龄");
		cell=row.createCell(6);  
		cell.setCellValue("状态");
		//第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值  
		for (int i = 0; i <list.size(); i++)   
		{  
			HSSFRow row1 = sheet.createRow(i+1);  
			Users user=list.get(i);  
			//创建单元格设值  
			row1.createCell(0).setCellValue(user.getMobile());  
			row1.createCell(1).setCellValue(user.getEmail()); 
			row1.createCell(2).setCellValue(user.getUser_name()); 
			row1.createCell(3).setCellValue(user.getShow_name()); 
			if (user.getSex()==0) {
				row1.createCell(4).setCellValue("男"); 
			}else {
				row1.createCell(4).setCellValue("女"); 
			}
			row1.createCell(5).setCellValue(user.getAge()); 
			if (user.getIs_avalible()==1) {
				row1.createCell(6).setCellValue("正常"); 
			}else {
				row1.createCell(6).setCellValue("冻结"); 
			}
			
			
		}  
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=user.xls" );
		response.setContentType("Content-Type:application/vnd.ms-excel ");
		workbook.write(output);
		output.close();
	}

		    }
