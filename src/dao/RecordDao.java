package dao;

import java.util.List;

import vo.Record;

public interface RecordDao {
	int insert(Record record);

	List<Record> findAll();
	
	List<Record> findRecordByKey(String buyerId);
}
