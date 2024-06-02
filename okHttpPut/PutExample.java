import okhttp3.*;

import java.io.IOException;

public class PutExample {
    // Create an instance of OkHttpClient to handle HTTP requests.
    final OkHttpClient client = new OkHttpClient();

    /**
     * Method to perform a PUT request.
     *
     * @param url  The URL to send the PUT request to.
     * @param json The JSON data to be sent in the request body.
     * @return The response from the server.
     * @throws IOException If an input or output exception occurs.
     */
    Response put(String url, String json) throws IOException {
        // Create the request body with the JSON content and the MediaType.
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));

        // Build the PUT request with the specified URL and request body.
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();

        // Execute the request and get the response.
        Response response = client.newCall(request).execute();
        
        // You can perform any additional processing on the response here if needed
        
        // Return the response.
        return response;
    }

    /**
     * Main method to run the example.
     *
     * @param args Command line arguments.
     * @throws IOException If an input or output exception occurs.
     */
    public static void main(String[] args) throws IOException {
        // Create an instance of the PutExample class.
        PutExample example = new PutExample();

        // Define the JSON content as a string.
        String json = "{\"name\":\"red\", \"data\": {\"key1\":\"dummy data\"}}";

        // Send a PUT request to the specified URL with the JSON data.
        Response response = example.put("https://api.restful-api.dev/objects/ff8081818fb998eb018fd39f53f12ca2", json);

        // Print the status code of the response.
        System.out.println("Status Code: " + response.code());

        // Print the response body.
        System.out.println("Response Body: " + response.body().string());

        // Close the response to release resources.
        response.close();
    }
}
