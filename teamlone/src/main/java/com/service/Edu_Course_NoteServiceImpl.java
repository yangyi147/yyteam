package com.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Edu_Course_Note;
import com.bean.Users;
import com.mapper.Edu_Course_NoteDao;
@Service
public class Edu_Course_NoteServiceImpl implements Edu_Course_NoteService {

	@Autowired
	Edu_Course_NoteDao courseNoteDao;
	@Autowired
	Edu_Course_Note courseNote;
	@Autowired
	Users user;
	@Override
	public Edu_Course_Note getAllCourseNoteByID(Map map) {
		// TODO Auto-generated method stub
		return courseNoteDao.getAllCourseNoteByID(map);
	}
	@Override
	public String insertCourseNote(HttpServletRequest  request) {
		user.setUser_id(Integer.parseInt(request.getParameter("uid")));
		courseNote.setUsers(user);
		courseNote.setKpoint_id(Integer.parseInt(request.getParameter("kpointId")));
		courseNote.setContent(request.getParameter("content"));
		courseNote.setCourse_id(Integer.parseInt(request.getParameter("courseId")));
		courseNote.setUpdate_time(new Date());
		try {
			courseNoteDao.insertCourseNote(courseNote);
		} catch (Exception e) {
			return "false";
		}
		return "success";
	}
	@Override
	public String updateCourseKpoint(HttpServletRequest request) {
		user.setUser_id(Integer.parseInt(request.getParameter("uid")));
		courseNote.setUsers(user);
		courseNote.setKpoint_id(Integer.parseInt(request.getParameter("kpointId")));
		courseNote.setContent(request.getParameter("content"));
		courseNote.setCourse_id(Integer.parseInt(request.getParameter("courseId")));
		courseNote.setUpdate_time(new Date());
		try {
			courseNoteDao.updateCourseKpoint(courseNote);
		} catch (Exception e) {
			return "false";
		}
		return "success";
	}
}
