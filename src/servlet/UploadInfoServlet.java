package servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import dao.daoImp.GoodsDaoImp;
import factory.DaoFactory;
import vo.Goods;
import vo.User;

/**
 * Servlet implementation class uploadInfoServlet
 */
@WebServlet("/login/upload_info")
public class UploadInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadInfoServlet() {
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
		// TODO Auto-generated method stub 上传文件
		SmartUpload sUpload=new SmartUpload();
		sUpload.initialize(this.getServletConfig(), request, response);
		sUpload.setAllowedFilesList("jpg,png,doc");//允许上传的文件后缀名
		try {
			sUpload.upload();//上传准备
			String path=request.getSession().getServletContext().getRealPath("upload");  
            sUpload.save(path);//文件保存  
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取信息存入数据库
		String fileName=sUpload.getFiles().getFile(0).getFileName();
		String goodsName=sUpload.getRequest().getParameter("goodsName");
		double goodsPrice=Double.parseDouble(sUpload.getRequest().getParameter("goodsPrice"));
		User user=(User) request.getSession().getAttribute("user");
		
		Goods goods=new Goods();
		goods.setGoodsName(goodsName);
		goods.setGoodsPictureId(fileName);
		goods.setGoodsPrice(goodsPrice);
		goods.setSeller(user.getUserAccount());
		
		GoodsDaoImp goodsDaoImp=DaoFactory.getGoodsDao();
		goodsDaoImp.insert(goods);
		
		RequestDispatcher rd=request.getRequestDispatcher("do_login.jsp");
		rd.forward(request, response);
	}

}
