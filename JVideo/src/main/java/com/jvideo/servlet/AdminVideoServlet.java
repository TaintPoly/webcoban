package com.jvideo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jvideo.dao.VideoDAO;
import com.jvideo.entity.Video;
import com.jvideo.util.JpaHelper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * Servlet implementation class AdminVideoServlet
 */
@WebServlet({"/admin/videos","/admin/videos/add", "/admin/videos/edit","/admin/videos/delete"})
public class AdminVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
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
			String idString = request.getParameter("id");
			int id = Integer.parseInt(idString);
			Video video = VideoDAO.findById(id);
			request.setAttribute("video", video);
			request.getRequestDispatcher("/views/admin/videos/edit.jsp").forward(request, response);
		}else if(uriString.contains("delete")) {
			//Xoa
			String idString = request.getParameter("id");
			int id = Integer.parseInt(idString);
			VideoDAO.delete(id);
			response.sendRedirect("/JVideo/admin/videos");
			return;
		}else {
			//xem danh sách
			
			
			List<Video> list = VideoDAO.findAll();
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
			Map<String, String> errors = new HashMap<String, String>();
			//thêm mới
			String title = request.getParameter("title");
			String poster  = request.getParameter("poster");
			String youtubeId = request.getParameter("youtubeId");
			String description  = request.getParameter("description");
			String activeString  = request.getParameter("active");
			boolean active = Boolean.parseBoolean(activeString);
			
			if(title.isEmpty()) {
				errors.put("title", "Không được bỏ trống tiêu đề");
			}
			if(poster.isEmpty()) {
				errors.put("poster", "Không được bỏ trống ảnh đại diện");
			}
			
			if(errors.isEmpty()) {
				Video video = new Video();
				
				video.setTitle(title);
				video.setPoster(poster);
				video.setDescription(description);
				video.setCreateDate(new Date());
				video.setYoutubeId(youtubeId);
				video.setActive(active);
				
				
				VideoDAO.create(video);
				request.setAttribute("message", "Thêm mới thành công");
			}else {
				request.setAttribute("errors", errors);
				request.setAttribute("message_error", "Thêm mới thất bại");
			}
			
			request.getRequestDispatcher("/views/admin/videos/add.jsp").forward(request, response);
		}else {
			//cập nhật
			String idString = request.getParameter("id");
			int id = Integer.parseInt(idString);
			String title = request.getParameter("title");
			String poster  = request.getParameter("poster");
			String youtubeId = request.getParameter("youtubeId");
			String description  = request.getParameter("description");
			String activeString  = request.getParameter("active");
			boolean active = Boolean.parseBoolean(activeString);
			Video video = VideoDAO.findById(id);
				if (video != null) {
					video.setTitle(title);
					video.setPoster(poster);
					video.setDescription(description);
					video.setCreateDate(new Date());
					video.setYoutubeId(youtubeId);
					video.setActive(active);
					VideoDAO.update(video);
					request.setAttribute("video", video);
				}
			request.setAttribute("message", "Cập nhật thành công");
			request.getRequestDispatcher("/views/admin/videos/edit.jsp").forward(request, response);
		}
	}

}
