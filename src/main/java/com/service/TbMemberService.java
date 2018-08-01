package com.service;

import java.util.List;

import com.domain.TbMember;

public interface TbMemberService {

	public TbMember selectTbMemberByPK(String userName);//通过用户名(主键)查用户
	/**
	 * 用户注册  member.type 0表示普通用户 1表示管理员
	 * */
	public boolean insertMember(TbMember member);//注册用户
	public boolean deleteMemberByPK(String userName);//注销用户
	/**
	 * member.type 0表示普通用户 1表示管理员.
	 * 普通用户不可可修改 type项
	 * */
	public boolean updateMemberByPK(TbMember member);//修改用户信息
	public boolean updatePasswordByPK(String userName, String oldPassword,String newPassword);
	public List<TbMember> selectAll();
}
