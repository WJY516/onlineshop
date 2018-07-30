package com.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TbMemberMapper;
import com.domain.TbGoods;
import com.domain.TbMember;
import com.domain.TbMemberExample;
import com.domain.TbMemberExample.Criteria;

@Service
public class TbMemberServiceImpl implements TbMemberService {
	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	TbMemberMapper mapper;
	
	@Override
	public TbMember selectTbMemberByPK(String userName) {
		
		TbMember member = mapper.selectByPrimaryKey(userName);
		//log.debug("selectByExample list size----------------------"+list.size());
		
		return member;
	}

	@Override
	public boolean insertMember(TbMember member) {
		//此处可以插入用户信息校验
		member.setType(0);//默认注册为普通用户
		
		int num=0;
		TbMember count=null;
		count=mapper.selectByPrimaryKey(member.getUsername());
		if(count==null)
			num = mapper.insert(member);//SQLException Exception?????
		
		log.debug("insert member return a num----------------------"+num);
		if(num==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMemberByPK(String userName) {
		// TODO Auto-generated method stub
		int num=mapper.deleteByPrimaryKey(userName);
		return num==1;
	}

	@Override
	public boolean updateMemberByPK(TbMember member) {
		member.setType(null);//selective条件下type不更新
		int num=mapper.updateByPrimaryKeySelective(member);
		return 1==num;
	}

}
