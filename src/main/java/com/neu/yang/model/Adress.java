package com.neu.yang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Adress{

	@Id
	// id
	@Column(name = "id")
	private Integer id;

	// 用户名
	@Column(name = "user_name")
	private String userName;

	// 户籍
	@Column(name = "census")
	private String census;

	// 详细地址
	@Column(name = "adress")
	private String adress;

	// 手机号
	@Column(name = "mobile")
	private String mobile;

	// 邮编
	@Column(name = "post_code")
	private String postCode;

	// 是否为默认（0：默认 1：其他）
	@Column(name = "default_adress")
	private Object defaultAdress;

	// 是否删除（0：正常 1：删除）
	@Column(name = "is_deleted")
	private Object isDeleted;

	public Adress() {
	}

	public Adress(Integer id, String userName, String census, String adress, String mobile, String postCode, Object defaultAdress, Object isDeleted) {
		this.id = id;
		this.userName = userName;
		this.census = census;
		this.adress = adress;
		this.mobile = mobile;
		this.postCode = postCode;
		this.defaultAdress = defaultAdress;
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

	public String getCensus() {
		return census;
	}

	public void setCensus(String census) {
		this.census = census;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Object getDefaultAdress() {
		return defaultAdress;
	}

	public void setDefaultAdress(Object defaultAdress) {
		this.defaultAdress = defaultAdress;
	}

	public Object getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Object isDeleted) {
		this.isDeleted = isDeleted;
	}
}
