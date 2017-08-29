package com.example.calculator;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Webviewcal extends Activity {
	
	
	
	WebView webview;
//	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webviewcal);
		
		
//		context(this);
////////////webview................		
	     webview=(WebView)findViewById(R.id.webView1);
         webview.getSettings().setBuiltInZoomControls(true);
         WebSettings settings=webview.getSettings();
         settings.setJavaScriptEnabled(true);
         webview.addJavascriptInterface(new WebViewInterface(this), "Android");
         
         webview.loadUrl("file:///android_asset/index.html");
         
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.webviewcal, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public class WebViewInterface{
//	    private static final String String = null;
		public int a;
	//	public int nval=9;
		public String b,c;
		int arr[]=new int[3];
		boolean flag=false;
		Context mContext;
//		WebViewInterface x= new WebViewInterface(mContext);
	    /** Instantiate the interface and set the context */
	    WebViewInterface(Context c) {
	        mContext = c;
	    }

	    /** Get the value 
	     * @return */
	 //   @JavascriptInterface
	  //  public int getValue() {
	      //  return value;
	   // }
	    
	    public int addNum(String num) {
	    	
		    Toast.makeText(mContext, num, Toast.LENGTH_SHORT).show();
	 
	      //  a=num;
	        System.out.println(a);
	       
	        
	        int vall1=Integer.parseInt(num);
	      //  System.out.println(vall1);
	        
	        
	     
	        if(flag==false){	
	        	arr[0]=vall1;
	        	flag=true;
	        }
	        else {
	        	
	        	arr[1]=vall1;
	        	flag=false;
	        	
	        }
	        
	        
	        
	        
	       Log.d("valgd", "nummmm");
	       return arr[0];
	        
	    }
	    
	    
	    
	   
	    
	    
	    public String addOperator(String val) {
	        Log.d("valgd", "oprtor");
	        b=val;
	        Toast.makeText(mContext, val, Toast.LENGTH_SHORT).show();
	        System.out.println(b);
	        if(b.contentEquals("+")){
	        	a=1;
	            System.out.println(a);
	        //	break;
	        }
	        else if(b.contentEquals("-")){
	        	a=2;
	            System.out.println(a);
	        }
	        else if(b.contentEquals("*")){
	        	a=3;
	            System.out.println(a);
	        }
	        else if (b.contentEquals("/")){
	        	a=4;
	            System.out.println(a);
	        }
	        System.out.println(a);
	        return b;
	        
	    }
	    
	    public int getResult() {
	  //  Integer val = null;
			
	    	
	    	int nval=56;
	///		int x=addNum(val);
	//       return x;
	//       addNum();
	   // 	String p;
//	    	this.addNum(p);
	    	 System.out.println(b);
		        	
	//    if(b=="+") return arr[0]+arr[1];
	    	
	 //    if(b=="-")return arr[0]-arr[1];
	    //	return nval;
	    
	  //   if(b=="*")return arr[0]*arr[1];
	    	
	    
	    // else return arr[0]/arr[1];
	    	 
	    	  switch (a) {
	          case 1:
	        	  return arr[0]+arr[1];
	          case 2:
	        	  return arr[0]-arr[1];
	          case 3:
	        	  return arr[0]*arr[1];
	          case 4:
	        	  return arr[0]/arr[1];
	          
	          default:
	              return nval;
	            
	  	             
	      }
	  
	    
	   // else 
	 //  return  arr[0]-arr[1];
	  
	    	
	 /*   	return b=="+"? arr[0]+arr[1]
	    		 : b=="-"? arr[0]-arr[1]
	    		 : b=="/"? arr[0]/arr[1]
	    		: b=="*"? arr[0]*arr[1]
	    		: arr[0];		
	   */ 	
	    	
	  }

	//	private int addNum(String num) {
			// TODO Auto-generated method stub
//			return 0;
//		}

	//	private int toInteger(String c) {
			// TODO Auto-generated method stub
			 // int vall1=Integer.parseInt(c);
	//		return Integer.parseInt(c);
	//	}
	    
	}


	
}
	