package com.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bean.Edu_Course_Note;

public interface Edu_Course_NoteService {
	
	Edu_Course_Note getAllCourseNoteByID(Map map);
	
	int  insertCourseNote(HttpServletRequest  request);
	
	int updateCourseKpoint(HttpServletRequest request);

}
