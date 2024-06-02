import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class PostExample {

    // Define the MediaType for JSON using the get method.
    // MediaType represents the content type of the data being sent in the request.
    // "application/json; charset=utf-8" specifies that the data is in JSON format and encoded in UTF-8.
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    // Create an instance of OkHttpClient to handle the HTTP requests.
    final OkHttpClient client = new OkHttpClient();

    /**
     * Method to perform the POST request.
     * @param url The URL to send the POST request to.
     * @param json The JSON data to be sent in the request body.
     * @return The response from the server as a string.
     * @throws IOException If an input or output exception occurs.
     */
    String post(String url, String json) throws IOException {
        // Create the request body with the JSON content and the MediaType.
        // RequestBody.create() method takes the JSON string and the MediaType to create the body of the request.
        RequestBody body = RequestBody.create(json, JSON);
        
        // Build the request with the specified URL and request body.
        // The Request.Builder() is used to construct the request.
        Request request = new Request.Builder()
            .url(url)
            .post(body)
            .build();
        
        // Execute the request and get the response.
        // client.newCall(request).execute() sends the request and returns the response.
        try (Response response = client.newCall(request).execute()) {
            // Print the response code and message.
            System.out.println("Response Code: " + response.code());
            System.out.println("Response Message: " + response.message());

            // Print the response body as a string.
            String responseBody = response.body().string();
            System.out.println("Response Body: " + responseBody);

            // Optionally, parse the response body to get specific fields like ID.
            // Assuming the response body is a JSON object with an "id" field.
            // You can use a JSON library like Jackson or simple string manipulation to extract it.
            String id = extractIdFromResponse(responseBody);
            System.out.println("Response ID: " + id);
            
            return responseBody;
        }
    }

    // Method to extract ID from the response body.
    // This is a simple example assuming the ID is in a specific format.
    // You might need to use a proper JSON parsing library for complex JSON.
    String extractIdFromResponse(String responseBody) {
        // This example uses simple string manipulation to extract the "id" field.
        // For more robust parsing, consider using a JSON library like Jackson or Gson.
        String idKey = "\"id\":\"";
        int startIndex = responseBody.indexOf(idKey) + idKey.length();
        int endIndex = responseBody.indexOf("\"", startIndex);
        return responseBody.substring(startIndex, endIndex);
    }

    /**
     * Main method to run the example.
     * @param args Command line arguments.
     * @throws IOException If an input or output exception occurs.
     */
    public static void main(String[] args) throws IOException {
        // Create an instance of the PostExample class.
        PostExample example = new PostExample();
        
        // Define the JSON content as a string.
        // This is the data that will be sent in the POST request body.
        String json = "{\r\n" + //
                      "   \"name\": \"nokia\",\r\n" + //
                      "   \"data\": {\r\n" + //
                      "      \"year\": 2019,\r\n" + //
                      "      \"price\": 1849.99,\r\n" + //
                      "      \"CPU model\": \"Intel Core i9\",\r\n" + //
                      "      \"Hard disk size\": \"1 TB\"\r\n" + //
                      "   }\r\n" + //
                      "}";

        // Send the POST request and print the response.
        // The post method is called with the URL and JSON string as parameters.
        String response = example.post("https://api.restful-api.dev/objects", json);
        System.out.println("Response Body: " + response);
    }
}
