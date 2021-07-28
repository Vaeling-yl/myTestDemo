package com.yl.graphql;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Map;

/**
 * @author: vaeling.you
 * @create: 2021/7/15
 */
public class RequestAttributesAccessor implements ThreadLocalAccessor {

    private static final String KEY = RequestAttributesAccessor.class.getName();

    @Override
    public void extractValues(Map<String, Object> container) {
        container.put(KEY, RequestContextHolder.getRequestAttributes());
    }

    @Override
    public void restoreValues(Map<String, Object> values) {
        if (values.containsKey(KEY)) {
            RequestContextHolder.setRequestAttributes((RequestAttributes) values.get(KEY));
        }
    }

    @Override
    public void resetValues(Map<String, Object> values) {
        RequestContextHolder.resetRequestAttributes();
    }

}


