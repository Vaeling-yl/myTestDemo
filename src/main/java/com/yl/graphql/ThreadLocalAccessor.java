package com.yl.graphql;

import java.util.Map;

/**
 * @author: vaeling.you
 * @create: 2021/7/15
 */
public interface ThreadLocalAccessor {
    void extractValues(Map<String, Object> container);

    void restoreValues(Map<String, Object> values);

    void resetValues(Map<String, Object> values);
}
