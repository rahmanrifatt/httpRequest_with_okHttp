import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetExample {
    // Create an instance of OkHttpClient to handle HTTP requests.
    final OkHttpClient client = new OkHttpClient();

    /**
     * Method to perform a GET request.
     * @param url The URL to send the GET request to.
     * @return The response from the server as a Response object.
     * @throws IOException If an input or output exception occurs.
     */
    Response run(String url) throws IOException {
        // Create a new request with the provided URL.
        // Request.Builder() is used to construct the request.
        Request request = new Request.Builder()
            .url(url)  // Set the URL for the request.
            .build();  // Build the request.

        // Execute the request and get the response.
        // client.newCall(request).execute() sends the request and returns the response.
        Response response = client.newCall(request).execute();
        
        // Check if the response is successful (HTTP status code 200-299).
        if (!response.isSuccessful()) {
            // If the response is not successful, print the HTTP status code and message.
            System.out.println("HTTP Status Code: " + response.code());
            System.out.println("HTTP Status Message: " + response.message());
        }
        
        // Return the response object.
        return response;
    }

    /**
     * Main method to run the example.
     * @param args Command line arguments.
     * @throws IOException If an input or output exception occurs.
     */
    public static void main(String[] args) throws IOException {
        // Create an instance of the GetExample class.
        GetExample example = new GetExample();
        
        // Send a GET request to the specified URL and print the response code, message, and body.
        Response response = example.run("https://api.restful-api.dev/objects/7");
        System.out.println("Response Code: " + response.code());
        System.out.println("Response Message: " + response.message());
        System.out.println("Response Body: " + response.body().string());
    }
}
