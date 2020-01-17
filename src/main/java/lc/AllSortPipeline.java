package lc;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HrefBean;

import java.util.ArrayList;
import java.util.List;

@PipelineName("allSortPipeline")
public class AllSortPipeline implements Pipeline<AllSort> {
	
	public static List<HttpRequest> sortRequests = new ArrayList<HttpRequest>();

	@Override
	public void process(AllSort allSort) {
		List<Category> mobiles = allSort.getMobile();
		process(allSort, mobiles);
	}
	
	private void process(AllSort allSort, List<Category> categorys) {
		if(categorys == null) {
			return;
		}
		for(Category category : categorys) {
			List<HrefBean> hrefs = category.getCategorys();
			for(HrefBean href : hrefs) {
				String url = href.getUrl()+"";
//                System.out.println("url = " + url);
				HttpRequest currRequest = allSort.getRequest();
				//SchedulerContext.into(currRequest.subRequest(url));
				//将分类的商品列表地址暂存起来
				sortRequests.add(currRequest.subRequest(url));
			}
		}
	}

}