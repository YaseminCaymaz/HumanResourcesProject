package org.example.constants;

public class RestApiUrls {



    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";

    private static final String ROOT = DEV + VERSION;

    public static final String EMPLOYEE = ROOT + "/employee";
    public static final String DEBIT = ROOT + "/debit";
    public static final String EXPENSE = ROOT + "/expense";

    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";
    public static final String ADD = "/add";
    public static final String GETBYID = "/getbyid";
    public static final String GETALL = "/getall";
    public static final String GETALLBYEMPLOYEEID = "/getallbyemployeeid";
    public static final String GETALLBYCOMPANYID = "/getallbycompanyid";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";



}
