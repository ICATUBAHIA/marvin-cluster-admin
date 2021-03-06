/*
 * Copyright [2017] [B2W Digital]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.marvin.cluster.manager.executor

import akka.Done
import akka.actor.{ActorSystem, Props}
import akka.testkit.{EventFilter, ImplicitSender, TestKit}
import com.typesafe.config.ConfigFactory
import org.marvin.cluster.manager.executor.ExecutorManagerClient.GetMetadata
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class ExecutorManagerTest extends TestKit(
  ActorSystem("ExecutorManagerTest", ConfigFactory.parseString("""akka.loggers = ["akka.testkit.TestEventListener"]""")))
  with ImplicitSender with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "executor manager client actor" must {

    "send Done message" in {

      val executorManager = system.actorOf(Props(new ExecutorManagerClient()))

      executorManager ! GetMetadata
      expectMsg("Done")
      EventFilter.info("Service checked!")
    }
  }
}