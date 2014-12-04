package org.cloudfoundry.community.servicebroker.service;

import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceBindingExistsException;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.model.ServiceInstanceBinding;

/**
 * Handles bindings to service instances.
 * 
 * @author sgreenberg@gopivotal.com
 */
public interface ServiceInstanceBindingService {

	/**
	 * Create a new binding to a service instance.
	 * @param bindingId The id provided by the cloud controller
	 * @param serviceInstance The id of the service instance
	 * @param serviceId The id of the service
	 * @param planId The plan used for this binding
	 * @param appGuid The guid of the app for the binding
	 * @return The newly created ServiceInstanceBinding
	 * @throws ServiceInstanceBindingExistsException if the same binding already exists
	 */
	ServiceInstanceBinding createServiceInstanceBinding(
			String bindingId, ServiceInstance serviceInstance, String serviceId, String planId, String appGuid)
			throws ServiceInstanceBindingExistsException, ServiceBrokerException;

	/**
	 * Delete the service instance binding.  If a binding doesn't exist, 
	 * return null.
     * @param bindingId The id provided by the cloud controller
     * @param instance The id of the service instance
     * @param serviceId The id of the service
     * @param planId The plan used for this binding
	 * @return The deleted ServiceInstanceBinding or null if one does not exist
	 */
	ServiceInstanceBinding deleteServiceInstanceBinding(String bindingId, ServiceInstance instance, String serviceId, String planId) 
	        throws ServiceBrokerException;
	
}
