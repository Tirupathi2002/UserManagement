package com.um.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.um.dao.ServiceDao;
import com.um.model.User;


@WebServlet("/")
public class MyServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		
		switch(path) {
		
		case"/add":getUserFormpage(request,response);
		break;
		
		case"/insert":insertData(request,response);
		break;
		
		case"/delete":deleteUser(request,response);
		break;
		
		case"/edit":getEditPage(request,response);
		break;
		
		case"/update":updateData(request,response);
		break;
		
		default:getUserListPage(request,response);
		
		}
		
	}
	
	
	private void updateData(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("tbid"));
		String name = request.getParameter("tbname");
		String email = request.getParameter("tbemail");
		String city = request.getParameter("tbcity");
		
		User us = new User(id, name, email, city);
		
	   ServiceDao.doUpdate(us);
	   
	   try {
		response.sendRedirect("default_page");
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}


	private void getEditPage(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		User us = ServiceDao.doEdit(id);
		
		request.setAttribute("edit", us);
		
		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		
		
	}


	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id")); 
		
		ServiceDao.doDelete(id);
		
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	private void insertData(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		String name = request.getParameter("tbname");
		String email = request.getParameter("tbemail");
		String city = request.getParameter("tbcity");
		
		User u = new User(name, email, city);
		
		ServiceDao.doInsert(u);
		
		try {
			response.sendRedirect("getUserListPage");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}


	private void getUserFormpage(HttpServletRequest request, HttpServletResponse response) {
		
		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}



   
    private void getUserListPage(HttpServletRequest request, HttpServletResponse response) {
    	
    	ArrayList<User> arli = ServiceDao.doDisplay();
    	
    	request.setAttribute("disp", arli);
		
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}
}
