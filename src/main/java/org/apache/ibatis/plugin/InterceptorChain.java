/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 责任链模式
 * 拦截器
 *
 * 多个插件(Interceptor实现类)的处理
 *
 * @author Clinton Begin
 */
public class InterceptorChain {

  /**
   * Interceptor 实现类对象集合
   */
  private final List<Interceptor> interceptors = new ArrayList<>();

  /**
   * 每个Interceptor实现类(插件)都可能对应生成一个代理对象 代理目标对象的方法 最终生成一个代理对象的拦截器链(责任链模式)
   *
   * 每个拦截器都通过代理处理 其实最终生成一个代理链
   * @param target
   * @return
   */
  public Object pluginAll(Object target) {
    for (Interceptor interceptor : interceptors) {
      target = interceptor.plugin(target);
    }
    return target;
  }

  public void addInterceptor(Interceptor interceptor) {
    interceptors.add(interceptor);
  }

  public List<Interceptor> getInterceptors() {
    return Collections.unmodifiableList(interceptors);
  }

}
