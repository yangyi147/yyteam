package com.service;

import java.util.List;
import java.util.Map;

import org.apache.shiro.mgt.SubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Sys_Subject;
import com.mapper.Sys_SubjectDao;
@Service
public class Sys_SubjecterviceImpl implements Sys_Subjectervice {

	@Autowired
	Sys_SubjectDao SubjectDAO;
	/* (non-Javadoc)
	 * ��ѯ����רҵ����id
	 */
	@Override
	public List<Sys_Subject> getSubjectById(int id) {
		// TODO Auto-generated method stub
		return SubjectDAO.getSubjectById(id);
	}
	/* (zh)
	 * ��ѯ����id
	 */
	@Override
	public List<Sys_Subject> getAllSubjict() {
		// TODO Auto-generated method stub
		return SubjectDAO.getAllSubjict();
	}
	/* (zh)
	 *����רҵ�ĸ�id��ѯ����������
	 */
	@Override
	public List<Sys_Subject> getAllSubjictByparent_Id() {
		// TODO Auto-generated method stub
		return SubjectDAO.getAllSubjictByparent_Id();
	}
	/* (zh)
	 * ���רҵ
	 */
	@Override
	public void insertSubject(Sys_Subject subject) {
		// TODO Auto-generated method stub
		SubjectDAO.insertSubject(subject);
	}
	/* (non-Javadoc)
	 * @see com.service.Sys_Subjectervice#getAllSubjectByChild()
	 * ��ѯ����������
	 */
	@Override
	public List<Sys_Subject> getAllSubjectByChild(Map map) {
		 
		 return SubjectDAO.getAllSubjectByChild(map);
	}

}
