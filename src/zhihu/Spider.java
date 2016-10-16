package zhihu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Spider {
	public static String getContent(String url){
		String result="";
		BufferedReader in=null;
		try {
			URL realUrl=new URL(url);
			URLConnection connection =realUrl.openConnection();
			in=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			String line;
			while((line=in.readLine())!=null){
				System.out.println(line);
				result+=line;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("GetContent≥ˆœ÷“Ï≥££∫"+e);
			e.printStackTrace();
		}finally {
			// TODO: handle finally clause
			try {
				if(in!=null){
					in.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}
}
