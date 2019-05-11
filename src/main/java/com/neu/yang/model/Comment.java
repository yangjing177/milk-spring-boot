package com.neu.yang.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment{

	@Id
	// id
	@Column(name = "id")
	private Integer id;

	// 用户id
	@Column(name = "user_id")
	private Integer userId;

	// 用户名
	@Column(name = "user_name")
	private String userName;

	// 评论
	@Column(name = "comment")
	private String comment;

	// 评价
	@Column(name = "evaluate")
	private Integer evaluate;

	// 评论审核状态（0：通过，1未通过）
	@Column(name = "comment_status")
	private String commentStatus;

	// 创建时间
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createDate;

	// 是否删除（0：未删除，1：已删除）
	@Column(name = "is_deleted")
	private Integer isDeleted;

	public Comment() {
	}

	public Comment(Integer id, Integer userId, String userName, String comment, Integer evaluate, String commentStatus, Date createDate, Integer isDeleted) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.comment = comment;
		this.evaluate = evaluate;
		this.commentStatus = commentStatus;
		this.createDate = createDate;
		this.isDeleted = isDeleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(Integer evaluate) {
		this.evaluate = evaluate;
	}

	public String getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
}
