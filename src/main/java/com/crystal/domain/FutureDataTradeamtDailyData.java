package com.crystal.domain;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FutureDataTradeamtDailyData {

    private String titleline;
    private String[] headline;

    private List<String[]> datalist=new ArrayList<String[]>();

    public String getTitleline() {
        return titleline;
    }

    public void setTitleline(String titleline) {
        this.titleline = titleline;
    }

    public String[] getHeadline() {
        return headline;
    }

    public void setHeadline(String[] headline) {
        this.headline = headline;
    }

    public List<String[]> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<String[]> datalist) {
        this.datalist = datalist;
    }

    public void addDataLine(String[] dataline){
        this.datalist.add(dataline);
    }

    public List<FutureDataTradeamt> ToEntityList() throws ParseException {

        Date curDate=null;
        List<FutureDataTradeamt> list=new ArrayList<FutureDataTradeamt>();
        if(titleline!=null && titleline.length()>0){
            int start=titleline.lastIndexOf("(")+1;
            int end=titleline.lastIndexOf(")");
            String strDate=titleline.substring(start,end);
            curDate= java.sql.Date.valueOf(strDate);
        }
        if(datalist!=null && datalist.size()>0){
            Map<String,String[]> volmap=new HashMap<String, String[]>();
            Map<String,String[]> amountmap=new HashMap<String, String[]>();
            for (String[] dataline:datalist
                 ) {
                String memberno_vol=dataline[1];
                String memberno_amount=dataline[5];
                volmap.put(memberno_vol,dataline);
                amountmap.put(memberno_amount,dataline);
            }

            for (String memberno:volmap.keySet()
                 ) {
                String[] voldata=volmap.get(memberno);
                String[] amountdata=amountmap.get(memberno);
                FutureDataTradeamt futureDataTradeamt=new FutureDataTradeamt();
                futureDataTradeamt.setRankingvol(Integer.parseInt(voldata[0]));
                futureDataTradeamt.setMemberno(memberno);
                futureDataTradeamt.setMembername(voldata[2]);
                futureDataTradeamt.setVol(new DecimalFormat().parse(voldata[3]).doubleValue());

                futureDataTradeamt.setRankingamount(Integer.parseInt(amountdata[4]));
                futureDataTradeamt.setAmount(new DecimalFormat().parse(amountdata[7]).doubleValue());
                futureDataTradeamt.setCurdate(curDate);
                list.add(futureDataTradeamt);
            }

        }
        return list;
    }
}
