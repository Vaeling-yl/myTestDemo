package com.yl.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

/**
 * @author: vaeling.you
 * @create: 2021/7/15
 */
public class Mutation implements GraphQLMutationResolver {
    private PostDao postDao;

    public Post writePost(String title, String text, String category) {
        return postDao.savePost(title, text, category);
    }
}
