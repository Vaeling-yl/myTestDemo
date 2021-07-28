package com.yl.graphql;

import lombok.Data;

/**
 * @author: vaeling.you
 * @create: 2021/7/15
 */
@Data
public class Post {
    private String id;
    private String title;
    private String category;
    private String authorId;
}
