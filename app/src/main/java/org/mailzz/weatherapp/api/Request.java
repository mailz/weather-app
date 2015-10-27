package org.mailzz.weatherapp.api;

import java.util.Map;

/**
 * Created by Dmitriy Trandin on 25.10.2015.
 */
public class Request {

    private String url;
    private String method;

    private Request() {
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public class Builder {

        private Builder() {
        }


        public Builder setUserId(String url, String method) {
            Request.this.url = url;
            Request.this.method = method;
            return this;
        }

//        public Builder setToken(String token) {
//            Account.this.token = token;
//            return this;
//        }

        public Request build() {
            return Request.this;
        }

    }
}
