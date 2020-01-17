package lc;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.spider.HtmlBean;

public class ProductBrief implements HtmlBean {

	private static final long serialVersionUID = -377053120283382723L;

	@Attr("data-productcode")
	@HtmlField(cssPath=".inside")
	private String productcode;


	@Text
	@HtmlField(cssPath=".inside  tbody  tr  .two-tit  a:nth-child(2)")
	private String title;



	@Href(click=true)
	@HtmlField(cssPath=".inside  tbody  tr  .two-tit  a:nth-child(2)")
	private String detailUrl;

	@Attr("xpath")
	@HtmlField(cssPath=".inside tbody tr .one-to-item-link  img ")
	private String preview;


	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}
}
