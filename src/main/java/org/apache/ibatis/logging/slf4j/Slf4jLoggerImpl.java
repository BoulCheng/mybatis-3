/**
 *    Copyright 2009-2017 the original author or authors.
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
package org.apache.ibatis.logging.slf4j;

import org.apache.ibatis.logging.Log;
import org.slf4j.Logger;

/**
 * 适配器模式
 *
 * Mybatis内部在使用日志模块时，使用了其内部接口 org.apache.ibatis.logging.Log,但是常用的日志框架的对外接口各不相同，Mybatis为了复用和集成这些第三方日志组件，在其日志模块中，提供了多种Adapter,将这些第三方日志组件对外接口适配成org.apache.ibatis.logging.Log，这样Myabtis 就可以通过Log接口调用第三方日志了
 *
 * Slf4jLoggerImpl 相当于适配器
 */

/**
 * @author Eduardo Macarron
 */
class Slf4jLoggerImpl implements Log {

  // 相当于目标接口
  private final Logger log;

  public Slf4jLoggerImpl(Logger logger) {
    log = logger;
  }

  @Override
  public boolean isDebugEnabled() {
    return log.isDebugEnabled();
  }

  @Override
  public boolean isTraceEnabled() {
    return log.isTraceEnabled();
  }

  @Override
  public void error(String s, Throwable e) {
    log.error(s, e);
  }

  @Override
  public void error(String s) {
    log.error(s);
  }

  @Override
  public void debug(String s) {
    log.debug(s);
  }

  @Override
  public void trace(String s) {
    log.trace(s);
  }

  @Override
  public void warn(String s) {
    log.warn(s);
  }

}
