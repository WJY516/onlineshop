package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AddressManagement {
	public int InsertAddress(String username,String address);
	public int DeleteAddress(String username,String address);
	public int UpdateAddress(String username,String address,String address_id);
	public List SelectAddressByUser(String username);
	public List SelectAddressById(String address_id);

}
