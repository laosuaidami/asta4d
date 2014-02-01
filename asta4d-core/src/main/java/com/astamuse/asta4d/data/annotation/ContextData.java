/*
 * Copyright 2012 astamuse company,Ltd.
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

package com.astamuse.asta4d.data.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.astamuse.asta4d.data.InjectUtil;

/**
 * This annotation is for marking a field (including getter/setter method) or a method parameter as {@link Context} associated.
 * 
 * @author e-ryu
 * @see InjectUtil
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
public @interface ContextData {

    /**
     * The name of associated context data, if not specified, the inject process will use the field/parameter name as context data name.
     */
    String name() default "";

    /**
     * The scope of associated context data, if not specified, the inject process will try to find it in a predefined search order in all
     * scopes.
     */
    String scope() default "";

    /**
     * It is only valid on field or getter method, if it is set to true, when a snippet execution finished, the current value of the field
     * will be reversely injected to Context.
     * 
     * This specification is not necessary and it also complicate the variable injection mechanism. It should be removed at sometime.
     * 
     */
    @Deprecated
    boolean reverse() default false;

}