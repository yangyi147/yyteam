package com.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Users;
import com.service.UserServiceImpl;
import com.util.MD5Utils;
import com.util.Result;
@Controller
public class UserPersonalController {
	@Autowired
	UserServiceImpl userServiceImpl;

	@RequestMapping("/uc/initUpdateUser/0")
	public String initUpdateUser(Model model) {

		model.addAttribute("index", 0);
		return "/web/ucenter/user-info";	
	}
	@RequestMapping("/uc/initUpdateUser/1")
	public String initUpdateUser1(Model model) {
		model.addAttribute("index", 1);
		return "/web/ucenter/user-info";	
	}
	@RequestMapping("/uc/initUpdateUser/2")
	public String initUpdateUser2(Model model) {
		model.addAttribute("index", 2);
		return "/web/ucenter/user-info";	
	}

	@RequestMapping("/uc/updatePwd")
	@ResponseBody
	public Result updatePwd(HttpServletRequest request,HttpSession session) {
		Result result = new Result();
//		拿到数据库的密码
		Users users1=(Users) session.getAttribute("login_success");
		String password=users1.getPassword();	
//		新密码
		String newPassword =request.getParameter("newPassword");
//		用户iD
		String userId =request.getParameter("userId");
//		旧密码
		String nowPassword =request.getParameter("nowPassword");
		nowPassword = MD5Utils.md5(nowPassword);
//		再次输入密码
	 	String confirmPwd = request.getParameter("confirmPwd");
//	 	与以前的密码判断
          if (password.equals(nowPassword)) {
//       判断两次密码是否一致
			if (newPassword.equals(confirmPwd)) {
				  Users users = new Users();
				   users.setPassword(MD5Utils.md5(confirmPwd));
				   users.setUser_id(Integer.valueOf(userId));
				   userServiceImpl.update(users);
				   return new Result(true, "yes！", null);
			}else {
				return new Result(false, "no！", null);
			}
		}else {
			return new Result(false, "nos！", null);
		}
		

	}
	
	@RequestMapping("/uc/updateUser")
	 public Result updateUser(Users users ,HttpSession session) {
		Users loginUser = (Users) session.getAttribute("login_success");
		loginUser.setUser_id(loginUser.getUser_id());
        userServiceImpl.updateAll(users);
		Users byId = userServiceImpl.getById(loginUser.getUser_id());
		session.setAttribute("login_success", byId);
		return new Result(true, "yes！", null);
		
	}
	/**
	 * @param file
	 * @param request
	 * @param session
	 * 修改头像
	 * @return
	 */
	@RequestMapping("/uc/updateImg")
	@ResponseBody
	public Result updateImg(@RequestParam(value="file",required = false)MultipartFile file,HttpServletRequest request,HttpSession session){
		System.out.println("123");
		Users loginUser = (Users) session.getAttribute("login_success");
		Result result=new Result();
		if(file != null) {
            //上传文件路径
            String path = request.getRealPath("/images/");
            //上传文件名
            String filename = file.getOriginalFilename();
            System.out.println("666"+filename);
            if(filename==null||"".equals(filename)){
            	result.setSuccess(false);
            	result.setMessage("2");
            }
            String a[]=filename.split("\\.");
            if(!a[1].equalsIgnoreCase("BMP")||!a[1].equalsIgnoreCase("JPEG")||!a[1].equalsIgnoreCase("PSD")||!a[1].equalsIgnoreCase("PCX")
            		||!a[1].equalsIgnoreCase("PNG")||!a[1].equalsIgnoreCase("DXF")||!a[1].equalsIgnoreCase("CDR")
            		||!a[1].equalsIgnoreCase("ICO")
            		){
            	result.setSuccess(false);
            	result.setMessage("1");
            }
            File filepath = new File(path,filename);         
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
				file.transferTo(new File(path + File.separator + filename));
			} catch (Exception e) {
				e.printStackTrace();
			} 
            loginUser.setPic_img("/images/"+filename);
            userServiceImpl.updateAll(loginUser);
            result.setSuccess(true);
		}
		return result;
	}

}
