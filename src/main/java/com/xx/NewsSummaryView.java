package com.xx;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;

public class NewsSummaryView {
    private int id;

    @Attr("href")
    @HtmlField(cssPath = ".newstitle > a")
    private String newsId;

    @Text
    @HtmlField(cssPath = ".newstitle > a")
    private String title;

    @Text
    @HtmlField(cssPath = ".newscontent > p")
    private String content;

    @Attr("data-original")
    @HtmlField(cssPath = ".newstag > a > img")
    private String imgUrl;

    //Href(click = true)能够让解析出来的链接直接放入待解析队列
    @Href(click = true)
    @HtmlField(cssPath = ".newstitle > a")
    private String detailUrl;

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId.substring(newsId.indexOf("newsid") + 7);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    //打印数据，方便调试
    @Override
    public String toString() {
        return "NewsSummaryView{" +
                "id=" + id +
                ", newsId=" + newsId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                '}';
    }
}
