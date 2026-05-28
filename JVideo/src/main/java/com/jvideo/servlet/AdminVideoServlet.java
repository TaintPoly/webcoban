package com.jvideo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
			request.getRequestDispatcher("/views/admin/videos/add.jsp").forward(request, response);
		}else if(uriString.contains("edit")) {
			//sửa
		}else if(uriString.contains("delete")) {
			//Xoa
		}else {
			//xem danh sách
//			list.clear();
//			list.add(new Video(1, "", "video 1", "", "",new Date(), 10000, true));
//			list.add(new Video(2, "", "video 2", "", "", new Date(), 10000000, true));
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/admin/videos/list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String uriString = request.getRequestURI();
		if(uriString.contains("add")) {
			//thêm mới
			String title = request.getParameter("title");
			String poster  = request.getParameter("poster");
			String youtubeId = request.getParameter("youtubeId");
			String description  = request.getParameter("description");
			String activeString  = request.getParameter("active");
			boolean active = Boolean.parseBoolean(activeString);
			Video video = new Video();
			video.setId(0);
			video.setTitle(title);
			video.setPoster(poster);
			video.setDescription(description);
			video.setCreateDate(new Date());
			video.setYoutubeId(youtubeId);
			video.setActive(active);
			list.add(video);
			request.setAttribute("message", "Thêm mới thành công");
			request.getRequestDispatcher("/views/admin/videos/add.jsp").forward(request, response);
		}else {
			//cập nhật
		}
	}

}
