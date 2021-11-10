package com.aires.utilities;

import java.io.IOException;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GoogleMatrixRequest {
	private static final String API_KEY = "AIzaSyBcrplyfn3-GRhNyc_Msr9oMpyOS_MVSCk";

	OkHttpClient client = new OkHttpClient();

	public String run(String url) throws IOException {
		Request request = new Request.Builder()
	        .url(url)
	        .build();

	    Response response = client.newCall(request).execute();
	    return response.body().string();
	}
	public static void main(String[] args) throws IOException {
	    GoogleMatrixRequest request = new GoogleMatrixRequest();
	    String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC%7CSeattle&destinations=San+Francisco%7CVictoria+BC&language=en&key=" + API_KEY;

	    String response = request.run(url_request);
	    System.out.println(response);
	    
	    JSONObject jsonRespRouteDistance = new JSONObject(response)
                .getJSONArray("rows")
                .getJSONObject(0)
                .getJSONArray ("elements")
                .getJSONObject(0)
                .getJSONObject("distance");

	    String distance = jsonRespRouteDistance.get("text").toString();
	    String destination_addr = new JSONObject(response)
                .get("destination_addresses")
                .toString();

	    System.out.println("distance=="+distance);
	    System.out.println("destination_addr=="+destination_addr);


	}
	
}
