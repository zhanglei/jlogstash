/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dtstack.jlogstash.metrics.groups;

import com.dtstack.jlogstash.metrics.MetricRegistry;

public class GenericMetricGroup extends AbstractMetricGroup<AbstractMetricGroup<?>> {

	/** The name of this group. */
	private String name;

	public GenericMetricGroup(MetricRegistry registry, AbstractMetricGroup parent, String name) {
		super(registry, makeScopeComponents(parent, name), parent);
		this.name = name;
	}

	// ------------------------------------------------------------------------

	private static String[] makeScopeComponents(AbstractMetricGroup parent, String name) {
		if (parent != null) {
			String[] parentComponents = parent.getScopeComponents();
			if (parentComponents != null && parentComponents.length > 0) {
				String[] parts = new String[parentComponents.length + 1];
				System.arraycopy(parentComponents, 0, parts, 0, parentComponents.length);
				parts[parts.length - 1] = name;
				return parts;
			}
		}
		return new String[] { name };
	}

	@Override
	protected String getGroupName() {
		return name;
	}
}
