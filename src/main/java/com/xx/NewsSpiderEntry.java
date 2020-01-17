package com.xx;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

// Gecco注解中的matchUrl代表可被解析的url路径，pipelines代表一个处理管道，
//当路径页面被下载下来之后，能够通过管道类对封装到HtmlBean中的数据进行处理
//{page}代表一个路径匹配变量，这个变量可以在类中变量通过@RequestParam注解解析获得
@Gecco(matchUrl = "http://news.missevan.com/news/index?p={page}",pipelines = {"consolePipeline","mainPipeline", "newsDetailPipe"})
public class NewsSpiderEntry implements HtmlBean {

    @Request
    private HttpRequest request;

    //cssPath语法和Jquery的选择器类似，用于获取mathurl文档流中符合的元素数据
    //  //NewsSummaryView类看下面，这个类用于封装解析后的列表页数据
    @HtmlField(cssPath = ".newslist")
    private List<NewsSummaryView> newsSummaryViews;

    //Text代表解析text文档（html代表解析html文档，attr代表解析标签属性等）
    @Text
    @HtmlField(cssPath = ".selected > a")
    private String nextPage;


    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public List<NewsSummaryView> getNewsSummaryViews() {
        return newsSummaryViews;
    }

    public void setNewsSummaryViews(List<NewsSummaryView> newsSummaryViews) {
        this.newsSummaryViews = newsSummaryViews;
    }

    public static void main(String[] args) {
        GeccoEngine.create()
                // Gecco搜索的包路径，我这里的包是com.news.spider，可以根据自己的情况改。
                //但需要注意，如果管道类HtmlBean类不在一个包下，就需要配置多个包，否则无法搜索到bean。
                .classpath("com.xx")
                // 开始抓取的页面地址
                .start("http://news.missevan.com/news/index?p=1")
                // 开启几个爬虫线程
                .thread(1)
                // 单个爬虫每次抓取完一个请求后的间隔时间
                .interval(500).start();
    }
}