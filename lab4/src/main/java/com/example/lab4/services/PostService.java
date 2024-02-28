package com.example.lab4.services;

import com.example.lab4.model.PostEntity;
import com.example.lab4.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Iterable<PostEntity> getAll() {
        return postRepository.findAll();
    }

    public PostEntity getPostById(Integer id) {
        if (postRepository.findById(id).isEmpty()) {
            return null;
        }
        return postRepository.findById(id).get();
    }

    public PostEntity savePost(PostEntity post) {
        return postRepository.save(post);
    }

    public int deleteById(Integer post_id) {
        if (postRepository.findById(post_id).isEmpty()) {
            return -1;
        }
        postRepository.deleteById(post_id);
        return 0;
    }
}
