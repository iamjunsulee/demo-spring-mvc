package me.junsu.demospringmvc;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Iterator;

public class MyArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(Header.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Header header = new Header();
        Iterator<String> headerNames = nativeWebRequest.getHeaderNames();

        while(headerNames.hasNext()) {
            String headerName = headerNames.next();
            String value = nativeWebRequest.getHeader(headerName);
            header.put(headerName, value);
        }

        return header;
    }
}
