package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Edu_Course_Note;

public interface Edu_Course_NoteDao {
	
	Edu_Course_Note getAllCourseNoteByID(Map map);
	
	void insertCourseNote(Edu_Course_Note courseNote);
	
	void updateCourseKpoint(Edu_Course_Note courseNote);

}
