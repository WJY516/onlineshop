package com.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.dao.PictureMapper;
import com.domain.Picture;
import com.domain.PictureExample;
import com.domain.TbAddressExample;
import com.domain.TbAddressExample.Criteria;

@Service
public class PicServiceImpl implements PicService{
	@Autowired
	PictureMapper picturemapper;
	
	
	
	
	
	@Override
	public int add(String pic,int goodsid) throws IllegalStateException, IOException{
		PictureExample ex = new PictureExample();
		com.domain.PictureExample.Criteria cr = ex.createCriteria();
		String goodsid1=String.valueOf(goodsid);
		cr.andGoodsIdEqualTo(goodsid1);
		cr.andPictureEqualTo(pic);
		Picture picture = null;
		picture.setGoodsId(goodsid1);
		picture.setPicture(pic);
		int count = picturemapper.insert(picture);
		
		
		return count;
		
	}
	@Override
	public List<Picture> checkpic(int goodsid){
		
		PictureExample ex = new PictureExample();
		com.domain.PictureExample.Criteria cr = ex.createCriteria();
		String goodsid1=String.valueOf(goodsid);
		cr.andGoodsIdEqualTo(goodsid1);
		List<Picture> list=picturemapper.selectByExample(ex);
		
		return list;
		
	}
	@Override
	public int deletepic(int goodsid) {
		PictureExample ex = new PictureExample();
		com.domain.PictureExample.Criteria cr = ex.createCriteria();
		String goodsid1=String.valueOf(goodsid);
		cr.andGoodsIdEqualTo(goodsid1);
		int count=picturemapper.deleteByExample(ex);
		return count;
	}
}
