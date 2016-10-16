package zhihu;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;

public class DownLoad {
	public static synchronized boolean downLoadPics(ZhiHuBean zhiHuBean,String filePath) throws Exception{
		String question=zhiHuBean.getQuestion();
		question=question.substring(34,question.length()-7);
		String dir=filePath+question;
		File fileDir=new File(dir);
		fileDir.mkdirs();
		ArrayList<String> zhiHuPics=zhiHuBean.getZhihuPicUrl();
		int i=1;
		for(String zhiHuPic:zhiHuPics){
			URL url=new URL(zhiHuPic);
			DataInputStream dis=new DataInputStream(url.openStream());
			String newImageName=dir+"/"+"Image"+i+".jpg";
			System.out.println(newImageName);
			FileOutputStream fos=new FileOutputStream(new File(newImageName));
			byte[] buffer =new byte[3072];
			int length;
			System.out.println("正在下载第"+i+"张图片。。。");
			while((length=dis.read(buffer))>0){
				fos.write(buffer,0,length);
			}
			dis.close();
			fos.close();
			System.out.println("第"+i+"下载完毕");
			i++;
		}
		return true;
	}
}