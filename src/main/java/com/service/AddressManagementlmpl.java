package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TbAddressMapper;
import com.domain.TbAddress;
import com.domain.TbAddressExample;
import com.domain.TbAddressExample.Criteria;


@Service
public class AddressManagementlmpl implements AddressManagement{

	@Autowired
	TbAddressMapper addressmapper;
	@Override
	public int InsertAddress(String username,String address){
		long count=0;
		TbAddressExample ex = new TbAddressExample();
		Criteria cr = ex.createCriteria();
		cr.andUsernameEqualTo(username);
		cr.andAddressEqualTo(address);
		count=addressmapper.countByExample(ex);
		if(count == 1)
		{	
			return 0;
		}
		else
		{
			
			TbAddress record = new TbAddress();
			record.setAddress(address);
			record.setUsername(username);
			count=addressmapper.insert(record);

			return (int) count;
		}

	}

	@Override
	public int DeleteAddress(String username,String address){
		long count=0;
		TbAddressExample ex = new TbAddressExample();
		Criteria cr = ex.createCriteria();
		cr.andUsernameEqualTo(username);
		cr.andAddressEqualTo(address);
		count=addressmapper.countByExample(ex);
		if(count == 0)
		{
			return (int) count;
		}
		else
		{
			count=addressmapper.deleteByExample(ex);
			return (int) count;
		}
		
	}

	@Override
	public int UpdateAddress(String username,String address,String address_id){
		long count=0;
		TbAddressExample ex = new TbAddressExample();
		Criteria cr = ex.createCriteria();
		cr.andUsernameEqualTo(username);
		Integer address_1 = address_id != null && !address_id.equals("") ? Integer.parseInt(address_id) : null;

		cr.andAddressIdEqualTo(address_1);
		count=addressmapper.countByExample(ex);
		if(count == 0)
		{
			return (int) count;
		}
		else
		{
			TbAddress record = new TbAddress();
			record.setAddress(address);
			record.setUsername(username);
			record.setAddressId(address_1);
			count=addressmapper.updateByExample(record, ex);
			return (int) count;
		}
		
	}

	@Override
	public List SelectAddressByUser(String username) {	
		long count=0;
		TbAddressExample ex = new TbAddressExample();
		List list = null ;
		Criteria cr = ex.createCriteria();
		cr.andUsernameEqualTo(username);
		count=addressmapper.countByExample(ex);
		if(count == 0)
		{
			return list;
		}
		else
		{
			
			/*TbAddress record = new TbAddress();
			record.setAddress(address);
			record.setUsername(username);*/
			list = addressmapper.selectByExample(ex);
			return list;
		}
		
	}
	
	@Override
	public List SelectAddressById(int address_id) {	
		long count=0;
		TbAddressExample ex = new TbAddressExample();
		List list = null ;
		Criteria cr = ex.createCriteria();
		cr.andAddressIdEqualTo(adderss_id)
		count=addressmapper.countByExample(ex);
		if(count == 0)
		{
			return list;
		}
		else
		{
			
			/*TbAddress record = new TbAddress();
			record.setAddress(address);
			record.setUsername(username);*/
			list = addressmapper.selectByExample(ex);
			return list;
		}
		
	}
	

}
