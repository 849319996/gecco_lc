package com.xx;

import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;

import java.util.List;

public class NewsDetail {
    private int id;
    private String author;
    private String source;

    @Text
    @HtmlField(cssPath = "#articletitle")
    private String title;

    @Html
    @HtmlField(cssPath = "#articlecontent")
    private String content;

    @Text
    @HtmlField(cssPath = ".newsinfo2")
    private List<String> createdDate;


    private int commentCount;

    @Text
    @HtmlField(cssPath = ".newstags1 > a")
    private List<String> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
        //对数据做正则处理，过滤掉不要的内容
        content  = content.replaceAll("<div class=\"clear[\\s\\S]*class=\"clear\".*</div>","");
        this.content = content;
    }

    public List<String> getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(List<String> createdDate) {
        this.createdDate = createdDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "NewsDetail{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", source='" + source + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", commentCount=" + commentCount +
                ", tags='" + tags + '\'' +
                '}';
    }
}
