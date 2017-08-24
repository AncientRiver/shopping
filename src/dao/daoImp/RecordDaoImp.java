package dao.daoImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.RecordDao;
import entity.JdbcUtil;
import vo.Goods;
import vo.Record;
import vo.User;

public class RecordDaoImp implements RecordDao {
	JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();

	@Override
	public int insert(Record record) {
		int num = 0;
		String sql = "INSERT INTO record (goods_name, buyer, seller, time) VALUES (?, ?, ?, ?)";
		num = jdbcUtil.executeUpdate(sql,
				new Object[] { record.getGoodsName(), record.getBuyerId(), record.getSellerId(), record.getTime() });
		return num;
	}

	@Override
	public List<Record> findAll() {
		List<Record> all = new ArrayList<>();
		String sql = "select * from record";
		List<Object> list = jdbcUtil.executeQuery(sql, null);
		for (int i = 0; i < list.size(); i++) {
			Object object = list.get(i);
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) object;
			Record record = new Record();
			record.setRecordId((int) map.get("record_id"));
			record.setGoodsName((String) map.get("goods_name"));
			record.setBuyerId((String) map.get("buyer"));
			record.setSellerId((String) map.get("seller"));
			record.setTime((String) map.get("time"));
			all.add(record);
		}
		return all;
	}

	@Override
	public List<Record> findRecordByKey(String buyerId) {
		
				List<Record> all = new ArrayList<Record>();
				String sql = "select * from record where buyer = ?";
				List<Object> list = jdbcUtil.executeQuery(sql, new Object[] { buyerId });
				for (int i = 0; i < list.size(); i++) {
					Object object = list.get(i);
					@SuppressWarnings("unchecked")
					Map<String, Object> map = (Map<String, Object>) object;
					Record record=new Record();
					record.setRecordId((int) map.get("record_id"));
					record.setGoodsName((String) map.get("goods_name"));
					record.setBuyerId((String) map.get("buyer"));
					record.setSellerId((String) map.get("seller"));
					record.setTime((String) map.get("time"));

					all.add(record);
				}
				return all;
	}
}
