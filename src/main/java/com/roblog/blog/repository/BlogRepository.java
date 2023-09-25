package com.roblog.blog.repository;

import com.roblog.blog.model.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BlogRepository extends CrudRepository<Blog, Integer> {

    List<Blog> findByDeleteAtIsNull();
}
