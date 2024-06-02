import okhttp3.*;

import java.io.IOException;

public class PatchExample {
    // Create an instance of OkHttpClient to handle HTTP requests.
    final OkHttpClient client = new OkHttpClient();

    /**
     * Method to perform a PATCH request.
     *
     * @param url  The URL to send the PATCH request to.
     * @param json The JSON data to be sent in the request body.
     * @return The response from the server.
     * @throws IOException If an input or output exception occurs.
     */
    Response patch(String url, String json) throws IOException {
        // Create the request body with the JSON content and the MediaType.
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));

        // Build the PATCH request with the specified URL and request body.
        Request request = new Request.Builder()
                .url(url)
                .patch(body)
                .build();

        // Execute the request and get the response.
        Response response = client.newCall(request).execute();

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
        // Create an instance of the PatchExample class.
        PatchExample example = new PatchExample();

        // Define the JSON content as a string.
        String json = "{\"name\":\"updatedName\"}";

        // Send a PATCH request to the specified URL with the JSON data.
        Response response = example.patch("https://api.restful-api.dev/objects/ff8081818fb998eb018fd3c1a1362caf", json);

        // Print the status code of the response.
        System.out.println("Status Code: " + response.code());

        // Print the response body.
        System.out.println("Response Body: " + response.body().string());

        // Close the response to release resources.
        response.close();
    }
}
