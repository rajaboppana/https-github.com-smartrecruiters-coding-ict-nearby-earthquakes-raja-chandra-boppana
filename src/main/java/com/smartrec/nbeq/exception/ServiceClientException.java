package com.smartrec.nbeq.exception;


/**
 * @author RajaBoppana
 *
 */
public class ServiceClientException extends DataException {

	private static final long serialVersionUID = -5839797956624984112L;

	public ServiceClientException(String errorMessage) {
        super(errorMessage);
    }
}
