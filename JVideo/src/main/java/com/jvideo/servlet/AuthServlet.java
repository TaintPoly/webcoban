package com.jvideo.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.jvideo.dao.UserDAO;
import com.jvideo.entity.User;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet({"/login", "/register"})
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Login
		String uriString = request.getRequestURI();
		if(uriString.contains("login")) {
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String uriString = request.getRequestURI();
		if(uriString.contains("login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = UserDAO.findByEmail(email);
			if (user != null && user.getPassword().equals(password)) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/JVideo/home");
				return;
			}
			request.setAttribute("error", "có lỗi xảy ra");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}else {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String repeatPassword = request.getParameter("repeatPassword");
			String fullName = request.getParameter("fullName");
			if (password.equals(repeatPassword)) {
				User user = new User();
				user.setEmail(email);
				user.setFullName(fullName);
				user.setPassword(password);
				UserDAO.create(user);
				response.sendRedirect("/JVideo/login");
				return;
			}
//			User user = new User();
//			try {
//				BeanUtils.populate(user, request.getParameterMap());
//				String repeatPassword = request.getParameter("repeatPassword");
//				if (user.getPassword().equals(repeatPassword)) {
//					UserDAO.create(user);
//					response.sendRedirect("/JVideo/login");
//					return;
//				}
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			request.setAttribute("error", "Email hoặc mật khẩu không đúng");
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
		}
	}

}
