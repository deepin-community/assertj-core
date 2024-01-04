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
package org.assertj.core.api.shortarray;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Comparator;


import org.assertj.core.api.ShortArrayAssert;
import org.assertj.core.api.ShortArrayAssertBaseTest;
import org.assertj.core.internal.Objects;
import org.assertj.core.internal.ShortArrays;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

/**
 * Tests for <code>{@link ShortArrayAssert#usingDefaultElementComparator()}</code>.
 * 
 * @author Joel Costigliola
 * @author Mikhail Mazursky
 */
public class ShortArrayAssert_usingDefaultElementComparator_Test extends ShortArrayAssertBaseTest {

  @Mock
  private Comparator<Short> comparator;

  private Objects objectsBefore;

  @BeforeEach
  public void before() {
    initMocks(this);
    objectsBefore = getObjects(assertions);
    assertions.usingElementComparator(comparator);
  }

  @Override
  protected ShortArrayAssert invoke_api_method() {
    return assertions.usingDefaultElementComparator();
  }

  @Override
  protected void verify_internal_effects() {
    assertThat(objectsBefore).isSameAs(getObjects(assertions));
    assertThat(ShortArrays.instance()).isSameAs(getArrays(assertions));
  }
}
