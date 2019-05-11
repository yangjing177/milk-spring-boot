package com.neu.yang.service.impl;

import com.neu.yang.dto.CommentSelected;
import com.neu.yang.model.Goods;
import com.neu.yang.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neu.yang.model.Comment;
import com.neu.yang.mapper.CommentMapper;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    /**
     * 添加
     * @param comment
     */
    public void insert(Comment comment){
        commentMapper.insert(comment);
    }

    /**
     * 主键删除
     * @param id
     */
    public void delete(Integer id){
        commentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param comment
     */
    public void update(Comment comment){
        commentMapper.updateByPrimaryKey(comment);
    }


    @Override
    public List<Comment> getCommentByUser(CommentSelected commentSelected) {
        String userName=commentSelected.getUserName();
        Integer goodsId=commentSelected.getGoodsId();
        Integer evaluate=commentSelected.getEvaluate();
        return commentMapper.getCommentByUser(userName,goodsId,evaluate);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public Map<String, Object> findAll() {
        List<Comment> list=commentMapper.findAll();
        Map<String,Object> map=new HashMap<>();
        int totalRow=list.size();
        int code=20000;
        map.put("code",code);
        map.put("data",list);
        map.put("totalRow",totalRow);
        return map;
    }
    /**
     * 查询
     * @return
     */
    public Comment findById(Integer id){
        return commentMapper.selectByPrimaryKey(id);
    }
}
