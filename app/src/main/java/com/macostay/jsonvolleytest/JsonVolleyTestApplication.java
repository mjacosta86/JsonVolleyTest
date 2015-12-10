package com.macostay.jsonvolleytest;

import android.app.Application;

/**
 * Created by macostay on 15/10/2015.
 */
public class JsonVolleyTestApplication extends Application
{
    String url = "http://www.resultados-futbol.com/scripts/api/api.php?tz=";
    String key_pro = "65f8402127f4aae612732b4cb6089c22"; //Key buena pero caduca el 10/08/2015
    String key_free = "60888a5f28e66b62d6f29d7961be9ae8";
    String tz = "Europe/Madrid";
    String format = "json";
    String req; //nombre de la peticion
//    String url ="http://www.resultados-futbol.com/scripts/api/api.php?tz=" + app.getTimeZone()
//            + "&format=" + app.getFormat() + "&req=" + app.getRequire() + "&key=" + app.getKeyPro() + "&league=" + league
//            + "&year=" + getYear();

    //SETTERS
    public void setKeyPro(String k)
    {
        this.key_pro = k;
    }
    public void setKeyFree(String k)
    {
        this.key_free = k;
    }
    public void setTimeZone(String t)
    {
        this.tz = t;
    }
    public void setFormat(String f)
    {
        this.format = f;
    }
    public void setRequire(String r)
    {
        this.req = r;
    }
    public void setUrl(String url) {

        this.url = url;
    }

    //GETTERS
    public String getKeyPro()
    {
        return key_pro;
    }
    public String getKeyFree()
    {
        return key_free;
    }
    public String getTimeZone()
    {
        return tz;
    }
    public String getFormat()
    {
        return format;
    }
    public String getRequire()
    {
        return req;
    }
    public String getUrl() {

        return url;
    }

}
