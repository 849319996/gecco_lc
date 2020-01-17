package com.xx;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "http://news.missevan.com/news/article?newsid={newsid}", pipelines = "newsDetailPipe")
public class NewsDetailEntry implements HtmlBean {

    @HtmlField(cssPath = "#articlebox")
    private NewsDetail newsDetail;

    //匹配解析路径删的{newsid}
    @RequestParameter("newsid")
    private int newsid;

    public int getNewsid() {
        return newsid;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public NewsDetail getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(NewsDetail newsDetail) {
        this.newsDetail = newsDetail;
    }
}
