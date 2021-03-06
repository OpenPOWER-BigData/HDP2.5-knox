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
package org.apache.hadoop.gateway.services.security;

import java.nio.ByteBuffer;

public class EncryptionResult {
  public byte[] salt;
  public byte[] iv;
  public byte[] cipher;
  
  public EncryptionResult() {
    
  }
  
  public EncryptionResult(byte[] salt, byte[] iv, byte[] cipher) {
    this.salt = salt;
    this.iv = iv;
    this.cipher = cipher;
  }
  
  public byte[] toByteAray() {
    int headerLength = 12;
    ByteBuffer bb = ByteBuffer.allocate(salt.length + iv.length + cipher.length + headerLength);
    bb.putInt(salt.length)
      .putInt(iv.length)
      .putInt(cipher.length)
      .put(salt)
      .put(iv)
      .put(cipher);
    bb.flip();
    
    return bb.array();
  }
  
  public static EncryptionResult fromByteArray(byte[] array) {
    EncryptionResult result = new EncryptionResult();
    
    ByteBuffer bb = ByteBuffer.wrap(array);
    
    int saltSize = bb.getInt();
    int ivSize = bb.getInt();
    int cipherSize = bb.getInt();

    result.salt = new byte[saltSize];
    result.iv = new byte[ivSize];
    result.cipher = new byte[cipherSize];
    
    bb.get(result.salt);
    bb.get(result.iv);
    bb.get(result.cipher);
    
    return result;
  }
}
