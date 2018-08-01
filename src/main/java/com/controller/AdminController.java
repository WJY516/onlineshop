/**
 * 
 */
package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.TbGoods;
import com.service.GoodsService;

/**
 * @author wujiayi
 * @date2018年7月31日 上午11:38:11
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	GoodsService goodsService;
	
	@RequestMapping("/goods")
	public String goodsqueryAll(Model m){
		List<TbGoods> goodsListAll = goodsService.queryGoodsAll();
		m.addAttribute("goodsListAll", goodsListAll);
		return "../admin/index.jsp";
	}
}
