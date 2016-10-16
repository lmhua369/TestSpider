package zhihu;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZhiHuBeans {
	public ArrayList<String> zhihuquestionsurls;
	
	public ZhiHuBeans(String url){
		zhihuquestionsurls=new ArrayList<String>();
		if(isZhihuUrl(url)){
			String content=Spider.getContent(url);
			Matcher m=Pattern.compile("<link.+?\"/question/").matcher(content);
			while(m.find()){
				String s="https://www.zhihu.com/question/"+content.substring(m.end(),m.end()+8);
				System.out.println(s);
				zhihuquestionsurls.add(s);
			}
		}
	}
	
	public boolean isZhihuUrl(String url){
		if(url.startsWith("http://www.zhihu.com")||url.startsWith("https://www.zhihu.com")){
			return true;
		}
		return false;
	}
	
	public ArrayList<String> getZhihuquestionsurls() {
		return zhihuquestionsurls;
	}
	public void setZhihuquestionsurls(ArrayList<String> zhihuquestionsurls) {
		this.zhihuquestionsurls = zhihuquestionsurls;
	}
	
	public static void main(String[] args) throws Exception {
		ZhiHuBeans zb=new ZhiHuBeans("https://www.zhihu.com/people/excited-vczh");
		ZhiHuBean myZhihu=null;
		String addr="D:/ZhiHuSpider/";
		for(String s:zb.getZhihuquestionsurls()){
			myZhihu=new ZhiHuBean(s);
			DownLoad.downLoadPics(myZhihu, addr);
		}
	}
	
}
