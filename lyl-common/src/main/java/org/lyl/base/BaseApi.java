package org.lyl.base;

import java.util.List;
import java.util.Map;

public interface BaseApi<M> {
	public void add(M m);
	public void delete(long id);
	public void update(M m);
	public List<M> select(Map<String, Object> params);
	public M selectById(long id);
}
