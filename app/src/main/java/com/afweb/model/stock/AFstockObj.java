/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afweb.model.stock;

import com.vpumlmodel.stock.stock;


/**
 *
 * @author eddy
 */
public class AFstockObj extends stock {
    	private AFstockInfo stockInfo;
        
        private  String updateDateD="";
    /**
     * @return the stockInfo
     */
    public AFstockInfo getStockInfo() {
        return stockInfo;
    }

    /**
     * @param stockInfo the stockInfo to set
     */
    public void setStockInfo(AFstockInfo stockInfo) {
        this.stockInfo = stockInfo;
    }

    /**
     * @return the updateDateD
     */
    public String getUpdateDateD() {
        return updateDateD;
    }

    /**
     * @param updateDateD the updateDateD to set
     */
    public void setUpdateDateD(String updateDateD) {
        this.updateDateD = updateDateD;
    }
}
