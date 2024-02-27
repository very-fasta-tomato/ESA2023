package com.example.lab2.services;

import com.example.lab2.model.PostEntity;
import com.example.lab2.repo.PostRepository;
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

    public void savePost(PostEntity post) {
        postRepository.save(post);
    }

    public void deleteById(Integer post_id) {
        postRepository.deleteById(post_id);
    }
}
