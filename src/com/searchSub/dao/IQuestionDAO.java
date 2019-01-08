package com.searchSub.dao;
import java.util.List;

import com.searchSub.po.IQuestion;
import com.searchSub.po.Question;

public interface IQuestionDAO {
	public void save(IQuestion transientInstance);
	public void delete(Question transientInstance);
	public void update(Question transientInstance);
	public List findByHQL(String hql);
	public Question findById(int id);
	//保存收藏
	public void saveOrUpdate(Question transientInstance);
	//得到出错的题目方法
	public List<Question> getErrors(); 
}
