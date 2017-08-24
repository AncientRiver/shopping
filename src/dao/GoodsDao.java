package dao;

import java.util.List;

import vo.Goods;

public interface GoodsDao {
	int insert(Goods goods);

	List<Goods> findAll();
}
