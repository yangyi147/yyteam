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
//	分页及表格显示
	@RequestMapping("/list")
	public ModelAndView getlistAll(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request) throws Exception{

		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		PageHelper.startPage(page,10); //分页设置每页显示数
		map=initMap(request, map);
		List<Users> listAllUser = userService.getlistAll(map);
		PageInfo<Users> pageInfo=new PageInfo<>(listAllUser); //分页把数据存放pageinfo
		mv.addObject("list", listAllUser);
		mv.addObject("page", pageInfo);  //分页界面传参
		List<EClass> listc=eclassServiceImpl.getlistAll();
		mv.addObject("listc", listc);
		mv.setViewName("/common/student");

		return mv;	
	}
//   修改密码
	@RequestMapping("/update")
	public String update(Users users) {
		userServiceImpl.update(users);
		return "redirect:/admin/users/list";

	}
//  冻结  正常
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
//  模糊查寻
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
//	导入excil表   写入到数据库
	 private String readExcel(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws Exception{  
	      //创建输入流  
	        InputStream stream = file.getInputStream(); 
	        //获取Excel文件对象  
	        Workbook  rwb = Workbook.getWorkbook(stream);  
	      //获取文件的指定工作表 默认的第一个  
	       Sheet sheet = rwb.getSheet(0);    
	       //行数(表头的目录不需要，从1开始)  
	       List<Users> list  = new ArrayList<Users>();
	        for(int i=2; i<sheet.getRows(); i++){   
	             //创建一个数组 用来存储每一列的值  
	           String[] str = new String[sheet.getColumns()];  
	             Cell cell = null;  
	            //列数  
	         	Users users = new Users();
	           for(int j=0; j<sheet.getColumns(); j++){  
	              //获取第i行，第j列的值  
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
//   下载模板
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
   
// 导出Excel
   @RequestMapping("/getAction")
public String getAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
    // 第一步，创建一个webbook，对应一个Excel文件    
    HSSFWorkbook wb = new HSSFWorkbook();    
    // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet    
    HSSFSheet sheet = wb.createSheet("学生表一");    
    // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short    
    HSSFRow row = sheet.createRow((int) 0);    
    // 第四步，创建单元格，并设置值表头 设置表头居中    
    HSSFCellStyle style = wb.createCellStyle();    
    style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式    

    HSSFCell cell = row.createCell(0);  
	cell.setCellValue("用户Id");  
	cell = row.createCell(1);  
	cell.setCellValue("手机号");  
	cell=row.createCell(2);  
	cell.setCellValue("邮箱号");  
	cell=row.createCell(3);  
	cell.setCellValue("用户名"); 
	cell=row.createCell(4);  
	cell.setCellValue("昵称"); 
	cell=row.createCell(5);  
//	cell.setCellValue("性别"); 
//	cell=row.createCell(6);  
//	cell.setCellValue("年龄"); 
//	cell=row.createCell(7);  
//	cell.setCellValue("状态"); 
    
    
    // 第五步，写入实体数据 实际应用中这些数据从数据库得到，    
    Map map = new HashMap<>();

	map=initMap(request, map);
	List<Users> list = userService.getlistAll(map);   
    for (int i = 0; i < list.size(); i++)    
    {    
        row = sheet.createRow((int) i + 1);    
        Users stu = (Users) list.get(i);    
        // 第四步，创建单元格，并设置值    
        row.createCell(0).setCellValue((double) stu.getUser_id());    
        row.createCell(1).setCellValue(stu.getMobile());    
        row.createCell(2).setCellValue(stu.getEmail());  
        row.createCell(3).setCellValue(stu.getUser_name()); 
        row.createCell(4).setCellValue(stu.getShow_name()); 
    }    
    // 第六步，将文件存到指定位置    

    OutputStream out = null;    
    try {        
        out = response.getOutputStream();    
        String fileName = "enroll.xls";// 文件名    
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
  System.out.println("成功"); 
	return "redirect:/admin/users/list";
}    

		    }
