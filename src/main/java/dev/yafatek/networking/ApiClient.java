package dev.yafatek.networking;import com.squareup.moshi.JsonAdapter;import com.squareup.moshi.Moshi;import okhttp3.MediaType;import okhttp3.OkHttpClient;import okhttp3.Request;import okhttp3.Response;import java.io.IOException;import java.util.Objects;public final class ApiClient {	public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");	private static OkHttpClient client = new OkHttpClient();	private final Moshi moshi = new Moshi.Builder().build();	private final JsonAdapter<DemoApiResponse> gistJsonAdapter = moshi.adapter(DemoApiResponse.class);	public static String getData(String url) throws IOException {		Request request = new Request.Builder()				.url(url)				.build();		try (Response response = client.newCall(request).execute()) {			return Objects.requireNonNull(response.body()).toString();		}	}	public static void testGist() throws IOException {		ApiClient apiClient = new ApiClient();		Request request = new Request.Builder()				.url("https://misafir.app/api/v1/users/show_users")				.build();		try (Response response = client.newCall(request).execute()) {			if (!response.isSuccessful()) throw new IOException("Unexpected Code: " + response.code());			DemoApiResponse demoApiResponse = apiClient.gistJsonAdapter.fromJson(response.body().source());			System.out.println(demoApiResponse.getMessage());			System.out.println(demoApiResponse.isStatus());		}	}	private static Object postData() {		// Todo		// Create post method to post data to MicroService.		return null;	}}