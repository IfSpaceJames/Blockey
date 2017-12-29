package org.ifspace.blockey.feature;

import java.util.Map;
import fi.iki.elonen.NanoHTTPD;

/**
 * Created by jkfeg on 12/27/2017.
 */

public class AndroidWebServer extends NanoHTTPD {

    public AndroidWebServer(int port) {
        super(port);
    }

    public AndroidWebServer(String hostname, int port) {
        super(hostname, port);
    }
    private String id = "11397100";

    public void setScratchProgId(String id)
    {
        this.id = id;
    }
    @Override
    public Response serve(IHTTPSession session) {
        String msg = "<html><body><h1>Joseph's Scratch Launcher</h1>\n";
        msg += "<script src='https://sulfurous.aau.at/js/embed.js?id=";
        msg += id;
        msg += "&resolution-x=480&resolution-y=360&auto-start=true&light-content=false'></script>";
        return newFixedLengthResponse( msg + "</body></html>\n" );
    }
    //...
}
