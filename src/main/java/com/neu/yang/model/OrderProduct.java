package com.neu.yang.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "order_product")
public class OrderProduct{

	@Id
	// id
	@Column(name = "id")
	private Integer id;

	// 订单编号
	@Column(name = "order_number")
	private String orderNumber;

	// 商品id
	@Column(name = "goods_id")
	private Integer goodsId;

	// 商品名
	@Column(name = "goods_name")
	private String goodsName;

	// 价格
	@Column(name = "price")
	private Float price;

	// 开始时间
	@Column(name = "first_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date firstDate;

	// 结束时间
	@Column(name = "last_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date lastDate;

	// 每次配送量
	@Column(name = "number")
	private Integer number;

	// 总数量
	@Column(name = "total")
	private Integer total;

	// 总价
	@Column(name = "total_price")
	private Float totalPrice;

	// 是否删除（0：正常 1：删除）
	@Column(name = "is_deleted")
	private Integer isDeleted;

	public OrderProduct() {
	}

	public OrderProduct(Integer id, String orderNumber, Integer goodsId, String goodsName, Float price, Date firstDate, Date lastDate, Integer number, Integer total, Float totalPrice, Integer isDeleted) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.price = price;
		this.firstDate = firstDate;
		this.lastDate = lastDate;
		this.number = number;
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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
