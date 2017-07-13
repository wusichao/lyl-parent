package org.lyl.base;

import java.util.List;
import java.util.Map;

public interface BaseMapper<M> {
	void add(M m);
	void delete(long id);
	void update(M m);
	List<M> select(Map<String, Object> params);
	M selectById(long id);
}
