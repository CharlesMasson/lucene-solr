package org.apache.lucene.queryParser.original.processors;

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

import org.apache.lucene.queryParser.core.config.QueryConfigHandler;
import org.apache.lucene.queryParser.core.processors.NoChildOptimizationQueryNodeProcessor;
import org.apache.lucene.queryParser.core.processors.QueryNodeProcessorPipeline;
import org.apache.lucene.queryParser.core.processors.RemoveDeletedQueryNodesProcessor;
import org.apache.lucene.queryParser.original.builders.OriginalQueryTreeBuilder;
import org.apache.lucene.queryParser.original.config.OriginalQueryConfigHandler;
import org.apache.lucene.queryParser.original.parser.OriginalSyntaxParser;
import org.apache.lucene.search.Query;

/**
 * This pipeline has all the processors needed to process a query node tree,
 * generated by {@link OriginalSyntaxParser}, already assembled. <br/>
 * <br/>
 * The order they are assembled affects the results. <br/>
 * <br/>
 * This processor pipeline was designed to work with
 * {@link OriginalQueryConfigHandler}. <br/>
 * <br/>
 * The result query node tree can be used to build a {@link Query} object using
 * {@link OriginalQueryTreeBuilder}. <br/>
 * 
 * @see OriginalQueryTreeBuilder
 * @see OriginalQueryConfigHandler
 * @see OriginalSyntaxParser
 */
public class OriginalQueryNodeProcessorPipeline extends
    QueryNodeProcessorPipeline {

  public OriginalQueryNodeProcessorPipeline(QueryConfigHandler queryConfig) {
    super(queryConfig);

    addProcessor(new MultiFieldQueryNodeProcessor());
    addProcessor(new FuzzyQueryNodeProcessor());
    addProcessor(new MatchAllDocsQueryNodeProcessor());
    addProcessor(new LowercaseExpandedTermsQueryNodeProcessor());
    addProcessor(new ParametricRangeQueryNodeProcessor());
    addProcessor(new AllowLeadingWildcardProcessor());
    addProcessor(new PrefixWildcardQueryNodeProcessor());
    addProcessor(new AnalyzerQueryNodeProcessor());
    addProcessor(new PhraseSlopQueryNodeProcessor());
    addProcessor(new GroupQueryNodeProcessor());
    addProcessor(new NoChildOptimizationQueryNodeProcessor());
    addProcessor(new RemoveDeletedQueryNodesProcessor());
    addProcessor(new RemoveEmptyNonLeafQueryNodeProcessor());
    addProcessor(new BooleanSingleChildOptimizationQueryNodeProcessor());
    addProcessor(new DefaultPhraseSlopQueryNodeProcessor());
    addProcessor(new BoostQueryNodeProcessor());

  }

}
