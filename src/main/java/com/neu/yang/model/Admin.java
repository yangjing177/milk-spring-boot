package com.neu.yang.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "admin")
public class Admin{

	@Id
	// id
	@Column(name = "id")
	private String id;

	// 用户名
	@Column(name = "username")
	private String username;

	// 密码
	@Column(name = "password")
	private String password;

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

	public Admin() {
	}

	public Admin(String id, String username, String password, Date createDate, Date updateDate, Integer isDeleted) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDeleted = isDeleted;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
