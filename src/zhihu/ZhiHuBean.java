package zhihu;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZhiHuBean {
	public String question;
	public ArrayList<String> zhihuPicUrl;
	public boolean issearched;
	
	public boolean isIssearched() {
		return issearched;
	}
	public void setIssearched(boolean issearched) {
		this.issearched = issearched;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<String> getZhihuPicUrl() {
		return zhihuPicUrl;
	}
	public void setZhihuPicUrl(ArrayList<String> zhihuPicUrl) {
		this.zhihuPicUrl = zhihuPicUrl;
	}
	
	//�������answer��ҳ��ת������ҳ��
	public String getRealUrl(String url){
		Matcher m=Pattern.compile("(\\d*)/answer/(\\d*)").matcher(url);
		if(m.find()){
			return "http://www.zhihu.com/question/"+m.group(1);
		}else{
			return url.replaceFirst("s", "");
		}
	}
	
	public boolean isZhiHuUrl(String url){
		if(url.startsWith("http://www.zhihu.com/question/")||url.startsWith("https://www.zhihu.com/question/")){
			return true;
		}else{
			return false;
		}
	}
	
	public ZhiHuBean(String url) throws Exception{
		zhihuPicUrl=new ArrayList<String>();
		if(isZhiHuUrl(url)){
			url=getRealUrl(url);
			System.out.println("����ץȡ֪���������ӣ�"+url);
			String content=Spider.getContent(url);
			Matcher m;
			m=Pattern.compile("zh-question-title.+?<h2.+?>(.+?)</h2>").matcher(content);
			if(m.find()){
				question=m.group(1);
			}
			m=Pattern.compile("</noscript><img.+?src=\"(https.+?)\".+?").matcher(content);
			boolean isFind;
            while (isFind= m.find()) {
                zhihuPicUrl.add(m.group(1));
            }
        }else throw new Exception("��ַ����������֪����ַ��");
	}
}
