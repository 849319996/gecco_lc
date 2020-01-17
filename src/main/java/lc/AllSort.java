package lc;

import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;


@Gecco(matchUrl = "https://www.szlcsc.com/catalog.html", pipelines = {"consolePipeline", "allSortPipeline"})
public class AllSort implements HtmlBean {


    @Request
    private HttpRequest request;

    //商品
    @HtmlField(cssPath = ".catalog-main >  div:nth-child(1) ")
    private List<Category> mobile;


    public List<Category> getMobile() {
        return mobile;
    }

    public void setMobile(List<Category> mobile) {
        this.mobile = mobile;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public static void main(String[] args) {
        //先获取分类列表
        HttpGetRequest start = new HttpGetRequest("https://www.szlcsc.com/catalog.html");
        start.setCharset("utf-8");
        GeccoEngine.create()
                .classpath("lc")
                //开始抓取的页面地址
                .start(start)
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000).debug(false)
                .run();


		//分类列表下的商品列表采用3线程抓取
        GeccoEngine.create()
                .classpath("lc")
                //开始抓取的页面地址
                .start(AllSortPipeline.sortRequests)
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                .start();
    }
}
