/*
 * Druid - a distributed column store.
 * Copyright 2012 - 2015 Metamarkets Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.druid.query.search.search;

import java.util.Comparator;

/**
 */
public class StrlenSearchSortSpec implements SearchSortSpec
{
  public StrlenSearchSortSpec()
  {
  }

  @Override
  public Comparator<SearchHit> getComparator()
  {
    return new Comparator<SearchHit>() {
      @Override
      public int compare(SearchHit s, SearchHit s1)
      {
        int res = s.getValue().length() - s1.getValue().length();
        if (res == 0) {
          return (s.getValue().compareTo(s1.getValue()));
        }
        return res;
      }
    };
  }

  public String toString()
  {
    return "stringLengthSort";
  }
}
