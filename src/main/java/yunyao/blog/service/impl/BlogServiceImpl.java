package yunyao.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunyao.blog.dao.BlogDao;
import yunyao.blog.entity.Blog;
import yunyao.blog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BlogDao blogDao;

    public int insert(Blog blog) {
		return this.blogDao.insert(blog);
	}

    public int update(Blog blog) {
    	return this.blogDao.update(blog);
	}

    public int delete(int id){
    	return this.blogDao.delete(id);
    }

    public Blog getById(int id){
    	return this.getById(id);
    }

    public Blog getByTitle(String title) {
		return this.blogDao.getByTitle(title);
	}

    public List<Blog> getByCategory(String category){
    	return this.blogDao.getByCategory(category);
    }

    public List<Blog> getAll(){
    	return this.blogDao.getAll();
    }
}
