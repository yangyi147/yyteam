package com.util;

import java.util.List;

public class PageBean {

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		if(totalsize%pagesize==0){
			return totalsize/pagesize;
		}else{
			return (totalsize/pagesize)+1;
		}
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public List getDate() {
		return date;
	}
	public void setDate(List date) {
		this.date = date;
	}
	public int getTotalsize() {
		return totalsize;
	}
	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}
	private int currentPage;//��ǰҳ
	private int totalPage;//��ҳ��
	private int pagesize;//ÿҳ��ʾ������
	private List date;//ÿҳ��ʾ�ļ�¼
	private int totalsize;//���ݵ�������
}
