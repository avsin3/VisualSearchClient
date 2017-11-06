package com.visualsearch.ws.client.impl;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ApacheHttpClientPost {

	// http://localhost:8080/RESTfulExample/json/product/post
	public static void main(String[] args) throws UnsupportedEncodingException {try {

		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/VisualSearch/search/imageSearch/searchByImage");

		String input = "C:/Users/Public/Pictures/Sample Pictures/Penguins.jpg";

		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, input.getBytes());

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);

	  } catch (Exception e) {

		e.printStackTrace();

	  }

	}

}