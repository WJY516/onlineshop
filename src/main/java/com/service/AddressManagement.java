package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AddressManagement {
	public int InsertAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public int DeleteAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public int UpdateAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public List SelectAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
