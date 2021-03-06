package com.domain;

import java.util.Date;

public class TbComment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.id
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.username
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.order_id
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.goods_id
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    private String goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.comment
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    private String comment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.comment_time
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    private Date commentTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_comment.comment_type
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    private Integer commentType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.id
     *
     * @return the value of tb_comment.id
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.id
     *
     * @param id the value for tb_comment.id
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.username
     *
     * @return the value of tb_comment.username
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.username
     *
     * @param username the value for tb_comment.username
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.order_id
     *
     * @return the value of tb_comment.order_id
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.order_id
     *
     * @param orderId the value for tb_comment.order_id
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.goods_id
     *
     * @return the value of tb_comment.goods_id
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.goods_id
     *
     * @param goodsId the value for tb_comment.goods_id
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.comment
     *
     * @return the value of tb_comment.comment
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.comment
     *
     * @param comment the value for tb_comment.comment
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.comment_time
     *
     * @return the value of tb_comment.comment_time
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.comment_time
     *
     * @param commentTime the value for tb_comment.comment_time
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_comment.comment_type
     *
     * @return the value of tb_comment.comment_type
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public Integer getCommentType() {
        return commentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_comment.comment_type
     *
     * @param commentType the value for tb_comment.comment_type
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }
}