package com.neu.yang.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "goods")
public class Goods {

	@Id
	// id
	@Column(name = "id")
	private Integer id;

	// 商品名
	@Column(name = "goodsName")
	private String goodsName;

	// 价格
	@Column(name = "price")
	private Float price;

	// 数量
	@Column(name = "number")
	private Integer number;

	// 图片
	@Column(name = "pic")
	private String pic;

	// 父级分类
	@Column(name = "parentType")
	private String parenttype;

	// 品牌
	@Column(name = "brand")
	private String brand;

	// 种类（牛奶、酸奶、配方奶粉）
	@Column(name = "type")
	private String type;

	// 包装
	@Column(name = "packager")
	private String packager;

	// 容量
	@Column(name = "size")
	private Integer size;

	// 创建时间
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;

	// 修改时间
	@Column(name = "update_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;

	// 是否删除（0：正常 1：删除）
	@Column(name = "is_delete")
	private Object isDelete;

	public Goods() {
	}

	public Goods(Integer id, String goodsName, Float price, Integer number, String pic, String parenttype, String brand, String type, String packager, Integer size, Date createDate, Date updateDate, Object isDelete) {
		this.id = id;
		this.goodsName = goodsName;
		this.price = price;
		this.number = number;
		this.pic = pic;
		this.parenttype = parenttype;
		this.brand = brand;
		this.type = type;
		this.packager = packager;
		this.size = size;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDelete = isDelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getParenttype() {
		return parenttype;
	}

	public void setParenttype(String parenttype) {
		this.parenttype = parenttype;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPackager() {
		return packager;
	}

	public void setPackager(String packager) {
		this.packager = packager;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
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

	public Object getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Object isDelete) {
		this.isDelete = isDelete;
	}
}
