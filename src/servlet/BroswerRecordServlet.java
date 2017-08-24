package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.daoImp.RecordDaoImp;
import factory.DaoFactory;
import vo.Record;
import vo.User;

/**
 * Servlet implementation class RecordServlet
 */
@WebServlet("/login/broswer_record")
public class BroswerRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BroswerRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=(User) request.getSession().getAttribute("user");
		RecordDaoImp recordDaoImp=DaoFactory.getRecordDao();
		List<Record> list=recordDaoImp.findRecordByKey(user.getUserAccount());
		request.setAttribute("recordList", list);
		RequestDispatcher rd=request.getRequestDispatcher("record.jsp");
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
