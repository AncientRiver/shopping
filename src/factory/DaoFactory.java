package factory;

import dao.daoImp.GoodsDaoImp;
import dao.daoImp.RecordDaoImp;
import dao.daoImp.UserDaoImp;
import vo.Record;

public class DaoFactory {
	public static UserDaoImp getUserDao(){
		return new UserDaoImp();
	}
	public static GoodsDaoImp getGoodsDao(){
		return new GoodsDaoImp();
	}
	public static RecordDaoImp getRecordDao(){
		return new RecordDaoImp();
	}
}
