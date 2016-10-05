/*
 * Copyright 2013-2015 Alvaro Sanchez-Mariscal <alvaro.sanchezmariscal@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
import javax.servlet.http.HttpServletResponse

security {

    rest {

        active = true

        login {
            active = true
            endpointUrl = '/api/login'
            usernamePropertyName = 'username'
            passwordPropertyName = 'password'
            failureStatusCode = HttpServletResponse.SC_UNAUTHORIZED    //401
            useJsonCredentials = true
            useRequestParamsCredentials = false
        }

        logout {
            endpointUrl = '/api/logout'
        }

        token {

            generation {
                useSecureRandom = true
                useUUID = false

                jwt {
                    issuer = "Spring Security REST Grails Plugin"
                }

            }

            storage {
                jwt {
                    useSignedJwt = true
                    useEncryptedJwt = false

                    secret = null
                    expiration = 3600
                }
            }

            validation {
                active = true
                headerName = 'X-Auth-Token'
                endpointUrl = '/api/validate'
                tokenHeaderMissingStatusCode = HttpServletResponse.SC_UNAUTHORIZED    //401
                enableAnonymousAccess = false
                useBearerToken = true
            }

            rendering {
                usernamePropertyName = 'username'
                tokenPropertyName = 'access_token'
                authoritiesPropertyName = 'roles'
            }
        }
    }
}
