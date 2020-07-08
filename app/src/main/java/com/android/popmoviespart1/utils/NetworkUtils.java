package com.android.popmoviespart1.utils;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * These utilities will be used to communicate with the network.
 */
public class NetworkUtils {

    final static String TMDB_BASE_URL =
            "https://api.themoviedb.org/3/movie/";
   // https://api.themoviedb.org/3/movie/top_rated?api_key=c3eaf6cb11bd72a39264bbb0d43ba7b9&

    final static String TOP_URL = "top_rated";
    final static String POP_URL = "popular";

    final static String API_KEY = "c3eaf6cb11bd72a39264bbb0d43ba7b9" ;
    final static String PARAM_QUERY = "api_key";

    final static String IMAGE_BASE_URL = "https://image.tmdb.org/t/p";
    final static String IMAGE_SIZE = "w185";

    /**
     * Builds one URL used to query TMDB.
     *
     * @return The URL to use to query the TMDB server.
     */
    public static URL buildPopUrl() {
        Uri builtUri = Uri.parse(TMDB_BASE_URL).buildUpon()
                .appendPath(POP_URL)
                .appendQueryParameter(PARAM_QUERY, API_KEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    //Building the Top Rated Movies URL QUERY
    public static URL buildTopUrl() {
        Uri builtUri = Uri.parse(TMDB_BASE_URL).buildUpon()
                .appendPath(TOP_URL)
                .appendQueryParameter(PARAM_QUERY, API_KEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }


    //This method returns the entire result from the HTTP response.
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    //Build the query to get the Movie Poster
    public static URL buildImageUrl(String posterPath) {
        Uri builtUri = Uri.parse(IMAGE_BASE_URL).buildUpon()
                .appendPath(PARAM_QUERY)
                .appendPath(IMAGE_SIZE)
                .appendPath(posterPath)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }
}