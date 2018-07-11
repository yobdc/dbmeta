package com.yobdc.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResponse {
    private boolean success;

    private RestResponse() {
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
}
