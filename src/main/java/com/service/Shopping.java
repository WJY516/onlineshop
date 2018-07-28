package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Shopping {
		public void shopping(HttpServletRequest request,HttpServletResponse response);
		public void showgoods(HttpServletRequest request,HttpServletResponse response);
		public void findgoods(HttpServletRequest request,HttpServletResponse response);
}
