package lc;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * 某个商品列表页
 * 
 * @author memory
 *
 */
@Gecco(matchUrl="https://list.szlcsc.com/catalog/{id}.html", pipelines={"consolePipeline"})
public class ProductList implements HtmlBean {
	
	private static final long serialVersionUID = 4369792078959596706L;

	@RequestParameter
	public  int id;
	
	@Request
	private HttpRequest request;
	
	/**
	 * 抓取列表项的详细内容，包括titile，价格，详情页地址等
	 */
	@HtmlField(cssPath="#shop-list ")
	private List<ProductBrief> details;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public List<ProductBrief> getDetails() {
		return details;
	}

	public void setDetails(List<ProductBrief> details) {
		this.details = details;
	}
}
