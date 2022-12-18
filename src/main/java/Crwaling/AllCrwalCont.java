package Crwaling;

import Crwaling.Cache.CrwalingCacheDAO;
import Crwaling.Now.CrawlingNowDAO;

import java.util.Timer;
import java.util.TimerTask;

public class AllCrwalCont {
    public static void main(String[] args) {
        Timer m_timer = new Timer();
        TimerTask m_task = new TimerTask(){
            @Override
            public void run() {
                System.out.println("All Crwal Cont start --------------");
                CrwalingCacheDAO crwalingCacheDAO = new CrwalingCacheDAO();
                crwalingCacheDAO.main();

                CrawlingNowDAO crawlingNowDAO = new CrawlingNowDAO();
                crawlingNowDAO.main();
                System.out.println("All Crwal Cont end --------------");
            }
        };
        m_timer.scheduleAtFixedRate(m_task, 0, 1000*60*15);

    }


} //end of AllCrwalCont class
