package org.example.constants;

public class RestApiUrls {
    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";
    private static final String ROOT = DEV + VERSION;

    public static final String COMPANY = ROOT + "/company";
    public static final String MANAGER = ROOT + "/manager";

    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";

    public static final String UPDATE = "/update";


    public static final String ACTIVATE_STATUS = "/activate-status/{authId}";

    public static final String REJECT_STATUS = "/reject-status/{authId}";



}

