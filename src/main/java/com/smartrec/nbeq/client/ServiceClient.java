package com.smartrec.nbeq.client;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartrec.nbeq.exception.ServiceClientException;
import com.smartrec.nbeq.utils.JsonConverter;

/**
 * @author RajaBoppana
 * Abstract class to implement service calls with standard methods
 *
 */
public abstract class ServiceClient {

    private static final Logger LOGGER = LogManager.getLogger();

    public <T> T get(String uri, Class<T> responseClass) throws ServiceClientException {
    	
    	LOGGER.debug("URI: " + uri);
    	
        HttpUriRequest request = new HttpGet(uri);
        
        //REST API CALL
        HttpResponse response = executeRequest(request);
        
        //Convert HTTP response to String
        String content = getContent(response);
        
        JsonConverter jsonConverter = new JsonConverter(new ObjectMapper());
        LOGGER.debug("RESPONSE STATUS: " + response.getStatusLine() + "\nCONTENT: " + jsonConverter.prettifyPrintJson(content));
        
        //convert string content 
        return jsonConverter.jsonToObject(content, responseClass);
    }

    private String getContent(HttpResponse response) throws ServiceClientException {
        try {
        	BasicResponseHandler basicResponseHandler = new BasicResponseHandler();
            return basicResponseHandler.handleResponse(response);
        } catch (IOException e) {
            LOGGER.error(e);
            throw new ServiceClientException("Unable to get response content");
        }
    }

    private HttpResponse executeRequest(HttpUriRequest request) throws ServiceClientException {
        try {
        	HttpClient httpclient = HttpClients.createDefault();
            return httpclient.execute(request);
        } catch (IOException e) {
            LOGGER.error(e);
            throw new ServiceClientException("Unable to execute request");
        }
    }
}
