package com.neu.yang.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "car")
public class Car{

	@Id
	// id
	@Column(name = "id")
	private Integer id;

	// 用户id
	@Column(name = "user_name")
	private String userName;

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

	// 地址
	@Column(name = "adress")
	private String adress;

	// 每次配送量
	@Column(name = "number")
	private Integer number;

	// 总数量
	@Column(name = "total")
	private Integer total;

	// 总价
	@Column(name = "total_price")
	private Float totalPrice;

	// 创建时间
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;

	// 更新时间
	@Column(name = "update_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;

	// 是否删除（0：正常 1：删除）
	@Column(name = "is_deleted")
	private Object isDeleted;

	public Car() {
	}

	public Car(Integer id, String userName, Integer goodsId, String goodsName, Float price, Date firstDate, Date lastDate, String adress, Integer number, Integer total, Float totalPrice, Date createDate, Date updateDate, Object isDeleted) {
		this.id = id;
		this.userName = userName;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.price = price;
		this.firstDate = firstDate;
		this.lastDate = lastDate;
		this.adress = adress;
		this.number = number;
		this.total = total;
		this.totalPrice = totalPrice;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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

	public Object getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Object isDeleted) {
		this.isDeleted = isDeleted;
	}
}
