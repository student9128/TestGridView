package com.jing.testgridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
	private GridView gridView;
	private int[] icon = { R.drawable.a, R.drawable.b, R.drawable.c,R.drawable.e,
			R.drawable.vv, R.drawable.f, R.drawable.g, R.drawable.vz,
			R.drawable.w0, R.drawable.w2, R.drawable.w6, R.drawable.we };
	private String[] text = { "嗨", "你好","中国", "美国", "法国",
			"意大利", "德国", "英国", "俄罗斯", "加拿大", "巴西","联合国", "荷兰"};
	private SimpleAdapter adapter;
	private List<Map<String, Object>> dataList;
	private Toast iconName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridView = (GridView) findViewById(R.id.gridView);
		dataList = new ArrayList<Map<String, Object>>();
		getData();
		adapter = new SimpleAdapter(this, dataList,R.layout.activity_item,new String[]{"image","text"},new int[]{R.id.iv_image,R.id.text});
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(this);
	}

	public List<Map<String, Object>> getData() {
		for (int i = 0; i < icon.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", icon[i]);
			map.put("text", text[i]);
			dataList.add(map);
		}
		return dataList;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
		if(iconName == null){
			
			iconName = Toast.makeText(this, "你点了", Toast.LENGTH_SHORT);
		}	
		iconName.setText("O(∩_∩)O~"+text[position]);
			iconName.show();

	}

	

}
