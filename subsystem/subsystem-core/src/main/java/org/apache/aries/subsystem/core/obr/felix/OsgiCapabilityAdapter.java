/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.aries.subsystem.core.obr.felix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.felix.bundlerepository.Capability;
import org.apache.felix.bundlerepository.Property;
import org.osgi.framework.wiring.BundleRevision;

public class OsgiCapabilityAdapter implements Capability {
	private final org.osgi.framework.resource.Capability capability;
	
	public OsgiCapabilityAdapter(org.osgi.framework.resource.Capability capability) {
		if (capability == null)
			throw new NullPointerException("Missing required parameter: capability");
		this.capability = capability;
	}

	public String getName() {
		String namespace = capability.getNamespace();
		if (namespace.equals(BundleRevision.BUNDLE_NAMESPACE))
			return Capability.BUNDLE;
		if (namespace.equals(BundleRevision.HOST_NAMESPACE))
			return Capability.FRAGMENT;
		if (namespace.equals(BundleRevision.PACKAGE_NAMESPACE))
			return Capability.PACKAGE;
		return namespace;
	}

	public Property[] getProperties() {
		Map<String, Object> attributes = capability.getAttributes();
		Collection<Property> result = new ArrayList<Property>(attributes.size());
		for (final Map.Entry<String, Object> entry : capability.getAttributes().entrySet())
			result.add(new FelixProperty(entry));
		return result.toArray(new Property[result.size()]);
	}

	@SuppressWarnings("rawtypes")
	public Map getPropertiesAsMap() {
		return capability.getAttributes();
	}
}
