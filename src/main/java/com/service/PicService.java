package com.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.domain.Picture;

public interface PicService {
		public List<Picture> checkpic(int goodsid);
		public int deletepic(int goodsid);
		public int add(String pic,int goodsid) throws IllegalStateException, IOException;
}
