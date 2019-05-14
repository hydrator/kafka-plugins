/*
 * Copyright © 2018 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.plugin.sink;

import com.google.common.hash.Hashing;
import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * String partitioner for kafka
 */
@SuppressWarnings("UnusedDeclaration")
public final class StringPartitioner implements Partitioner {

  public StringPartitioner(VerifiableProperties props) {

  }

  @Override
  public int partition(Object key, int numPartitions) {
    return Math.abs(Hashing.md5().hashString(key.toString()).asInt()) % numPartitions;
  }
}