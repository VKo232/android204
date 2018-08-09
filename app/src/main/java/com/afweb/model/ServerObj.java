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
public class ServerObj {

    private String serverName;
    private String srvProjName;
    private String verString;
    private String lastServUpdateESTdate;
    private long lastServUpdateTimer;
    private String timerMsg;
    private String timerThreadMsg;

    private boolean LocalDBservice;
    private boolean sysMaintenance;

    private int timerCnt;
    private int timerQueueCnt;
    private boolean timerInit;

    private int totalStockAcc;
    private int totalStock;

    private int cntRESTrequest;
    private int cndRESTexception;

    private int cntInterRequest;
    private int cndInterException;

    public ServerObj() {
        serverName = "Server";
        srvProjName = "projedt";
        lastServUpdateESTdate = "";
        timerCnt = 0;
        timerQueueCnt = 0;
        timerMsg = "";
        timerInit = false;
        lastServUpdateTimer = 0;
        timerThreadMsg = "";
        LocalDBservice = true;
        sysMaintenance = false;
        verString = ConstantKey.VERSION;

        totalStockAcc = 0;
        totalStock = 0;

        cntRESTrequest = 0;
        cndRESTexception = 0;
        cntInterRequest = 0;
        cndInterException = 0;

    }

    /**
     * @return the ServerName
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * @param ServerName the ServerName to set
     */
    public void setServerName(String ServerName) {
        this.serverName = ServerName;
    }

    /**
     * @return the SrvProjName
     */
    public String getSrvProjName() {
        return srvProjName;
    }

    /**
     * @param SrvProjName the SrvProjName to set
     */
    public void setSrvProjName(String SrvProjName) {
        this.srvProjName = SrvProjName;
    }

    /**
     * @return the verString
     */
    public String getVerString() {
        return verString;
    }

    /**
     * @param verString the verString to set
     */
    public void setVerString(String verString) {
        this.verString = verString;
    }

    /**
     * @return the lastServUpdateESTdate
     */
    public String getLastServUpdateESTdate() {
        return lastServUpdateESTdate;
    }

    /**
     * @param lastServUpdateESTdate the lastServUpdateESTdate to set
     */
    public void setLastServUpdateESTdate(String lastServUpdateESTdate) {
        this.lastServUpdateESTdate = lastServUpdateESTdate;
    }

    /**
     * @return the lastServUpdateTimer
     */
    public long getLastServUpdateTimer() {
        return lastServUpdateTimer;
    }

    /**
     * @param lastServUpdateTimer the lastServUpdateTimer to set
     */
    public void setLastServUpdateTimer(long lastServUpdateTimer) {
        this.lastServUpdateTimer = lastServUpdateTimer;
    }

    /**
     * @return the timerMsg
     */
    public String getTimerMsg() {
        return timerMsg;
    }

    /**
     * @param timerMsg the timerMsg to set
     */
    public void setTimerMsg(String timerMsg) {
        this.timerMsg = timerMsg;
    }

    /**
     * @return the timerThreadMsg
     */
    public String getTimerThreadMsg() {
        return timerThreadMsg;
    }

    /**
     * @param timerThreadMsg the timerThreadMsg to set
     */
    public void setTimerThreadMsg(String timerThreadMsg) {
        this.timerThreadMsg = timerThreadMsg;
    }

    /**
     * @return the LocalDBservice
     */
    public boolean isLocalDBservice() {
        return LocalDBservice;
    }

    /**
     * @param LocalDBservice the LocalDBservice to set
     */
    public void setLocalDBservice(boolean LocalDBservice) {
        this.LocalDBservice = LocalDBservice;
    }

    /**
     * @return the sysMaintenance
     */
    public boolean isSysMaintenance() {
        return sysMaintenance;
    }

    /**
     * @param sysMaintenance the sysMaintenance to set
     */
    public void setSysMaintenance(boolean sysMaintenance) {
        this.sysMaintenance = sysMaintenance;
    }

    /**
     * @return the timerCnt
     */
    public int getTimerCnt() {
        return timerCnt;
    }

    /**
     * @param timerCnt the timerCnt to set
     */
    public void setTimerCnt(int timerCnt) {
        this.timerCnt = timerCnt;
    }

    /**
     * @return the timerQueueCnt
     */
    public int getTimerQueueCnt() {
        return timerQueueCnt;
    }

    /**
     * @param timerQueueCnt the timerQueueCnt to set
     */
    public void setTimerQueueCnt(int timerQueueCnt) {
        this.timerQueueCnt = timerQueueCnt;
    }

    /**
     * @return the timerInit
     */
    public boolean isTimerInit() {
        return timerInit;
    }

    /**
     * @param timerInit the timerInit to set
     */
    public void setTimerInit(boolean timerInit) {
        this.timerInit = timerInit;
    }

    /**
     * @return the totalStockAcc
     */
    public int getTotalStockAcc() {
        return totalStockAcc;
    }

    /**
     * @param totalStockAcc the totalStockAcc to set
     */
    public void setTotalStockAcc(int totalStockAcc) {
        this.totalStockAcc = totalStockAcc;
    }

    /**
     * @return the totalStock
     */
    public int getTotalStock() {
        return totalStock;
    }

    /**
     * @param totalStock the totalStock to set
     */
    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    /**
     * @return the RESTrequestCnt
     */
    public int getRESTrequestCnt() {
        return cntRESTrequest;
    }

    /**
     * @param RESTrequestCnt the RESTrequestCnt to set
     */
    public void setRESTrequestCnt(int RESTrequestCnt) {
        this.cntRESTrequest = RESTrequestCnt;
    }

    /**
     * @return the RESTexceptionCnt
     */
    public int getRESTexceptionCnt() {
        return cndRESTexception;
    }

    /**
     * @param RESTexceptionCnt the RESTexceptionCnt to set
     */
    public void setRESTexceptionCnt(int RESTexceptionCnt) {
        this.cndRESTexception = RESTexceptionCnt;
    }

    /**
     * @return the InterRequestCnt
     */
    public int getInterRequestCnt() {
        return cntInterRequest;
    }

    /**
     * @param InterRequestCnt the InterRequestCnt to set
     */
    public void setInterRequestCnt(int InterRequestCnt) {
        this.cntInterRequest = InterRequestCnt;
    }

    /**
     * @return the InterExceptionCnt
     */
    public int getInterExceptionCnt() {
        return cndInterException;
    }

    /**
     * @param InterExceptionCnt the InterExceptionCnt to set
     */
    public void setInterExceptionCnt(int InterExceptionCnt) {
        this.cndInterException = InterExceptionCnt;
    }
}
