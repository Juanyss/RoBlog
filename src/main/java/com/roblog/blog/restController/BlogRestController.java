package com.roblog.blog.restController;

import com.roblog.blog.dto.BlogDto;
import com.roblog.blog.model.Blog;
import com.roblog.blog.service.BlogServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("rest/blogs")
public class BlogRestController {
    @Autowired
    private BlogServiceImpl blogServiceImpl;

    protected final Log logger = LogFactory.getLog(this.getClass());

    @GetMapping("")
    public List<BlogDto> getAllBlogs() {
        return blogServiceImpl.findAllNotDeleted();
    }

    @GetMapping("/{id}")
    public BlogDto getOneBlog(@PathVariable(value = "id") Integer id) {
        return blogServiceImpl.findOne(id);
    }

    @PostMapping("")
    public void createBlog(@RequestBody Blog blog) {
        blogServiceImpl.create(blog);
    }

    @PatchMapping("/{id}/title")
    public BlogDto updateTitle(@PathVariable(value = "id") Integer id, @RequestBody Blog blog) {
        return blogServiceImpl.updateTitle(id, blog.getTitle());
    }

    @PatchMapping("/{id}/body")
    public BlogDto updateBody(@PathVariable(value = "id") Integer id, @RequestBody Blog blog) {
        return blogServiceImpl.updateBody(id, blog.getBody());
    }

    @PatchMapping("/{id}/image")
    public BlogDto updateImage(@PathVariable(value = "id") Integer id, @RequestBody Blog blog) {
        return blogServiceImpl.updateImage(id, blog.getImage());
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable(value = "id") Integer id){
        blogServiceImpl.deleteBlog(id);
    }
}
