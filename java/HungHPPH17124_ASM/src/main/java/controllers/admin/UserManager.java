package controllers.admin;

import DAO.UserDAO;
import Utils.CryptUtil;
import entities.UsersEntity;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet({"/admin/users/index", "/admin/users/create", "/admin/users/store", "/admin/users/edit", "/admin/users/update",
        "/admin/users/delete",})
public class UserManager extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO dao = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("index")) {
            this.index(request, response);

        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);

        } else {
            // not found 404
            response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            // not found 404
            response.sendError(404);
        }
    }
    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name ="";
        if (request.getParameter("name") != null) {
            name = request.getParameter("name");

        }
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        List<UsersEntity> list = this.dao.findUsersByName(name, page,5);
        int pageCount  = (int) Math.ceil(this.dao.getcount(name)/5.0);
        request.setAttribute("name", name);
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("view","/Views/admin/UserManager.jsp");
        request.getRequestDispatcher("/Views/admin/index.jsp").forward(request, response);
    }
    private void store (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            UsersEntity user = new UsersEntity();
            BeanUtils.populate(user, request.getParameterMap());
            String password = CryptUtil.encrypt(user.getPassword());
            user.setPassword(password);
            this.dao.insertUser(user);
            session.setAttribute("message", "Thêm mới thành công");
            response.sendRedirect(request.getContextPath() + "/admin/users/index");


        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm mới thất bại");
            response.sendRedirect(request.getContextPath() + "/admin/users/index");
        }
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            UsersEntity user = new UsersEntity();
            BeanUtils.populate(user, request.getParameterMap());
            UsersEntity passOld = this.dao.findUsersById(user.getId());
            user.setPassword(passOld.getPassword());
            this.dao.updateUser(user);
            session.setAttribute("message", "Cập nhật thành công");
        }catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Cập nhật thất bại");
            response.sendRedirect(request.getContextPath() + "/admin/users/index");
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UsersEntity user = this.dao.findUsersById(id);
            this.dao.deleteUser(user);
            session.setAttribute("message", "Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Xóa thất bại");
        }
        response.sendRedirect(request.getContextPath() + "/admin/users/index");
    }
    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UsersEntity user = this.dao.findUsersById(id);
        request.setAttribute("user", user);
        request.setAttribute("view", "/Views/admin/UserEdit.jsp");
        request.getRequestDispatcher("/Views/admin/index.jsp").forward(request, response);
    }
}
