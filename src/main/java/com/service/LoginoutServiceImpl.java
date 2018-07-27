/**
 * 
 */
package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dao.*;
import com.domain.*;
import com.domain.TbMemberExample.Criteria;
/**
 * @author 50134
 *
 */
@Service
public class LoginoutServiceImpl implements LoginoutService{
	
	@Autowired
	TbMemberMapper usermapper;
	@Override
	public int Login() {
		long count=0;
		TbMemberExample ex=new TbMemberExample();
		Criteria cr = ex.createCriteria();
		cr.andUsernameEqualTo("admin");
		cr.andPasswordEqualTo("admin");
		count=usermapper.countByExample(ex);
		// TODO 自动生成的方法存根
		return (int) count;
	}

	@Override
	public int Logout() {
		// TODO 自动生成的方法存根
		return 0;
	}

}
