package dev.yafatek.networking;import okhttp3.MediaType;import okhttp3.OkHttpClient;import okhttp3.Request;import okhttp3.Response;import java.io.IOException;import java.util.Objects;public final class ApiClient {	public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");	private static OkHttpClient client = new OkHttpClient();	public static String getData(String url) throws IOException {		Request request = new Request.Builder()				.url(url)				.build();		try (Response response = client.newCall(request).execute()) {			return Objects.requireNonNull(response.body()).toString();		}	}	private static Object postData() {		// Todo		// Create post method to post data to MicroService.		return null;	}}