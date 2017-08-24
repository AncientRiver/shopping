package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.daoImp.RecordDaoImp;
import factory.DaoFactory;
import vo.Record;

/**
 * Servlet implementation class InsertRecordServlet
 */
@WebServlet("/login/insert_record")
public class InsertRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsName=request.getParameter("goodsName");
		String buyerId=request.getParameter("buyer");
		String sellerId=request.getParameter("seller");
		Record record=new Record();
		record.setGoodsName(goodsName);
		record.setBuyerId(buyerId);
		record.setSellerId(sellerId);
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		record.setTime(simpleDateFormat.format(date));
		RecordDaoImp recordDaoImp=DaoFactory.getRecordDao();
		recordDaoImp.insert(record);
		
		RequestDispatcher rd=request.getRequestDispatcher("buyer.jsp");
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
