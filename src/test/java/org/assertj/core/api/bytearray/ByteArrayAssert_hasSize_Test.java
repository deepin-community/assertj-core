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
package org.assertj.core.api.bytearray;

import org.assertj.core.api.ByteArrayAssert;
import org.assertj.core.api.ByteArrayAssertBaseTest;

import static org.mockito.Mockito.verify;


/**
 * Tests for <code>{@link ByteArrayAssert#hasSize(int)}</code>.
 * 
 * @author Alex Ruiz
 */
public class ByteArrayAssert_hasSize_Test extends ByteArrayAssertBaseTest {

  @Override
  protected ByteArrayAssert invoke_api_method() {
    return assertions.hasSize(6);
  }

  @Override
  protected void verify_internal_effects() {
    verify(arrays).assertHasSize(getInfo(assertions), getActual(assertions), 6);
  }
}
