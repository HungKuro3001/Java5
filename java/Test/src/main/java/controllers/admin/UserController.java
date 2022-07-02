package controllers.admin;

import DAO.UserDAO;
import entities.UsersEntity;
import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = {"/admin/users/index", "/admin/users/create", "/admin/users/store", "/admin/users/edit", "/admin/users/update", "/admin/users/delete", "/admin/users/show",})
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getServletPath();
//        switch (action) {
//            case "/admin/users/index":
//                index(request, response);
//                break;
//            case "/admin/users/create":
//                create(request, response);
//                break;
//            case "/admin/users/store":
//                store(request, response);
//                break;
//            case "/admin/users/edit":
//                edit(request, response);
//                break;
//            case "/admin/users/update":
//                update(request, response);
//                break;
//            case "/admin/users/delete":
//                delete(request, response);
//                break;
//            case "/admin/users/show":
//                show(request, response);
//                break;

//        }
        String uri = request.getRequestURI();
        if (uri.equals("/admin/users/index")) {
            index(request, response);
        } else if (uri.equals("/admin/users/create")) {
            create(request, response);
        } else if (uri.equals("/admin/users/store")) {
            store(request, response);
        } else if (uri.equals("/admin/users/edit")) {
            edit(request, response);
        } else if (uri.equals("/admin/users/update")) {
            update(request, response);
        } else if (uri.equals("/admin/users/delete")) {
            delete(request, response);
        } else if (uri.equals("/admin/users/show")) {
            show(request, response);
        } else {
            response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/admin/users/store")) {
            store(request, response);
        } else if (uri.equals("/admin/users/update")) {
            update(request, response);
        } else {
            response.sendError(404);
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UsersEntity> users = userDAO.findAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/views/admin/users/index.jsp").forward(request, response);

    }
    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", "/WEB-INF/views/admin/users/create.jsp");
        request.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(request, response);
    }ws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
    private void edit(HttpServletRequest request, HttpServletResponse response) thro
        UsersEntity user = userDAO.findById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(request, response);
    }
    private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UsersEntity user = userDAO.findById(id);
        try {
            userDAO.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
    private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsersEntity user = new UsersEntity();
            BeanUtils.populate(user, request.getParameterMap());
                this.userDAO.create(user);
                response.sendRedirect("/admin/users/index");


        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsersEntity user = new UsersEntity();
            BeanUtils.populate(user, request.getParameterMap());
            this.userDAO.update(user);
            response.sendRedirect("/admin/users/index");
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}

