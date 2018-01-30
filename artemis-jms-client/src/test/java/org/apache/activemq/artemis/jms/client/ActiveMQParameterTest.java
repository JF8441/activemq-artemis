/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.artemis.jms.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test Address queue parameters are correctly read.
 */
public class ActiveMQParameterTest {

   @Test
   public void testQueueParameters() {
      ActiveMQDestination activeMQDestination = new ActiveMQQueue("jms.queue.foo?exclusive=true");
      assertTrue(activeMQDestination.getQueueParameters().getExclusive());

      assertEquals("jms.queue.foo", activeMQDestination.getAddress());

      activeMQDestination = new ActiveMQQueue("jms.queue.foo?exclusive=false");
      assertFalse(activeMQDestination.getQueueParameters().getExclusive());

      activeMQDestination = new ActiveMQQueue("jms.queue.foo?last-value=true");
      assertTrue(activeMQDestination.getQueueParameters().getLastValue());

      activeMQDestination = new ActiveMQQueue("jms.queue.foo?last-value=false");
      assertFalse(activeMQDestination.getQueueParameters().getLastValue());
   }
}
