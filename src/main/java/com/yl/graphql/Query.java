package com.yl.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

/**
 * @author: vaeling.you
 * @create: 2021/7/15
 */
public class Query implements GraphQLQueryResolver {
    private PostDao postDao;

    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.getRecentPosts(count, offset);
    }
}
