package com.xx;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;

import java.util.List;

@PipelineName("mainPipeline")
public class MainPipeline implements Pipeline<NewsSpiderEntry> {

    public void process(NewsSpiderEntry newsSpiderEntry) {
        HttpRequest request = newsSpiderEntry.getRequest();
        List<NewsSummaryView> newsSummaryViews = newsSpiderEntry.getNewsSummaryViews();
        for(NewsSummaryView newsSummaryView : newsSummaryViews) {
            System.out.println(newsSummaryView);
        }
        //获取下一页url
        int nextPage = Integer.parseInt(newsSpiderEntry.getNextPage()) + 1;
        //将下一页的url加入待解析队列
        String nextPageurl = "http://news.missevan.com/news/index?p=" + nextPage;
        SchedulerContext.into(request.subRequest(nextPageurl));
    }
}
