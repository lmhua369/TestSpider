package zhihu;


public class ZhiHuSpiderTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url="http://www.zhihu.com/question/27621722";
		ZhiHuBean myZhihu=new ZhiHuBean(url);
		System.out.println("标题："+myZhihu.getQuestion());
		System.out.println();
		String addr="D:/ZhiHuSpider/";
		System.out.println("即将下载图片到"+addr+myZhihu.getQuestion());
		System.out.println();
		System.out.println("开始下载。。。");
		System.out.println();
		DownLoad.downLoadPics(myZhihu, addr);
		System.out.println();
		System.out.println("图片下载完毕");
	}

}
