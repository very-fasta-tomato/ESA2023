package models.dto;

import lombok.Data;

@Data
public class Post{
    private int id;
    private String title;
    private String content;
    private int user_id;
}
