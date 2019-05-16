package com.neu.yang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	// id
	@Column(name = "id")
	private Integer id;

	// 用户名
	@Column(name = "user_name")
	private String userName;

	// 姓名
	@Column(name = "name")
	private String name;

	// 户籍
	@Column(name = "census")
	private String census;

	// 详细地址
	@Column(name = "address")
	private String address;

	// 手机号
	@Column(name = "mobile")
	private String mobile;

	// 邮编
	@Column(name = "post_code")
	private String postCode;

	// 是否为默认（0：默认 1：其他）
	@Column(name = "default_address")
	private Integer defaultAddress;

	// 是否删除（0：正常 1：删除）
	@Column(name = "is_deleted")
	private Integer isDeleted;

	public Address() {
	}

	public Address(Integer id, String userName, String name, String census, String address, String mobile, String postCode, Integer defaultAddress, Integer isDeleted) {
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.census = census;
		this.address = address;
		this.mobile = mobile;
		this.postCode = postCode;
		this.defaultAddress = defaultAddress;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCensus() {
		return census;
	}

	public void setCensus(String census) {
		this.census = census;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Integer getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(Integer defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
}
