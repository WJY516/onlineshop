package com.domain;

public class TbSubscribeKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_subscribe.username
     *
     * @mbg.generated Sun Jul 29 17:10:38 CST 2018
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_subscribe.goods_id
     *
     * @mbg.generated Sun Jul 29 17:10:38 CST 2018
     */
    private Integer goodsId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_subscribe.username
     *
     * @return the value of tb_subscribe.username
     *
     * @mbg.generated Sun Jul 29 17:10:38 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_subscribe.username
     *
     * @param username the value for tb_subscribe.username
     *
     * @mbg.generated Sun Jul 29 17:10:38 CST 2018
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_subscribe.goods_id
     *
     * @return the value of tb_subscribe.goods_id
     *
     * @mbg.generated Sun Jul 29 17:10:38 CST 2018
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_subscribe.goods_id
     *
     * @param goodsId the value for tb_subscribe.goods_id
     *
     * @mbg.generated Sun Jul 29 17:10:38 CST 2018
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}