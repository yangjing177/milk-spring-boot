package com.neu.yang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sales {

	@Id
	// id
	@Column(name = "id")
	private Integer id;

	// 商品id
	@Column(name = "goods_id")
	private Integer goodsId;

	// 商品名
	@Column(name = "goods_name")
	private String goodsName;

	// 总销量
	@Column(name = "total")
	private Integer total;

	// 总销售额
	@Column(name = "total_price")
	private Float totalPrice;

	// 是否删除（0：正常 1：删除）
	@Column(name = "is_deleted")
	private Integer isDeleted;

	public Sales() {
	}

	public Sales(Integer id, Integer goodsId, String goodsName, Integer total, Float totalPrice, Integer isDeleted) {
		this.id = id;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.total = total;
		this.totalPrice = totalPrice;
		this.isDeleted = isDeleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
}
