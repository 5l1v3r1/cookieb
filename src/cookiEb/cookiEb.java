package cookiEb;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;


public class cookiEb {
	

	public static void main(String args[]) {
		try {
			System.out.println("Coded by AhmethanGultekin - github.com/ahmeth4n");
	        Scanner input = new Scanner(System.in); 
	        System.out.print("URL : ");
	        String webAddr = input.nextLine(); 

			String[] file_type = new String[]{"webp","jpg","png","gif","svg","mp4","avi","jpeg","php","asp","aspx","ashx","asp","php5","php3"
					,"html","html5","xhtml","shtml","rb","py","css","js","scss","json","xml","jsp","vbs"};
	        List<String> file_types = Arrays.asList(file_type);

			CookieManager cookieManager = new CookieManager();
			CookieHandler.setDefault(cookieManager);

			URL url = new URL(webAddr);

			URLConnection connection = url.openConnection();
			connection.getContent();

			List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();
	        StringBuilder sb = new StringBuilder(); 
	        
	        for (HttpCookie ch : cookies) { 
	            sb.append(ch+"="); 
	        } 
	        String cookieString = sb.toString(); 
	        String cookieVal[] = cookieString.split("=");
	        for(String veri : cookieVal) {
	        	if(veri.contains("%2F") && veri.contains(".")) {
	        		String ext1 = FilenameUtils.getExtension(veri);
	        		if(file_types.contains(ext1)) {
	        			System.out.println("Path Detected => " + veri);
	        		}
	    	        	
	        	}
	        	
	        }
	        	
	        
	        
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
