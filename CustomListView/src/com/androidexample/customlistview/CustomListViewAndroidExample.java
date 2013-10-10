package com.androidexample.customlistview;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.content.res.Resources;


public class CustomListViewAndroidExample extends Activity {

	ListView list;
	CustomAdapter adapter;
	public  CustomListViewAndroidExample CustomListView = null;
	public  ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<ListModel>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_list_view_android_example);
		
		CustomListView = this;
		
		/******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
		setListData();
		
		Resources res =getResources(); 
        list=(ListView)findViewById(R.id.list);
        
        /**************** Create Custom Adapter *********/
        adapter=new CustomAdapter(CustomListView, CustomListViewValuesArr,res);
        list.setAdapter(adapter);
		
	}

	/****** Function to set data in ArrayList *************/
    public void setListData()
    {
    	
		for (int i = 0; i < 11; i++) {
			
			final ListModel sched = new ListModel();
			    
			  /******* Firstly take data in model object ******/
			   sched.setCompanyName("Company "+i);
			   sched.setImage("image"+i);
			   sched.setUrl("http:\\\\www."+i+".com");
			   
			/******** Take Model Object in ArrayList **********/
			CustomListViewValuesArr.add(sched);
		}
		
    }
    
    public void onItemClick(int mPosition)
    {
    	ListModel tempValues = (ListModel) CustomListViewValuesArr.get(mPosition);
    	
    	Toast.makeText(CustomListView, 
    			""+tempValues.getCompanyName()+" \nImage:"+tempValues.getImage()+" \nUrl:"+tempValues.getUrl(), 
    			Toast.LENGTH_LONG)
    	.show();
    }
   

}
