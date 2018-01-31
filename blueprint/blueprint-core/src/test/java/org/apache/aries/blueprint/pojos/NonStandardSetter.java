/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.aries.blueprint.pojos;

public class NonStandardSetter {

    private String a;
    private String b;

    public NonStandardSetter() {
    }

    public String a() {
        return this.a;
    }

    public NonStandardSetter a(String a) {
        this.a = a;
        return this;
    }

    public String b() {
        return this.b;
    }

    public NonStandardSetter b(String b) {
        this.b = b;
        return this;
    }



}
