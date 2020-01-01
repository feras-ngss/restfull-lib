package dev.yafatek.apicalls;import dev.yafatek.apptests.RestModel;import retrofit2.Call;import retrofit2.Callback;import retrofit2.Response;import retrofit2.Retrofit;import retrofit2.converter.gson.GsonConverterFactory;import java.util.List;import java.util.logging.Logger;public final class ApiService {	private static Logger logger = Logger.getLogger(ApiService.class.getName());	private static String baseUrl = "http://localhost:8080/";	private static ApiOperations service;	private static Retrofit retrofit;	public static void initApiCalls() {		retrofit = new Retrofit.Builder()				.baseUrl(baseUrl)				.addConverterFactory(GsonConverterFactory.create())				.build();	}	public static void createService() {		service = retrofit.create(ApiOperations.class);	}	public static void retrieve() {		logger.info("in Retrieve...");		Call<List<RestModel>> call = service.getData("00905348854120");		call.enqueue(new Callback<List<RestModel>>() {			@Override			public void onResponse(Call<List<RestModel>> call, Response<List<RestModel>> response) {				logger.info("onResponse");				logger.info("Code: " + response.code());			}			@Override			public void onFailure(Call<List<RestModel>> call, Throwable t) {				logger.info("onFailure");				logger.info(t.getMessage());			}		});	}}