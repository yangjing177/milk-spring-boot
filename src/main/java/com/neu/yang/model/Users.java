package com.neu.yang.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

	// 真实姓名
	@Column(name = "name")
	private String name;

	// 性别
	@Column(name = "sex")
	private String sex;

	// 身份证号
	@Column(name = "id_number")
	private String idNumber;

	// 邮箱
	@Column(name = "email")
	private String email;

	// 创建时间
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;

	// 修改时间
	@Column(name = "update_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateDate;

	// 是否删除（0：未删除，1：已删除）
	@Column(name = "is_deleted")
	private Integer isDeleted;

	public Users() {
	}

	public Users(Integer id, String username, String password, String mobile, String name, String sex, String idNumber, String email, Date createDate, Date updateDate, Integer isDeleted) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.name = name;
		this.sex = sex;
		this.idNumber = idNumber;
		this.email = email;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
