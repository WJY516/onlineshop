package com.dao;

import com.domain.Picture;
import com.domain.PictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    long countByExample(PictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int deleteByExample(PictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int insert(Picture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int insertSelective(Picture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    List<Picture> selectByExample(PictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    Picture selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int updateByExampleSelective(@Param("record") Picture record, @Param("example") PictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int updateByExample(@Param("record") Picture record, @Param("example") PictureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int updateByPrimaryKeySelective(Picture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Thu Aug 02 11:38:29 CST 2018
     */
    int updateByPrimaryKey(Picture record);
}