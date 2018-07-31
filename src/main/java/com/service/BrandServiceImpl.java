/**
 * 
 */
package com.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TbBrandMapper;
import com.domain.TbBrand;
import com.domain.TbBrandExample;
import com.domain.TbBrandExample.Criteria;

/**
 * @author wujiayi
 * @date2018年7月29日 下午10:54:14
 *
 */
@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	TbBrandMapper brand;
	
	/* (non-Javadoc)
	 * @see com.service.BrandService#queryBrandById(int)
	 */
	
	
	@Override
	public TbBrand queryBrandById(int brandId) {
		TbBrand tbbrand =  brand.selectByPrimaryKey(brandId);
		return tbbrand;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#queryBrandAll()
	 */
	@Override
	public List<String> queryBrandAll() {
		TbBrandExample ex = new TbBrandExample();
		ex.setDistinct(true);
		Criteria cr = ex.createCriteria();
		List<TbBrand> tbbrandlist = brand.selectByExample(ex);
		List<String> brandlist = new ArrayList<String>();
		for (TbBrand tbBrand : tbbrandlist) {
			brandlist.add(tbBrand.getBrandName());
		}
		//通过HashSet剔除重复元素
		HashSet h = new HashSet(brandlist);
		brandlist.clear();
		brandlist.addAll(h);
		return brandlist;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#queryType1All()
	 */
	@Override
	public List<String> queryType1All(String brandname) {
		TbBrandExample ex = new TbBrandExample();
		Criteria cr = ex.createCriteria();
		cr.andBrandNameEqualTo(brandname);
		List<TbBrand> tbbrandlist = brand.selectByExample(ex);
		List<String> type1list = new ArrayList<String>();
		for (TbBrand tbBrand : tbbrandlist) {
			type1list.add(tbBrand.getType1());
		}
		//通过HashSet剔除重复元素
		HashSet h = new HashSet(type1list);
		type1list.clear();
		type1list.addAll(h);
		return type1list;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#queryBrandByGoodsId(int)
	 */
	@Override
	public TbBrand queryBrandByGoodsId(int goodsid) {
		TbBrand brandByGoodsId = brand.selectByPrimaryKey(goodsid);		
		return brandByGoodsId;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#queryType2ByType1(java.lang.String)
	 */
	@Override
	public List<String> queryType2ByType1(String type1) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#queryType1ByType2(java.lang.String)
	 */
	@Override
	public String queryType1ByType2(String type2) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#insertBrands(com.domain.TbBrand)
	 */
	@Override
	public int insertBrands(TbBrand tbbrand) {
		return brand.insert(tbbrand);
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#updateGoods(com.domain.TbBrand)
	 */
	@Override
	public int updateGoods(TbBrand tbbrand) {
		return brand.updateByPrimaryKey(tbbrand);
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#deleteBrandsByBrandName(java.lang.String)
	 */
	@Override
	public int deleteBrandsByBrandName(String brandname) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#deleteBrandsByGoodsID(int)
	 */
	@Override
	public int deleteBrandsByGoodsID(int goodsId) {
		return brand.deleteByPrimaryKey(goodsId);
	}

}
