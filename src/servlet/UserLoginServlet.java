package servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import factory.DaoFactory;
import vo.User;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet(
		urlPatterns = { "/login/do_login" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "utf-8", description = "字符编码")
		})
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("userAccount");
		String password=request.getParameter("userPassword");
		User newUser=new User(user,password,null);
		
		dao.daoImp.UserDaoImp userDaoImp=DaoFactory.getUserDao();
		java.util.List<User> list=userDaoImp.findAll();
		Iterator<User> iterator=list.iterator();
		
		while (iterator.hasNext()) {
			User temp=iterator.next();
			if (newUser.getUserAccount().equals(temp.getUserAccount())&& newUser.getPassword().equals(temp.getPassword())) {
				request.getSession().setAttribute("user", temp);
				RequestDispatcher rd=request.getRequestDispatcher("do_login.jsp");
				rd.forward(request, response);
			}

		}
		
		RequestDispatcher rd=request.getRequestDispatcher("returnBefore.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
