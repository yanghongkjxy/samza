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

package org.apache.samza.message;

/**
 * The type of the intermediate stream message. The enum will be encoded using its ordinal value and
 * put in the first byte of the serialization of intermediate message.
 * For more details, see {@link org.apache.samza.serializers.IntermediateMessageSerde}
 */
public enum IntermediateMessageType {
  USER_MESSAGE,
  WATERMARK_MESSAGE,
  END_OF_STREAM_MESSAGE;

  /**
   * Returns the {@link IntermediateMessageType} of a particular intermediate stream message.
   * @param message an intermediate stream message
   * @return type of the message
   */
  public static IntermediateMessageType of(Object message) {
    if (message instanceof WatermarkMessage) {
      return WATERMARK_MESSAGE;
    } else if (message instanceof EndOfStreamMessage) {
      return END_OF_STREAM_MESSAGE;
    } else {
      return USER_MESSAGE;
    }
  }
}