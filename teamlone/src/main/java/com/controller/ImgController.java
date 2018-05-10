package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.bean.Images;
import com.bean.Imges_type;
import com.bean.Sys_Subject;
import com.bean.Teacher;
import com.github.pagehelper.PageInfo;
import com.service.ImagesService;
import com.service.Img_typeService;
import com.util.InfoNode;

@Controller
@RequestMapping("/admin")
public class ImgController {
	@Autowired
	private ImagesService imagesService;
	@Autowired
	private Img_typeService img_typeService;

	@RequestMapping("/imglist")
	public ModelAndView article(HttpServletRequest request,@RequestParam(name="page",defaultValue="0")int page){
		List<Imges_type> ty=img_typeService.getlistAll();
		Map map=inerMap(request);
		ModelAndView md=new ModelAndView();
		PageInfo<Images> th=imagesService.getlistAll(map, page);
		md.addObject("tc",th);
		md.addObject("ty", ty);
		md.setViewName("/admin/imgpsrsc/imglist");
		return md;
	}
	@RequestMapping("/getImg/{id}")
	public ModelAndView getImg(@PathVariable("id")int id){
		List<Imges_type> ty=img_typeService.getlistAll();
		ModelAndView md=new ModelAndView();
		Images im=imagesService.getById(id);
		System.out.println(im);
		md.addObject("im", im);
		md.addObject("ty", ty);
		md.setViewName("/admin/imgpsrsc/upimg");
		return md;
	}
	@RequestMapping(value="/inImg")
	public String  inImg(Images images,@RequestParam("type_id")int type_id,@RequestParam("filename")String filename){
		Imges_type imges_type=new Imges_type();
		imges_type.setType_id(type_id);
		System.out.println("tid:"+type_id);
		System.out.println(filename);
		images.setT_id(imges_type);
		images.setImage_url(filename);
		images.setPreview_url(filename);
		imagesService.inImg(images);
		return "redirect:/admin/imglist";
	}
	
	

	@RequestMapping(value="/delImg/{id}")
	public String delImg(@PathVariable("id")int id){
		imagesService.delImg(id);
		return "redirect:/admin/imglist";
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/img/insert")
	public ModelAndView  insert(){
		List<Imges_type> ty=img_typeService.getlistAll();
		ModelAndView md=new ModelAndView();
		md.addObject("ty", ty);
		md.setViewName("/admin/imgpsrsc/addImg");
		return md;
	}
	@RequestMapping(value="/upload/img",method=RequestMethod.POST)
	public String upload(
			Images images,@RequestParam("type_id")int type_id,@RequestParam("filename")String filename) throws Exception, IOException  {
		if (images.getColor()=="#000000") {
			images.setColor("");
		}
		System.out.println(filename);
		Imges_type imges_type=new Imges_type();
		imges_type.setType_id(type_id);
		images.setT_id(imges_type);
		images.setImage_url(filename);
		images.setPreview_url(filename);
		imagesService.upImg(images);
		return "redirect:/admin/imglist";
	} 
	@RequestMapping(value="/uploadfind/img")
	@ResponseBody
	public InfoNode uploadw(HttpServletRequest request,
			@RequestParam("imgfile")MultipartFile  file) throws Exception {
		InfoNode node=new InfoNode();
		if(!file.isEmpty()) {
			String path = request.getRealPath("/images/img");
			String filename =  file.getOriginalFilename();
			System.out.println("name:"+filename);
			File newfile = new File(path,filename);
			if (!newfile.exists()) { 
				newfile.createNewFile();
			}
			file.transferTo(newfile);
			System.out.println("123123");
			node.setCode("2");
			node.setUrl(filename);
			return node;
		} else {
			System.out.println("=====================");
			return node;
		}
	}
	private Map inerMap(HttpServletRequest request){
		 Map map=new HashMap<>();
		 String  id=request.getParameter("type_id");
		 String title=request.getParameter("title");
		 String desc=request.getParameter("desc");
			if (id==null) {
				id="-1";
			}
			request.setAttribute("title", title);
			request.setAttribute("type_id", id);
			request.setAttribute("desc", desc);
			System.out.println(desc);
			map.put("desc", desc);
			map.put("id", id);
			map.put("title", title);
			return map;
		}
}
