package com.neu.yang.controller;

import com.neu.yang.dto.CommentSelected;
import com.neu.yang.dto.Selected;
import com.neu.yang.model.Car;
import com.neu.yang.model.Comment;
import com.neu.yang.model.Users;
import com.neu.yang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @ResponseBody
    @PostMapping("/getCommentByUser")
    public List<Comment> getCommentByUser(@RequestBody CommentSelected commentSelected) {
        List<Comment> list=commentService.getCommentByUser(commentSelected);
        return list;
    }

    @ResponseBody
    @GetMapping("/table")
    public Map<String, Object> getList() {
        return commentService.findAll();
    }

    @ResponseBody
    @PostMapping("update")
    public Map<String, Object> update(@RequestBody Comment comment) {
        commentService.update(comment);
        return commentService.findAll();
    }

    @ResponseBody
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Comment comment) {
        comment.setIsDeleted(1);
        commentService.update(comment);
        return commentService.findAll();
    }

    @ResponseBody
    @PostMapping("/insert")
    public void insert(@RequestBody Comment comment) {
        comment.setCreateDate(new Date());
        commentService.insert(comment);
    }
}
