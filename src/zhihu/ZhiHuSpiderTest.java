package zhihu;


public class ZhiHuSpiderTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url="http://www.zhihu.com/question/27621722";
		ZhiHuBean myZhihu=new ZhiHuBean(url);
		System.out.println("���⣺"+myZhihu.getQuestion());
		System.out.println();
		String addr="D:/ZhiHuSpider/";
		System.out.println("��������ͼƬ��"+addr+myZhihu.getQuestion());
		System.out.println();
		System.out.println("��ʼ���ء�����");
		System.out.println();
		DownLoad.downLoadPics(myZhihu, addr);
		System.out.println();
		System.out.println("ͼƬ�������");
	}

}
