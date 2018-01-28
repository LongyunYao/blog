package yunyao.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import yunyao.blog.dao.BlogDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * post blog 控制器
 * @author luoxn28
 * @date 2016.6.18
 */
@Controller
@RequestMapping("/post")
public class PostController {

    // blog 表操作类
    @Autowired
    private BlogDao blogDao = null;

    @RequestMapping
    public String handleRequest(@RequestParam(value="editorTitle") String title, @RequestParam(value="editorAuthor") String author,
                                @RequestParam(value="editorCategory") String category, @RequestParam(value="editorPreview") String preview,
                                @RequestParam(value="editorValue") String value, Map<String, Object> map) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        yunyao.blog.entity.Blog blog = new yunyao.blog.entity.Blog(title, value, preview, author, category, date);

        //com.luoxn28.blog.dao.Blog hasBlog = blogDao.getByTitle(title);
        if (blogDao.getByTitle(title) == null) {
            blogDao.insert(blog);
            //blog = blogDao.getByTitle(title);
        }

        map.put("blog", blog);
        return "blog";
    }
}
