package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.domain.Picture;
import com.service.PicService;




@Controller
@RequestMapping("/uppic") 
public class Uppic {
	@Autowired
	PicService picservice;
	
	
	String path_or="C:\\Users\\50134\\Workspaces\\MyEclipse 2015\\project\\onlineshop\\src\\main\\webapp\\images\\"; //根据自己的电脑路径设置
	@RequestMapping("/pic") 
	public String uploadPic(MultipartFile pic,int goodsid) throws IllegalStateException, IOException{
		String rndFileName = UUID.randomUUID().toString();
		String originalFilename = pic.getOriginalFilename();
		String ext =originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());
		String path = path_or+rndFileName+ext;
		File dest = new File(path);
		pic.transferTo(dest);
		System.out.println("图片于"+path);
				//System.out.println(pic.getOriginalFilename());
		picservice.add(path,goodsid);
	}
	
	
	@RequestMapping("/checkpic") 
	public String checkPic(int goodsid,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		List<Picture> list=picservice.checkpic(goodsid);
		request.setAttribute("piclist",list);
		try {
			request.getRequestDispatcher("").forward(request, response);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@RequestMapping("/deletepic") 
	public String deletePic(int goodsid) throws IllegalStateException, IOException{
		int i=picservice.deletepic(goodsid);
		if(i==0){
			
		}else {
			
		}
		return "";
	}
}