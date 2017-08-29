package com.example.calculator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;
import android.content.Context;
import android.content.SharedPreferences;


public class Calculator extends Activity {
	DatabaseHelper myDb;
	
	Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
    button7 , button8 , button9 , buttonAdd , buttonSub , 
    buttonDivision ,buttonMs,buttonMc,buttonMplus,buttonMminus,
    buttonMul , button10 , buttonC , buttonEqual,buttonM ;

EditText edt1 ;

float mValueOne , mValueTwo ,mEqual,mPlus1,mPlus2,mPlus3,val1,val2;
String mSymbol;
int c=0;

boolean mAddition , mSubtract ,mMultiplication ,mDivision ;

	@Override
	public void onConfigurationChanged(Configuration newConfig){
		super.onConfigurationChanged(newConfig);
		Log.d("sam", "yahooo");
		
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myDb= new DatabaseHelper(this);
		
		
	
		
		
		
		
		
		
		
		
		
		button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.btnStart);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        edt1 = (EditText) findViewById(R.id.edt1);
        buttonMs=(Button) findViewById(R.id.buttonms);
        buttonMc =(Button) findViewById(R.id.buttonMclear);
        buttonMplus=(Button)findViewById(R.id.buttonMplus);
        buttonMminus=(Button) findViewById(R.id.buttonMminus);
        buttonM=(Button)findViewById(R.id.buttonM);
        
        
        buttonMs.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	/*			Shared Preferences/////
	 			
	 			SharedPreferences loginData = getSharedPreferences("caltxt",Context.MODE_PRIVATE);
				SharedPreferences.Editor editor= loginData.edit();
				editor.putString("calculation",edt1.getText().toString());
				editor.putString("calculation1",edt1.getText().toString());
				editor.commit(); */
				
		//internal file storage.................		
/*				String Message=edt1.getText().toString();
				String file_name= "txt";
				
				try {
					FileOutputStream  fileOutputStream = openFileOutput(file_name,Context.MODE_PRIVATE);
					fileOutputStream.write(Message.getBytes());
					fileOutputStream.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
						
				
	/////Database..................
				
				String dVal1=String.valueOf(mValueOne);
				String dVal2=String.valueOf(mValueTwo);
				String dResult=String.valueOf(mEqual);
				String dSymbol=mSymbol;
				
				boolean isInserted=myDb.insertData(dVal1, dSymbol, dVal2, dResult);
				if(isInserted==true){
					
					Toast.makeText(Calculator.this, "Saved", Toast.LENGTH_LONG).show();
				}
				
				
				else 
					Toast.makeText(Calculator.this, "Data not saved", Toast.LENGTH_LONG).show();
				
				
				Log.d("cal", "saved");
			}
		});
        
        buttonM.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
/*			Shared Preference///////////////	
			SharedPreferences loginData=getSharedPreferences("caltxt",Context.MODE_PRIVATE);
			String name = loginData.getString("calculation", "");	
			String msg= name;
			edt1.setText(msg);   */
				
				
			///internal file storage..................	
				
/*			String Message;
			try {
				FileInputStream  fileInputStream = openFileInput("txt");
				InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
				BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
				StringBuffer stringBuffer=new StringBuffer();
				while((Message=bufferedReader.readLine())!=null)
				{
					stringBuffer.append(Message+"\n");
				}
				edt1.setText(stringBuffer.toString()); 
			//	edt1.setText(val2+""); 
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
///////Database..........................			
			Cursor res=myDb.getAllData();
			if(res.getCount()==0){
				//
				showMessage("Error","Nothing found");
				return;
			}
			
			StringBuffer buffer =new StringBuffer();
			while(res.moveToNext()){
				buffer.append("Id :"+ res.getString(0)+"\n");
				buffer.append("Value 1 :"+ res.getString(1)+"\n");
				buffer.append("Operation :"+ res.getString(2)+"\n");
				buffer.append("Value 2 :"+ res.getString(3)+"\n");
				buffer.append("Result :"+ res.getString(4)+"\n\n");
		//		buffer.append(res.getString(4));
			}
			showMessage("Data",buffer.toString());
		//	String nval1=buffer.toString();
		//	Float nval2=Float.parseFloat(nval1);
		//	edt1.setText(nval2+"");
		//	edt1.setText(buffer.toString());
			Log.d("cal", "show");
			
			}
		});
        
        
        
        
        buttonMplus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	
//				
				if(edt1.getText().toString().trim().length() > 0)
			   	{
	/*	Shared Preferences..................
				SharedPreferences loginData=getSharedPreferences("caltxt",Context.MODE_PRIVATE);
				String name = loginData.getString("calculation", "");
				String name1=loginData.getString("calculation1","" );
				Float mPlus1=Float.parseFloat(name1);
				Float mPlus3=Float.parseFloat(name);
				mPlus2=mPlus1+mPlus3;
			
				edt1.setText(mPlus2+"");
				
				
				SharedPreferences.Editor editor= loginData.edit();
				
				editor.putString("calculation",edt1.getText().toString());
			
				editor.commit();
				*/
			   	
			   		
/////// internal file storage............
			   		
			   		
	/*		   		String Message;
					try {
						FileInputStream  fileInputStream = openFileInput("txt");
						InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
						BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
						StringBuffer stringBuffer=new StringBuffer();
						while((Message=bufferedReader.readLine())!=null)
						{
							stringBuffer.append(Message+"\n");
						}
						
						String name=stringBuffer.toString(); 
						Float mPlus1=Float.parseFloat(name);
						mPlus1=mPlus1+mPlus1;
						edt1.setText(mPlus1+"");
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					
		//////database.....................	   		
				
					Cursor res=myDb.getAllData();
					if(res.getCount()==0){
						//
						showMessage("Error","Nothing found");
						return;
					}
					
					StringBuffer buffer =new StringBuffer();
					while(res.moveToNext()){
				//		buffer.append("Id :"+ res.getString(0)+"\n");
				//		buffer.append("Value 1 :"+ res.getString(1)+"\n");
				//		buffer.append("Operation :"+ res.getString(2)+"\n");
				//		buffer.append("Value 2 :"+ res.getString(3)+"\n");
				//		buffer.append("Result :"+ res.getString(4)+"\n\n");
						buffer.append(res.getString(4));
					}
				//	showMessage("Data",buffer.toString());
					String nval1=buffer.toString();
					Float nval2=Float.parseFloat(nval1);
					Float nval3= nval2+Float.parseFloat(edt1.getText().toString());
					edt1.setText(nval3+"");	
					
					
					
			
				Log.d("cal", "plus");
		
			   	}
			   	else
			   	{
			   		
			   	}
			}
		});
        
        
        
        
        buttonMminus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			   	if(edt1.getText().toString().trim().length() > 0)
			   	{
//////shared preference...........
			  /* 		
				SharedPreferences loginData=getSharedPreferences("caltxt",Context.MODE_PRIVATE);
				String name = loginData.getString("calculation", "");
				String name1=loginData.getString("calculation1","" );
				Float mPlus1=Float.parseFloat(name1);
				Float mPlus3=Float.parseFloat(name);
				mPlus2=mPlus3-mPlus1;
			
				edt1.setText(mPlus2+"");
				
				
				SharedPreferences.Editor editor= loginData.edit();
				
				editor.putString("calculation",edt1.getText().toString());
			
				editor.commit();   */
				
				
				
				
		//////database..............		
				Cursor res=myDb.getAllData();
				if(res.getCount()==0){
					//
					showMessage("Error","Nothing found");
					return;
				}
				
				StringBuffer buffer =new StringBuffer();
				while(res.moveToNext()){
			//		buffer.append("Id :"+ res.getString(0)+"\n");
			//		buffer.append("Value 1 :"+ res.getString(1)+"\n");
			//		buffer.append("Operation :"+ res.getString(2)+"\n");
			//		buffer.append("Value 2 :"+ res.getString(3)+"\n");
			//		buffer.append("Result :"+ res.getString(4)+"\n\n");
					buffer.append(res.getString(4));
				}
			//	showMessage("Data",buffer.toString());
				String nval1=buffer.toString();
				Float nval2=Float.parseFloat(nval1);
				Float nval3= Float.parseFloat(edt1.getText().toString())-nval2;
				edt1.setText(nval3+"");	
				
				
			
				Log.d("cal", "minus");
		
			   	}
			   	else
			   	{
			   		
			   	}
			}
		});
        	
        
        
        buttonMc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//////shared preferenc......................
/*			
				SharedPreferences loginData = getSharedPreferences("caltxt",Context.MODE_PRIVATE);
				SharedPreferences.Editor editor= loginData.edit();
				
				editor.putString("calculation","");
				editor.commit();
				edt1.setText("");
				//Log.d("cal", "saved");   */
				
				
				
				Integer deletedRows = myDb.deleteData(edt1.getText().toString());
				if(deletedRows>0){
					Toast.makeText(Calculator.this, "Data deleted",Toast.LENGTH_LONG).show();
				}
				else
					Toast.makeText(Calculator.this, "Data not deleted",Toast.LENGTH_LONG).show();
				
				
			}
		});
        
        
        
 
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"1");
            }
        });
 
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"2");
            }
        });
 
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"3");
            }
        });
 
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"4");
            }
        });
 
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"5");
            }
        });
 
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"6");
            }
        });
 
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"7");
            }
        });
 
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"8");
            }
        });
 
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"9");
            }
        });
 
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+"0");
            }
        });
 
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 
                if (edt1 == null){
                    edt1.setText("");
                }else {
                   	if(edt1.getText().toString().trim().length() > 0){
                    mValueOne = Float.parseFloat(edt1.getText() + "");
                    val1=mValueOne;
                    
                    mAddition = true;
                    edt1.setText(null);
                   	}
                   	else
                   	{
                   		
                   	}
               //     Log.d("si", "+++++++");
                }
            }
        });
 
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               	if(edt1.getText().toString().trim().length() > 0)
               	{
                mValueOne = Float.parseFloat(edt1.getText() + "");
                mSubtract = true ;
                edt1.setText(null);
               	}
               	else
               	{
               		
               	}
            }
        });
 
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
        
        	
       
            public void onClick(View v) {
            	if(edt1.getText().toString().trim().length() > 0)
            	{
                mValueOne = Float.parseFloat(edt1.getText() + "");
                mMultiplication = true ;
                edt1.setText(null);
                }
            	else
            	{
            		//
            	}
            }
        	
      
            
        	
        	
        });
 
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               	if(edt1.getText().toString().trim().length() > 0)
               	{
                mValueOne = Float.parseFloat(edt1.getText()+"");
                mDivision = true ;
                edt1.setText(null);
               	}
               	else
               	{
               	}	
               	
                
            }
        });
 
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	
               	if(edt1.getText().toString().trim().length() > 0)
               	{
                mValueTwo = Float.parseFloat(edt1.getText() + "");
                val2=mValueTwo;
 
                if (mAddition == true){
                mEqual=mValueOne+mValueTwo;
                mSymbol="+";
                edt1.setText(mEqual +"");
                Log.d("si", "adddddddddddddddd");
                    mAddition=false;
                }
 
 
                if (mSubtract == true){
                	mEqual=mValueOne-mValueTwo;
                	mSymbol="-";
                    edt1.setText(mValueOne - mValueTwo+"");
                    mSubtract=false;
                }
 
                if (mMultiplication == true){
                	mEqual=mValueOne*mValueTwo;
                    mSymbol="X";
                    edt1.setText(mValueOne * mValueTwo+"");
                
                    mMultiplication=false;
                }
 
                if (mDivision == true){
                	mEqual=mValueOne/mValueTwo;
                    mSymbol="/";
                    edt1.setText(mValueOne / mValueTwo+"");
                    mDivision=false;
                }
               	}
               	else
               	{
               		
               	}
           
             //   String s=Float.toString(mEqual);
              //  return s;
            }
        });
 
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
            }
        });
 
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText()+".");
            }
        });
		
		
	}
	
	
	public void showMessage(String title,String Message){
		AlertDialog.Builder builder= new AlertDialog.Builder(this);
		builder.setCancelable(true);
		builder.setTitle(title);
		builder.setMessage(Message);
		builder.show();
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
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
}
