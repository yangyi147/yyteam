package com.mapper;
import java.util.List;
import java.util.Map;
import com.bean.Images;
import com.bean.Teacher;
public interface ImagesDao {
	  public List<Images> getListAll(Map map);
	  public  Images getById(int id);
	  public void delImg(int id);
	  public void inImg(Images images);
	  public void upImg(Images images);
}
