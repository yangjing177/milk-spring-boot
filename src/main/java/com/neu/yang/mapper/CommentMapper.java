package com.neu.yang.mapper;

import com.neu.yang.dto.CommentSelected;
import com.neu.yang.model.Goods;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import com.neu.yang.model.Comment;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CommentMapper extends Mapper<Comment> {
    List<Comment> findAll();
    List<Comment> getCommentByUser(@Param("userName") String userName, @Param("evaluate") Integer evaluate);
}