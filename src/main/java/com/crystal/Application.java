package com.crystal;

import com.crystal.domain.FutureDataTradeamt;
import com.crystal.domain.FutureDataTradeamtDailyData;
import com.crystal.parse.FutureDataTradeamtParse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Application
{
    public static void main( String[] args ) throws ParseException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");


/*        List<String> dates=getDates();
        FutureDataTradeamtDownloader futureDataTradeamtDownloader=new FutureDataTradeamtDownloader();
        futureDataTradeamtDownloader.downloadFutureDataTradeamt(dates);
        System.out.println( "Hello World!" );*/


/*        Date d = new Date("2017-01-01");
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE,1);*/


        //       downloadFutureDataTradeamt();

//        String filename = "D:\\FutureDataTradeamt\\FutureDataTradeamt-20171106.txt";
////       System.out.println(FutureDataTradeamtParse.txt2String(filename));
//        InsertFutureDataTradeamt(filename);

    }

    private static void downloadFutureDataTradeamt() throws ParseException {
        String pathname="D:\\FutureDataTradeamt\\";
        File path=new File(pathname);
        if(path.exists()){
            File[] files=path.listFiles();
            for (File file:files
                 ) {
               String filename=file.getName();
               String fullfilename=pathname+filename;
               InsertFutureDataTradeamt(fullfilename);
            }
        }
    }

    private static List<String> getDates() {
        Format f = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        Date today= c.getTime();
        int todaydaycount=c.get(Calendar.DAY_OF_YEAR);
        c.set(2017,0,1);
        Date firstday=c.getTime();
        int firstdaydays=c.get(Calendar.DAY_OF_YEAR);
        int count=todaydaycount-firstdaydays;

        List<String> dates=new ArrayList<String>();
        int i=0;
        while (i<count) {
            //     c.setTime(firstday);
            c.add(Calendar.DAY_OF_YEAR, 1);// 今天+1天

            Date tomorrow = c.getTime();

            String dateNowStr = f.format(tomorrow);
           dates.add(dateNowStr);
           i++;
        }

        return  dates;
    }

    private static void InsertFutureDataTradeamt(String filename) throws ParseException {
        FutureDataTradeamtDailyData futureDataTradeamtDailyData= FutureDataTradeamtParse.txt2String(filename);
        List<FutureDataTradeamt> list=futureDataTradeamtDailyData.ToEntityList();

        try {
            DbUtil.insert(Common.INSERT_STUDENT_SQL,list);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
