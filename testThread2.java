package asd;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

//download picture from internet
public class testThread2 extends Thread{
	private String url;
	private String name;
	
	public testThread2(String url, String name){
		this.url = url;
		this.name = name;
	}
	
	public void run() {
		WebDownLoader WebDownLoader = new WebDownLoader();
		WebDownLoader.downloader(url, name);
		System.out.println("down "+ name);
	}
	public static void main(String args[]) {
		testThread2 t1 = new testThread2("https://pics4.baidu.com/feed/03087bf40ad162d95282cc452c4204e48b13cda5.jpeg?token=9baa46488cad2cd871a5e5b650d9c61f","biden");
		testThread2 t2 = new testThread2("https://pics6.baidu.com/feed/6a63f6246b600c33288353182fd1fc07dbf9a18a.jpeg?token=86052b5eb2e6aff31534ba0d565d8e28","Putin");
		testThread2 t3 = new testThread2("https://pics6.baidu.com/feed/37d12f2eb9389b50d53f00d5edf848d5e5116e4f.jpeg?token=aff6fa85c7ee0e4e9626e6b91dd9eccf","Lacey");
		
		t1.start();
		t2.start();
		t3.start();
	}

}

//
class WebDownLoader{
	public void downloader(String url,String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IO error, downloader function have some problem");
		}
	}
}