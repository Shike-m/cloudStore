package com.store.apigateway.filter;
/*
 *  Created by Shike
 *  2018/8/27:17:53
 **/

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext().getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        // get from URl or cookie or header
        String token = httpServletRequest.getParameter("token");
        if(StringUtils.isEmpty(token)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);

        }
        return null;
    }
}
