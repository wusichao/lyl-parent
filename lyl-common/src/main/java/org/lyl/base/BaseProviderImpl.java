package org.lyl.base;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public abstract class BaseProviderImpl<M,D extends BaseMapper<M> > implements BaseApi<M>{
	   protected D mapper; 
	   @Transactional
	  	public void add(M m){
	  		mapper.add(m);
	  	};
	  	@Transactional
	  	public void delete(long id){
	  		mapper.delete(id);
	  	};
	  	@Transactional
	  	public void update(M m){
	  		mapper.update(m);
	  	};
	  	public List<M> select(Map<String, Object> params){
			return mapper.select(params);
	  		
	  	};
	  	public M selectById(long id){
			return mapper.selectById(id);
	  		
	  	};
}
