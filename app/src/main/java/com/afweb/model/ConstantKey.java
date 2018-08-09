/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afweb.model;

/**
 *
 * @author eddy
 */
public class ConstantKey {

    public static final String VERSION = "ver-1.0";
    public static final int STOCK_LOCKTYPE = 0;
    public static final int STOCK_UPDATE_LOCKTYPE = 5;
    public static final int ACC_LOCKTYPE = 10;
    public static final int TR_LOCKTYPE = 20;
    public static final int SRV_LOCKTYPE = 30;
    public static final int SIGNAL_LOCKTYPE = 40;

    public static final String MSG_OPEN = "ENABLE";
    public static final int OPEN = 0;

    public static final String MSG_CLOSE = "CLOSE";
    public static final int CLOSE = 1;

    public static final String MSG_ENABLE = "ENABLE";
    public static final int ENABLE = 0;

    public static final String MSG_DISABLE = "DISABLE";
    public static final int DISABLE = 1;

    public static final String MSG_NO_ACTIVE = "NO_ACTIVATE";
    public static final int NOACT = 4;

/////// SubStatus        
    public static final String MSG_NEW = "NEW";
    public static final int NEW = 1;

    public static final String MSG_EXISTED = "EXISTED";
    public static final int EXISTED = 2;

    public static final String MSG_INITIAL = "INITIAL";
    public static final int INITIAL = 2;

//// Android configuration    
//// project001    
    public static final String IIS_WEB_BASE_URL = "http://web-project001.7e14.starter-us-west-2.openshiftapps.com/web";
}
