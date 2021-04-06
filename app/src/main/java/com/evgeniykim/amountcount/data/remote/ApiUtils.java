package com.evgeniykim.amountcount.data.remote;

public class ApiUtils {

    public static final String BASE_URL = "https://infra.devskills.app/";

    public static Service getService() {
        return RetrofitClient.getClient(BASE_URL).create(Service.class);
    }
}
