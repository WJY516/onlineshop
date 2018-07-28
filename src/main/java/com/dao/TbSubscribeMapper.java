package com.dao;

import com.domain.TbSubscribeExample;
import com.domain.TbSubscribeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSubscribeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subscribe
     *
     * @mbg.generated Sat Jul 28 15:25:22 CST 2018
     */
    long countByExample(TbSubscribeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subscribe
     *
     * @mbg.generated Sat Jul 28 15:25:22 CST 2018
     */
    int deleteByExample(TbSubscribeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subscribe
     *
     * @mbg.generated Sat Jul 28 15:25:22 CST 2018
     */
    int deleteByPrimaryKey(TbSubscribeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subscribe
     *
     * @mbg.generated Sat Jul 28 15:25:22 CST 2018
     */
    int insert(TbSubscribeKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subscribe
     *
     * @mbg.generated Sat Jul 28 15:25:22 CST 2018
     */
    int insertSelective(TbSubscribeKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subscribe
     *
     * @mbg.generated Sat Jul 28 15:25:22 CST 2018
     */
    List<TbSubscribeKey> selectByExample(TbSubscribeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subscribe
     *
     * @mbg.generated Sat Jul 28 15:25:22 CST 2018
     */
    int updateByExampleSelective(@Param("record") TbSubscribeKey record, @Param("example") TbSubscribeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subscribe
     *
     * @mbg.generated Sat Jul 28 15:25:22 CST 2018
     */
    int updateByExample(@Param("record") TbSubscribeKey record, @Param("example") TbSubscribeExample example);
}