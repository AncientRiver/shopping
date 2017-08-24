package dao.daoImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.GoodsDao;
import entity.JdbcUtil;
import vo.Goods;

public class GoodsDaoImp implements GoodsDao{
	JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
	@Override
	public int insert(Goods goods) {
		int num = 0;
		String sql = "INSERT INTO goods (goods_name, goods_price, picture, seller) VALUES (?, ?, ?, ?)";
		num = jdbcUtil.executeUpdate(sql, new Object[] {goods.getGoodsName(),goods.getGoodsPrice(),goods.getGoodsPictureId(),goods.getSeller() });
		return num;
	}
	@Override
	public List<Goods> findAll() {
		// TODO Auto-generated method stub
				List<Goods> all = new ArrayList<>();
				String sql = "select * from goods";
				List<Object> list = jdbcUtil.executeQuery(sql,  null);
				for (int i = 0; i < list.size(); i++) {
					Object object = list.get(i);
					@SuppressWarnings("unchecked")
					Map<String, Object> map = (Map<String, Object>) object;
					Goods goods=new Goods();
					goods.setGoodsId((int) map.get("goods_id"));
					goods.setGoodsName((String) map.get("goods_name"));
					goods.setGoodsPrice((double) map.get("goods_price"));
					goods.setGoodsPictureId((String) map.get("picture"));
					goods.setSeller((String) map.get("seller"));
					all.add(goods);
				}
				return all;
	}
}
