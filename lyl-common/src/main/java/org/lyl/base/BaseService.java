package org.lyl.base;

import java.util.List;
import java.util.Map;

public abstract class BaseService<P extends BaseApi<M>, M> {
		protected P provider;
		public void add(M m){
			provider.add(m);
		};
		public void delete(long id){
			provider.delete(id);
		}
		public void update(M m){
			provider.update(m);
		}
		public List<M> select(Map<String, Object> params){
			return provider.select(params);		
		}
		public M selectById(long id){
			return provider.selectById(id);			
		}
}
