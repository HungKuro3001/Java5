package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import entities.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/admin/users/index", "/admin/users/create", "/admin/users/store", "/admin/users/edit", "/admin/users/update",
		"/admin/users/delete", "/admin/users/show", })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("show")) {
			this.show(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		} else {
			// redirect 404
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		} else {
			// redirect 404
		}
	}
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();
		request.setAttribute("ds", ds);
		request.setAttribute("view","/views/index.jsp");
		request.getRequestDispatcher("/layout.jsp").forward(request, response);
	}
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("view","/views/create.jsp");
		request.getRequestDispatcher("/layout.jsp").forward(request, response);

	}
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User entity  = this.userDAO.findById(id);
		request.setAttribute("user", entity);
		request.setAttribute("view","/views/edit.jsp");
		request.getRequestDispatcher("/layout.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/admin/users/index");
	}
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User entity = this.userDAO.findById(id);
		try {
			this.userDAO.delete(entity);
			response.sendRedirect(request.getContextPath() + "/admin/users/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			User entity = new User();
			BeanUtils.populate(entity, request.getParameterMap());
			this.userDAO.create(entity);
			response.sendRedirect(request.getContextPath() + "/admin/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/admin/users/create");
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User entity = new User();
			BeanUtils.populate(entity, request.getParameterMap());
			this.userDAO.update(entity);
			response.sendRedirect(request.getContextPath() + "/admin/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
	}

}
