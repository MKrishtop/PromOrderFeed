package com.mikhailkrishtop.promorderfeed;

import com.mikhailkrishtop.promorderfeed.data.api.PromApi;
import com.mikhailkrishtop.promorderfeed.data.api.PromApiImpl;

import org.simpleframework.xml.Serializer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.converter.SimpleXMLConverter;

/**
 * Created by mykhailo on 4/4/15.
 */
@Module(
        injects = {
        }
)
public final class AppModule {

    public static final String SANDBOX_ENDPOINT_URL = "https://my.prom.ua";

    @Provides @Singleton
    PromApi providePromApi(PromApiImpl promApi) {
        return promApi;
    }

    @Provides @Singleton
    public RestAdapter.Builder provideRestAdapterBuilder(
            Endpoint endpoint, RestAdapter.LogLevel logLevel) {
        return new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setLogLevel(logLevel)
                .setConverter(new SimpleXMLConverter());
    }

    @Provides @Singleton
    public Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(SANDBOX_ENDPOINT_URL);
    }

    @Provides @Singleton
    public RestAdapter.LogLevel provideCustomSearchLogLevel() {
        return RestAdapter.LogLevel.NONE;
    }

//    @Provides @Singleton
//    SharedPreferences provideSharedPreferences() {
//        return App.inst.getSharedPreferences("appPrefs", MODE_PRIVATE);
//    }

}
