/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domain.TbBrand;

/**
 * @author wujiayi
 * @date2018年7月29日 下午10:53:30
 *
 */
public interface BrandService {
	public TbBrand queryBrandById(int brandId);
	public List<String> queryBrandAll();
	public List<String> queryType1All(String type);
	public TbBrand queryBrandByGoodsId(int goodsid);
	public List<String> queryType2ByType1(String type1);
	public String queryType1ByType2(String type2);
	public int insertBrands(TbBrand tbbrand);
	public int updateGoods(TbBrand tbbrand);
	public int deleteBrandsByBrandName(String brandname);
	public int deleteBrandsByGoodsID(int goodsId);
}
