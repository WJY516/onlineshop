package com.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginoutService {
		public int Login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
		public int Logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
}
