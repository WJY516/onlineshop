/**
 * 
 */
package com.service;

import java.util.List;

import com.domain.TbBrand;

/**
 * @author wujiayi
 * @date2018年7月29日 下午10:54:14
 *
 */
public class BrandServiceImpl implements BrandService{

	/* (non-Javadoc)
	 * @see com.service.BrandService#queryBrandById(int)
	 */
	@Override
	public TbBrand queryBrandById(int brandId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#queryBrandAll()
	 */
	@Override
	public List<String> queryBrandAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#queryType1All()
	 */
	@Override
	public List<String> queryType1All() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#queryBrandByGoodsId(int)
	 */
	@Override
	public TbBrand queryBrandByGoodsId(int goodsid) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#updateGoods(com.domain.TbBrand)
	 */
	@Override
	public int updateGoods(TbBrand tbbrand) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.service.BrandService#deleteBrandsByBrandName(java.lang.String)
	 */
	@Override
	public int deleteBrandsByBrandName(String brandname) {
		// TODO Auto-generated method stub
		return 0;
	}

}
