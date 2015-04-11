package com.mikhailkrishtop.promorderfeed;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by mykhailo on 4/4/15.
 */
@Module(
        addsTo = AppModule.class,
        overrides = true
)
public class DebugAppModule {

    @Provides @Singleton @Named("customsearch")
    public RestAdapter.LogLevel provideCustomSearchLogLevel() {
        return RestAdapter.LogLevel.FULL;
    }

}
