package org.apache.lucene.queryParser.original.builders;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.lucene.messages.MessageImpl;
import org.apache.lucene.queryParser.core.QueryNodeException;
import org.apache.lucene.queryParser.core.messages.QueryParserMessages;
import org.apache.lucene.queryParser.core.nodes.MatchNoDocsQueryNode;
import org.apache.lucene.queryParser.core.nodes.QueryNode;
import org.apache.lucene.queryParser.original.parser.EscapeQuerySyntaxImpl;
import org.apache.lucene.search.BooleanQuery;

/**
 * Builds an empty {@link BooleanQuery} object from a
 * {@link MatchNoDocsQueryNode} object.
 */
public class MatchNoDocsQueryNodeBuilder implements OriginalQueryBuilder {

  public MatchNoDocsQueryNodeBuilder() {
    // empty constructor
  }

  public BooleanQuery build(QueryNode queryNode) throws QueryNodeException {

    // validates node
    if (!(queryNode instanceof MatchNoDocsQueryNode)) {
      throw new QueryNodeException(new MessageImpl(
          QueryParserMessages.LUCENE_QUERY_CONVERSION_ERROR, queryNode
              .toQueryString(new EscapeQuerySyntaxImpl()), queryNode.getClass()
              .getName()));
    }

    return new BooleanQuery();

  }

}
