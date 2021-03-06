package com.dao;

import com.domain.TbAddress;
import com.domain.TbAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    long countByExample(TbAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int deleteByExample(TbAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int deleteByPrimaryKey(Integer addressId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int insert(TbAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int insertSelective(TbAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    List<TbAddress> selectByExample(TbAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    TbAddress selectByPrimaryKey(Integer addressId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int updateByExampleSelective(@Param("record") TbAddress record, @Param("example") TbAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int updateByExample(@Param("record") TbAddress record, @Param("example") TbAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int updateByPrimaryKeySelective(TbAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_address
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int updateByPrimaryKey(TbAddress record);
}