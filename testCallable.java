package asd;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

public class testCallable implements Callable<Boolean> {
	private String url;
	private String name;
	
	public testCallable(String url, String name){
		this.url = url;
		this.name = name;
	}
	
	public Boolean call() {
		WebDownLoader WebDownLoader = new WebDownLoader();
		WebDownLoader.downloader(url, name);
		System.out.println("down "+ name);
		return true;
	}
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		testCallable t1 = new testCallable("https://pics4.baidu.com/feed/03087bf40ad162d95282cc452c4204e48b13cda5.jpeg?token=9baa46488cad2cd871a5e5b650d9c61f","biden");
		testCallable t2 = new testCallable("https://pics6.baidu.com/feed/6a63f6246b600c33288353182fd1fc07dbf9a18a.jpeg?token=86052b5eb2e6aff31534ba0d565d8e28","Putin");
		testCallable t3 = new testCallable("https://pics6.baidu.com/feed/37d12f2eb9389b50d53f00d5edf848d5e5116e4f.jpeg?token=aff6fa85c7ee0e4e9626e6b91dd9eccf","Lacey");
		
		// create execute server
		ExecutorService ser = Executors.newFixedThreadPool(3);
		
		//submit execution
		Future<Boolean> result1 = ser.submit(t1);
		Future<Boolean> result2 = ser.submit(t2);
		Future<Boolean> result3 = ser.submit(t3);
		
		//get the result
		boolean re1 = result1.get();
		boolean re2 = result2.get();
		boolean re3 = result3.get();
		
		//turn down the server
		ser.shutdownNow();
	}


}
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