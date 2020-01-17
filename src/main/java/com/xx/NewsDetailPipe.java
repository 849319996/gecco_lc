package com.xx;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

@PipelineName("newsDetailPipe")
public class NewsDetailPipe implements Pipeline<NewsDetailEntry> {

    public void process(NewsDetailEntry newsDetailEntry) {
        NewsDetail newsDetail = newsDetailEntry.getNewsDetail();
        System.out.println(newsDetail);
    }
}
