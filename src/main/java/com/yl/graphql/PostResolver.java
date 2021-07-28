package com.yl.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author: vaeling.you
 * @create: 2021/7/15
 */
@Repository
public class PostResolver implements GraphQLResolver<Post> {

    @Autowired
    private AuthorDao authorDao;

    public Author getAuthor(Post post) {
        return authorDao.getAuthorById(post.getAuthorId());
    }
}