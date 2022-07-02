package controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import DAO.UserDAO;
import beans.form_data.ResData;
import entities.User;
import utils.EncryptUtil;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		} else {
			// redirect 404
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> ds = this.userDAO.all();
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/user/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("view", "/views/admin/user/Create.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/admin/users/index");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User entity = this.userDAO.findById(id);
		request.setAttribute("hoTen", entity.getHoTen());
		request.setAttribute("diaChi", entity.getDiaChi());
		request.setAttribute("email", entity.getEmail());
		request.setAttribute("password", entity.getPassword());
		request.setAttribute("sdt",entity.getSdt());
		
		request.setAttribute("view", "/views/admin/user/Edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User entity = this.userDAO.findById(id);
		try {
			this.userDAO.delete(entity);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/admin/users/index");
	}

	private void store(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
				try{
					User entity = new User();
					BeanUtils.populate(entity, request.getParameterMap());
					String encrypted = EncryptUtil.encrypt(
							request.getParameter("password")
						);
						
						entity.setPassword(encrypted);
						
					//thêm mới
					this.userDAO.create(entity);
					session.setAttribute("message", "Thêm mới thành công");
					response.sendRedirect(request.getContextPath() + "/admin/users/index");
				}catch(Exception e){
					e.printStackTrace();
					session.setAttribute("error", "Thêm mới thất bại");
					response.sendRedirect(request.getContextPath() + "/admin/users/index");

				}

	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//create function update
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User entity = this.userDAO.findById(id);
		try {
			this.userDAO.update(entity);
			// show data on form
			
			request.setAttribute("hoTen", entity.getHoTen());
			request.setAttribute("diaChi", entity.getDiaChi());
			request.setAttribute("email", entity.getEmail());
			request.setAttribute("password", entity.getPassword());
			request.setAttribute("sdt",entity.getSdt());
			response.sendRedirect(request.getContextPath() + "/admin/users/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
