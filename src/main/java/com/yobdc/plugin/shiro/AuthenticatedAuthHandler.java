/**
 * Copyright (c) 2011-2017, dafei 李飞 (myaniu AT gmail DOT com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yobdc.plugin.shiro;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;

/**
 * 已认证通过访问控制处理器
 * 单例模式运行。
 *
 * @author dafei
 *
 */
class AuthenticatedAuthHandler extends AbstractAuthHandler {

    private static AuthenticatedAuthHandler aah = new AuthenticatedAuthHandler();

    private AuthenticatedAuthHandler() {
    }

    public static AuthenticatedAuthHandler me() {
        return aah;
    }

    public void assertAuthorized() throws AuthorizationException {
        if (!getSubject().isAuthenticated()) {
            throw new UnauthenticatedException("The current Subject is not authenticated.  Access denied.");
        }
    }
}
