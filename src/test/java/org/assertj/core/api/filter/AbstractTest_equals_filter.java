/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.core.api.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.assertj.core.api.filter.Filters.filter;

import org.assertj.core.test.Player;
import org.assertj.core.util.introspection.IntrospectionError;
import org.junit.Test;


public abstract class AbstractTest_equals_filter extends AbstractTest_filter {

  @Test
  public void should_filter_iterable_elements_with_property_equals_to_given_value() {
    Iterable<Player> bullsPlayers = filterIterable(players, "team", "Chicago Bulls");
    assertThat(bullsPlayers).containsOnly(rose, noah);
    // players is not modified
    assertThat(players).hasSize(4);

    Iterable<Player> filteredPlayers = filter(players).with("name.last", "James").get();
    assertThat(filteredPlayers).containsOnly(james);
    // players is not modified
    assertThat(players).hasSize(4);
  }

  @Test
  public void should_filter_iterable_elements_with_field_equals_to_given_value() {
    Iterable<Player> bullsPlayers = filterIterable(players, "highestScore", 50);
    assertThat(bullsPlayers).containsOnly(rose, james);
    // players is not modified
    assertThat(players).hasSize(4);
  }

  protected abstract Iterable<Player> filterIterable(Iterable<Player> players, String propertyName, Object propertyValue);

  @Test
  public void should_fail_if_property_to_filter_on_is_null() {
    try {
      filterIterable(players, null, 6000L);
      failBecauseExceptionWasNotThrown(IllegalArgumentException.class);
    } catch (IllegalArgumentException e) {
      assertThat(e).hasMessage("The property/field name to filter on should not be null or empty");
    }
  }

  @Test
  public void should_fail_if_elements_to_filter_do_not_have_property_used_by_filter() {
    try {
      filterIterable(players, "country", "France");
      fail("IntrospectionError expected");
    } catch (IntrospectionError e) {
      assertThat(e).hasMessageContaining("Can't find any field or property with name 'country'");
    }
  }

}