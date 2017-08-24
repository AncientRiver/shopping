package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.daoImp.UserDaoImp;
import factory.DaoFactory;
import javafx.scene.control.Alert;
import vo.User;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/login/do_register")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userAccount=request.getParameter("userAccount");
		String password=request.getParameter("userPassword");
		String nickname=request.getParameter("nickname");
		User user=new User(userAccount, password, nickname);
		
		UserDaoImp userDaoImp=DaoFactory.getUserDao();
		userDaoImp.insert(user);	
		response.getWriter().print("<script> alert(\"注册完成!\"); </script>");
		RequestDispatcher rd=request.getRequestDispatcher("chatLogin.jsp");
		rd.forward(request, response);
	}

}
