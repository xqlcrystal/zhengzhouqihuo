package com.crystal.parse;

import com.crystal.domain.FutureDataTradeamtDailyData;

import java.io.*;

public class FutureDataTradeamtParse {


    public static FutureDataTradeamtDailyData txt2String(String filename){
        FutureDataTradeamtDailyData futureDataTradeamtDailyData=null;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"GBK"));//构造一个BufferedReader类来读取文件
            String s = null;

            int i=0;

            futureDataTradeamtDailyData=new FutureDataTradeamtDailyData();
            int colnums=0;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                if(i==0){
                   futureDataTradeamtDailyData.setTitleline(s.trim());
                }else if(i==1){
                    String[] headers=s.split("\\|");
                    colnums=headers.length;
                  futureDataTradeamtDailyData.setHeadline(headers);
                }else {

                    if(s.contains("总计")){
                        break;
                    }
                    String[] datas=s.split("\\|");

                    if(datas.length!=colnums){
                        break;
                    }
                    for (int j=0;j<datas.length;j++ ) {
                        datas[j]=datas[j].trim();
                    }
                    futureDataTradeamtDailyData.addDataLine(datas);
                }

                i++;
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
       return futureDataTradeamtDailyData;
    }
}
