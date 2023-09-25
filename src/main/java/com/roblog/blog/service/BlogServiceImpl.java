package com.roblog.blog.service;

import com.roblog.blog.dto.BlogDto;
import com.roblog.blog.mapper.BlogMapper;
import com.roblog.blog.model.Blog;
import com.roblog.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl {

    BlogMapper mapper = new BlogMapper();

    @Autowired
    private BlogRepository blogRepository;

    public List<BlogDto> findAll() {
        ArrayList<BlogDto> blogDtos = new ArrayList<>();
        Iterable<Blog> blogs = blogRepository.findAll();
        blogs.forEach(blog -> {
            blogDtos.add(mapper.mapBlog(blog));
        });
        return blogDtos;
    }

    public List<BlogDto> findAllNotDeleted() {
        ArrayList<BlogDto> blogDtos = new ArrayList<>();
        Iterable<Blog> blogs = blogRepository.findByDeleteAtIsNull();
        blogs.forEach(blog -> {
            blogDtos.add(mapper.mapBlog(blog));
        });
        return blogDtos;
    }

    public BlogDto findOne(Integer id) {
        Optional<Blog> blog = blogRepository.findById(id);
        return mapper.mapBlog(blog.get());

    }

    public void create(Blog blog) {
        blog.setCreateAt(Date.from(Instant.now()));
        blogRepository.save(blog);
    }

    public BlogDto updateTitle(Integer id, String title) {
        Optional<Blog> blog = blogRepository.findById(id);
        blog.get().setTitle(title);
        blog.get().setUpdateAt(Date.from(Instant.now()));
        blogRepository.save(blog.get());
        return mapper.mapBlog(blog.get());
    }

    public BlogDto updateBody(Integer id, String body) {
        Optional<Blog> blog = blogRepository.findById(id);
        blog.get().setBody(body);
        blog.get().setUpdateAt(Date.from(Instant.now()));
        blogRepository.save(blog.get());
        return mapper.mapBlog(blog.get());
    }

    public BlogDto updateImage(Integer id, String image) {
        Optional<Blog> blog = blogRepository.findById(id);
        blog.get().setImage(image);
        blog.get().setUpdateAt(Date.from(Instant.now()));
        blogRepository.save(blog.get());
        return mapper.mapBlog(blog.get());
    }

    public void deleteBlog(Integer id) {
        Optional<Blog> blog = blogRepository.findById(id);
        blog.get().setDeleteAt(Date.from(Instant.now()));
        blogRepository.save(blog.get());
    }
}
