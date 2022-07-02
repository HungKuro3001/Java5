package controllers.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet({"/admin/TrangChu","/admin/UserManager","/admin/ProductManager","/admin/OrderManager","/admin/CategoryManager"})
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("TrangChu")){
            request.setAttribute("view","/Views/admin/TrangChu.jsp");
            request.getRequestDispatcher("/Views/admin/index.jsp").forward(request,response);
        }else if(uri.contains("UserManager")){
            response.sendRedirect("/HungHPPH17124_ASM/UserManager/index");
        }else if(uri.contains("ProductManager")){
            response.sendRedirect("/HungHPPH17124_ASM/ProductManager/index");
        }else if(uri.contains("CategoryManager")){
            response.sendRedirect("/HungHPPH17124_ASM/CategoryManager/index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
