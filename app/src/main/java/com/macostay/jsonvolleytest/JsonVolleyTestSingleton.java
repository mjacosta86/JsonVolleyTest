package com.macostay.jsonvolleytest;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by macostay on 28/10/2015.
 */

public final class JsonVolleyTestSingleton {
    // Atributos
    private static JsonVolleyTestSingleton singleton;
    private RequestQueue requestQueue;
    private static Context context;
    private ImageLoader imageLoader;

    private JsonVolleyTestSingleton(Context context) {
        JsonVolleyTestSingleton.context = context;
        requestQueue = getRequestQueue();

        imageLoader = new ImageLoader(requestQueue,new ImageLoader.ImageCache()
        {
            private final LruCache<String, Bitmap> cache = new LruCache<>(20);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });
    }

    public static synchronized JsonVolleyTestSingleton getInstance(Context context) {
        if (singleton == null) {
            singleton = new JsonVolleyTestSingleton(context);
        }
        return singleton;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public  void addToRequestQueue(Request req) {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
