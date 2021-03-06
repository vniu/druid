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

package io.druid.segment.column;

import io.druid.segment.data.Indexed;

import java.io.IOException;

/**
*/
public class IndexedComplexColumn implements ComplexColumn
{
  private final Indexed column;
  private final String typeName;

  public IndexedComplexColumn(
      String typeName, Indexed column
  )
  {
    this.column = column;
    this.typeName = typeName;
  }
  @Override
  public Class<?> getClazz()
  {
    return column.getClazz();
  }

  @Override
  public String getTypeName()
  {
    return typeName;
  }

  @Override
  public Object getRowValue(int rowNum)
  {
    return column.get(rowNum);
  }

  @Override
  public void close() throws IOException
  {
  }
}
