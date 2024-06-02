import okhttp3.*;

import java.io.IOException;

public class DeleteExample {
    // Create an instance of OkHttpClient to handle HTTP requests.
    final OkHttpClient client = new OkHttpClient();

    /**
     * Method to perform a DELETE request.
     *
     * @param url The URL to send the DELETE request to.
     * @return The response from the server.
     * @throws IOException If an input or output exception occurs.
     */
    Response delete(String url) throws IOException {
        // Build the DELETE request with the specified URL.
        Request request = new Request.Builder()
                .url(url)
                .delete()
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
        // Create an instance of the DeleteExample class.
        DeleteExample example = new DeleteExample();

        // Send a DELETE request to the specified URL.
        Response response = example.delete("https://api.restful-api.dev/objects/ff8081818fb998eb018fd39f53f12ca2");

        // Print the status code of the response.
        System.out.println("Status Code: " + response.code());

        // Print the response body.
        System.out.println("Response Body: " + response.body().string());

        // Close the response to release resources.
        response.close();
    }
}
