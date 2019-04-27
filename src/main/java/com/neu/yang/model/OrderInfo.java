package com.neu.yang.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "order_info")
public class OrderInfo{

	@Id
	// id
	@Column(name = "id")
	private Integer id;

	// 订单号
	@Column(name = "order_number")
	private Integer orderNumber;

	// 商品项数量
	@Column(name = "item_count")
	private Integer itemCount;

	// 用户名
	@Column(name = "user_name")
	private Integer userName;

	// 是否需要奶箱（0：需要 1：不需要）
	@Column(name = "box")
	private Integer box;

	// 订单总金额
	@Column(name = "total_price")
	private Float totalPrice;

	// 订单状态
	@Column(name = "order_status")
	private String orderStatus;

	// 创建时间
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;

	// 更新时间
	@Column(name = "update_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;

	// 是否删除（0：正常 1：删除）
	@Column(name = "is_deleted")
	private Integer isDeleted;

	public OrderInfo() {
	}

	public OrderInfo(Integer id, Integer orderNumber, Integer itemCount, Integer userName, Integer box, Float totalPrice, String orderStatus, Date createDate, Date updateDate, Integer isDeleted) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.itemCount = itemCount;
		this.userName = userName;
		this.box = box;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDeleted = isDeleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	public Integer getUserName() {
		return userName;
	}

	public void setUserName(Integer userName) {
		this.userName = userName;
	}

	public Integer getBox() {
		return box;
	}

	public void setBox(Integer box) {
		this.box = box;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
}
