package com.yvan.vo.dynamicroute;

import org.junit.platform.commons.util.StringUtils;

/**
 * @author v_yangfeng01
 * @date 2021/2/18
 */
public class DynamicRouteRequest {
    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";
    private String code;
    private String path;
    private String method;
    private String uri;
    private String token;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        if (HTTP_METHOD_GET.equalsIgnoreCase(method)) {
            this.method = HTTP_METHOD_GET;
        } else if (HTTP_METHOD_POST.equalsIgnoreCase(method)) {
            this.method = HTTP_METHOD_POST;
        } else {
            this.method = null;
        }
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isVaild() {
        return (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(path)
                && StringUtils.isNotBlank(method) && StringUtils.isNotBlank(uri));
    }
}
