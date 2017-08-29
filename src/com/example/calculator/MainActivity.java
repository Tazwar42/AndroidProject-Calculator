package com.example.calculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
 
public class MainActivity extends Activity implements View.OnClickListener
{	
//	DatabaseHelper myDb;
	/*Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn,btnadd,btnmin,
	btndiv,btnmult,btneql,btnclr;
	
     
	 TextView Result;
	 int FirstVal,SecondVal,Res;
	 char op;
	//private String display;*/
	Button btnst;
//	WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
//    	myDb= new DatabaseHelper(this);
        
        
        
   
  /*      
        
        boolean b = checkInternetConnection();
        
        if(b!=true)
        {
           Toast.makeText(this, "netwrk not", Toast.LENGTH_LONG).show();
        }
        else
        {
        	// Toast.makeText(this, "netwrk yes", Toast.LENGTH_LONG).show();  
       
        }
  
        */
      
        
        
        btnCast();
        btnst.setOnClickListener(this);
       /* btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnclr.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnmult.setOnClickListener(this);
        btnadd.setOnClickListener(this);
        btnmin.setOnClickListener(this);
        btneql.setOnClickListener(this);*/
        
    }
    
 //////checking internet connection............................   
    public boolean checkInternetConnection() {
        final ConnectivityManager conMgr = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() &&    conMgr.getActiveNetworkInfo().isConnected()) {
              return true;
        } else {
            //  System.out.println("Internet Connection Not Present");
            return false;
        }
     }
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
	public void onConfigurationChanged(Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		Log.d("vivz", "orientaiton changed");
	}
    
    public void btnCast()
    {
    	// = (TextView) findViewById(R.id.display);
    	btnst= (Button) findViewById(R.id.btnStart);
    	/*btn2= (Button) findViewById(R.id.Btn2);
    	btn3= (Button) findViewById(R.id.Btn3);
    	btn4= (Button) findViewById(R.id.Btn4);
    	btn5= (Button) findViewById(R.id.Btn5);
    	btn6= (Button) findViewById(R.id.Btn6);
    	btn7= (Button) findViewById(R.id.Btn7);
    	btn8= (Button) findViewById(R.id.Btn8);
    	btn9= (Button) findViewById(R.id.Btn9);
    	btnclr= (Button) findViewById(R.id.Btnclear);
    	btnmult= (Button) findViewById(R.id.Btnmult);
    	btnadd= (Button) findViewById(R.id.btnplus);
    	btndiv= (Button) findViewById(R.id.Btndiv);
    	btnmin= (Button) findViewById(R.id.Btnminus);
    	btneql=(Button) findViewById(R.id.Btnequal);
    	//btn= (Button) findViewById(R.id);
    	//btn= (Button) findViewById(R.id);
    	*/
    
    }

	@Override
	public void onClick(View v) 
	{
		if(v.getId()==R.id.btnStart)
		{
			
			
		boolean b = checkInternetConnection();
		        
		        if(b!=true)
		        {
		           Toast.makeText(this, "netwrk not", Toast.LENGTH_LONG).show();
		        	Intent intent = new Intent(MainActivity.this, Calculator.class);
					
					startActivity(intent);
		        
		        }
		        
		        else
		        {
		        	 Toast.makeText(this, "netwrk yes", Toast.LENGTH_LONG).show();  
		       
		        	Intent intent = new Intent(MainActivity.this, Webviewcal.class);
					
						startActivity(intent);
		        
		        }			
			
			
			
			
		
		}
		/*else if(v.getId()==R.id.Btn2)
		{
			Result.setText(Result.getText()+"2");
		}
		else if(v.getId()==R.id.Btn3)
		{
			Result.setText(Result.getText()+"3");
		}
		else if(v.getId()==R.id.Btn4)
		{
			Result.setText(Result.getText()+"4");
		}
		else if(v.getId()==R.id.Btn5)
		{
			Result.setText(Result.getText()+"5");
		}
		else if(v.getId()==R.id.Btn6)
		{
			Result.setText(Result.getText()+"6");
		}
		else if(v.getId()==R.id.Btn7)
		{
			Result.setText(Result.getText()+"7");
		}
		else if(v.getId()==R.id.Btn8)
		{
			Result.setText(Result.getText()+"8");
		}
		else if(v.getId()==R.id.Btn9)
		{
			Result.setText(Result.getText()+"9");
		}
		else if(v.getId()==R.id.Btnclear)
		{
			Result.setText("");
		}
		
		else if(v.getId()==R.id.Btnminus)
		{
			FirstVal=Integer.parseInt(Result.getText().toString());
			op='-';
			Result.setText("");
		}
		else if(v.getId()==R.id.btnplus)
		{
			FirstVal=Integer.parseInt(Result.getText().toString());
			op='+';
			Result.setText("");
		}
		else if(v.getId()==R.id.Btnmult)
		{
			FirstVal=Integer.parseInt(Result.getText().toString());
			op='*';
			Result.setText("");
		}
		else if(v.getId()==R.id.Btndiv)
		{
			FirstVal=Integer.parseInt(Result.getText().toString());
			op='/';
			Result.setText("");
		}
		else if(v.getId()==R.id.Btnequal)
		{
			SecondVal=Integer.parseInt(Result.getText().toString());
			switch(op)
			{
			case '+':
				Res=FirstVal+SecondVal;
				Result.setText(Res+"");
				break;
			case '-':
				Res=FirstVal-SecondVal;
				Result.setText(Res+"");
				break;
			case '*':
				Res=FirstVal*SecondVal;
				Result.setText(Res+"");
				break;
			case '/':
				Res=FirstVal/SecondVal;
				Result.setText(Res+"");
				break;	
			
			}
			
		}
		
		*/
	}
	

	
	
	
 
    /*@Override
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
    private void updateScreen()
    {
    _screen.setText(display);   
    }
     
    public void onClicknumber(View v)
    {
        Button b = (Button) v;
        display += b.getText();
        updateScreen();
    }
     
    public void onClickOperator(View v)
    {
        Button b = (Button) v;
        display += b.getText();
        currentOperator = b.getText().toString();
        updateScreen();
    }
    public void onClickClear(View v)
    {
    	display = "";
    	currentOperator = ""; 
    	updateScreen();
    }*/
}