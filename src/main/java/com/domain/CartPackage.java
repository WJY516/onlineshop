package com.domain;

public class CartPackage {
	private TbGoods goods;
	private TbBrand brand;
	
	public CartPackage(){
		super();
	}
	public CartPackage(TbGoods goods, TbBrand brand){
		super();
		this.goods = goods;
		this.brand = brand;
	}
	public TbGoods getGoods() {
		return goods;
	}
	public void setGoods(TbGoods goods) {
		this.goods = goods;
	}
	public TbBrand getBrand() {
		return brand;
	}
	public void setBrand(TbBrand brand) {
		this.brand = brand;
	}
}