package com.example.lab3.xsl.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
public class PostList {
    private List<Post> postList = new ArrayList<Post>();

    public PostList() {
    }

    public PostList(ArrayList<Post> postList) {
        this.postList = postList;
    }

    @XmlElement(name = "post")
    public List<Post> getPosts() {
        return postList;
    }

    public void setPostList(ArrayList<Post> postList) {
        this.postList = postList;
    }

}
