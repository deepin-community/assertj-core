/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2019 the original author or authors.
 */
package org.assertj.core.api;

import static org.assertj.core.test.BooleanArrays.emptyArray;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for <code>{@link Assertions#assertThat(boolean[])}</code>.
 * 
 * @author Alex Ruiz
 */
public class Assertions_assertThat_with_BooleanArray_Test {

  @Test
  public void should_create_Assert() {
    AbstractBooleanArrayAssert<?> assertions = Assertions.assertThat(emptyArray());
    assertThat(assertions).isNotNull();
  }

  @Test
  public void should_pass_actual() {
    boolean[] actual = emptyArray();
    AbstractBooleanArrayAssert<?> assertions = Assertions.assertThat(actual);
    assertThat(assertions.actual).isSameAs(actual);
  }
}
