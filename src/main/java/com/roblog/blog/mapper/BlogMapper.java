package com.roblog.blog.mapper;

import com.roblog.blog.dto.BlogDto;
import com.roblog.blog.model.Blog;

public class BlogMapper {
    public BlogDto mapBlog(Blog blog) {
        BlogDto blogDto = new BlogDto();
        blogDto.setId(blog.getId());
        blogDto.setTitle(blog.getTitle());
        blogDto.setBody(blog.getBody());

        return blogDto;
    }
}
