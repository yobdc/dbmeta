package com.yobdc.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class RestResponse {
    private boolean success;
    private Map<Object, Object> data;

    private RestResponse() {
        data = new HashMap<>();
    }

    public static RestResponse success() {
        RestResponse me = new RestResponse();
        me.success = true;
        return me;
    }

    public static RestResponse fail() {
        RestResponse me = new RestResponse();
        me.success = false;
        return me;
    }

    public RestResponse bind(Object key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
