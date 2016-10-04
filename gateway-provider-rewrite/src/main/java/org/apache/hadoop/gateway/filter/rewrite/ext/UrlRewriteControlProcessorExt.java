/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.gateway.filter.rewrite.ext;

import org.apache.hadoop.gateway.filter.rewrite.api.UrlRewriteEnvironment;
import org.apache.hadoop.gateway.filter.rewrite.spi.UrlRewriteContext;
import org.apache.hadoop.gateway.filter.rewrite.spi.UrlRewriteStepProcessor;
import org.apache.hadoop.gateway.filter.rewrite.spi.UrlRewriteStepStatus;

public class UrlRewriteControlProcessorExt implements UrlRewriteStepProcessor<UrlRewriteControlDescriptor> {

  @Override
  public String getType() {
    return "control";
  }

  @Override
  public void initialize( UrlRewriteEnvironment environment, UrlRewriteControlDescriptor descriptor ) throws Exception {
  }

  @Override
  public UrlRewriteStepStatus process( UrlRewriteContext context ) throws Exception {
    return UrlRewriteStepStatus.FAILURE;
  }

  @Override
  public void destroy() {
  }
}
