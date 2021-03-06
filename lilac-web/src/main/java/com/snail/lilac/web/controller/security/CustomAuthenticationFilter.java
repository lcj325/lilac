package com.snail.lilac.web.controller.security;

import javax.servlet.ServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * @author Andy
 * @since 2013-6-27
 */
public class CustomAuthenticationFilter extends FormAuthenticationFilter {

    /*
     * (non-Javadoc)
     * @see org.apache.shiro.web.filter.authc.FormAuthenticationFilter#setFailureAttribute(javax.servlet.ServletRequest,
     * org.apache.shiro.authc.AuthenticationException)
     */
    @Override
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        request.setAttribute(getFailureKeyAttribute(), ae);
    }

}
