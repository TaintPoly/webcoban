package com.jvideo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jvideo.entity.Video;

/**
 * Servlet implementation class AdminVideoServlet
 */
@WebServlet({"/admin/videos","/admin/videos/add", "/admin/videos/edit","/admin/videos/delete"})
public class AdminVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    List<Video> list = new ArrayList();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uriString = request.getRequestURI();
		if(uriString.contains("add")) {
			//thêm mới
		}else if(uriString.contains("edit")) {
			//sửa
		}else if(uriString.contains("delete")) {
			//Xoa
		}else {
			//xem danh sách
			list.clear();
			list.add(new Video(1, "", "video 1", "", "", 0, true));
			list.add(new Video(2, "", "video 2", "", "", 0, true));
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/admin/videos/list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
