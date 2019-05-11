package com.neu.yang.service;

import com.neu.yang.dto.CommentSelected;
import com.neu.yang.model.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    Map<String, Object> findAll();
    void update(Comment comment);
    List<Comment> getCommentByUser(CommentSelected commentSelected);
}
