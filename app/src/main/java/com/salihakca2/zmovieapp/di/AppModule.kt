package com.salihakca2.zmovieapp.di

import android.content.Context
import android.content.SharedPreferences
import com.salihakca2.zmovieapp.data.repo.MovieDaoRepository
import com.salihakca2.zmovieapp.prefs.Constants
import com.salihakca2.zmovieapp.prefs.SessionManager
import com.salihakca2.zmovieapp.retrofit.ApiUtils
import com.salihakca2.zmovieapp.retrofit.MoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context) =
        context.getSharedPreferences(Constants.PREF_NAME,Context.MODE_PRIVATE)
    @Provides
    @Singleton
    fun provideSessionManager(preferences: SharedPreferences) = SessionManager(preferences)

    @Provides
    @Singleton
    fun provideMovieDaoRepository(mdao: MoviesDao): MovieDaoRepository{
        return MovieDaoRepository(mdao)
    }

    @Provides
    @Singleton
    fun provideMovieDao():MoviesDao{
        return  ApiUtils.getMoviesDao()
    }
}