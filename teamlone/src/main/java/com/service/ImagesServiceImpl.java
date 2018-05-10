package com.service;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.bean.Images;
import com.bean.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.ImagesDao;
@Service
public class ImagesServiceImpl implements ImagesService {
	@Autowired
	private ImagesDao imagesDao;
	@Value("${pagesize}")
	private int pagesize;
	@Override
	public PageInfo<Images> getlistAll(Map map,int page) {
		PageHelper.startPage(page,pagesize);
		List<Images> tc=imagesDao.getListAll(map);
		PageInfo<Images> info=new PageInfo<Images>(tc);
		return info;
	}
	@Override
	public Images getById(int id) {
		// TODO Auto-generated method stub
		return imagesDao.getById(id);
	}

	@Override
	public void delImg(int id) {
        imagesDao.delImg(id);		
	}

	@Override
	public void inImg(Images images) {
		// TODO Auto-generated method stub
		 imagesDao.inImg(images);
	}

	@Override
	public void upImg(Images images) {
imagesDao.upImg(images);		
	}


}
