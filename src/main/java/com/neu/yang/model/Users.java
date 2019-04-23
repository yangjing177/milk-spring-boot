package com.neu.yang.model;

import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users{

	@Id
	// 主键
	@Column(name = "id")
	private Integer id;

	// 用户名
	@Column(name = "username")
	private String username;

	// 密码
	@Column(name = "password")
	private String password;

	// 手机号
	@Column(name = "mobile")
	private String mobile;

	// 地址
	@Column(name = "adress")
	private String adress;

	// 会员等级
	@Column(name = "member")
	private String member;

	// 创建时间
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;

	// 修改时间
	@Column(name = "update_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;

	// 是否删除（0：未删除，1：已删除）
	@Column(name = "is_delete")
	private Integer isDelete;

	public Users() {
	}

	public Users(Integer id, String username, String password, String mobile, String adress, String member, Date createDate, Date updateDate, Integer isDelete) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.adress = adress;
		this.member = member;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
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

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}
