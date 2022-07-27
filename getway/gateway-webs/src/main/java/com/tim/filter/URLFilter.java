package com.tim.filter;

public class URLFilter {
    private static final String allurl="/user/login,/api/user/add";
    public static boolean hasAuthorize(String url){
        String[] urls=allurl.split(",");
        for (String uri: urls){
            if(url.equals(uri)){
                return false;
            }
        }
        return true;
    }
}
