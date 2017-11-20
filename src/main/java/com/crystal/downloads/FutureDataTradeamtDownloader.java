package com.crystal.downloads;

import com.crystal.DownloadHelper;

import java.util.List;

public class FutureDataTradeamtDownloader {

    private String prepath="D:\\FutureDataTradeamt";
    private String prefilename="FutureDataTradeamt";

    //  private String[] dates={"20171106","20171107","20171108","20171109","20171110"};

    public void download(List<String> dates){
        for (String date:dates
             ) {
            String url=String.format("http://www.czce.com.cn/portal/DFSStaticFiles/Future/2017/%s/FutureDataTradeamt.txt",date);
//            String localfilename=prepath+"\\"+prefilename+"-"+date+".txt";
            String localfilename=String.format("%s\\%s-%s.txt",prepath,prefilename,date);
            DownloadHelper.downLoad(url,localfilename);
        }
    }
}
