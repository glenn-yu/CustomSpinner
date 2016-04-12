package com.example.samplecustomspinner;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

// 주석부분은 참고만 할 것.
// 평소 스피너 사용하는 방법에서 변형하면 된다. 
// 기록을 위하여 남겨놓음.
public class MainActivity extends Activity {
	
	String[] spinnerValues = { "Blur", "NFS", "Burnout", "GTA IV", "Racing", };
	String[] spinnerSubs = { "Ultimate Game", "Need for Speed",
			"Ulimate Racing", "Rockstar Games", "Thunder Bolt" };
	int total_images[] = { R.drawable.numbers_1, R.drawable.numbers_2,
			R.drawable.numbers_3, R.drawable.numbers_4, R.drawable.numbers_5,
			R.drawable.numbers_6 };
	
	// private ArrayList<Images> arrayImages;
	// private MyAdapter myAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Spinner mySpinner = (Spinner) findViewById(R.id.spinner_show);
		mySpinner.setAdapter(new MyAdapter(this, R.layout.custom_spinner,spinnerValues));
		

		// 1번은 스피너가 눌려지지 않았을 때 첫 모습을 커스텀하는 것. 
		// 1. myAdapter = new MyAdapter(context, R.layout.item_spinner, arrayImages);
		// 2번은 스피너를 눌렀을 때 펼쳐지는 모습을 커스텀하는 것.
		// 2. myAdapter.setDropDownViewResource(R.layout.item_spinner_dropdown);
	}

	public class MyAdapter extends ArrayAdapter<String> {
		public MyAdapter(Context ctx, int txtViewResourceId, String[] objects) {
			super(ctx, txtViewResourceId, objects);
			// inflater가 필요한데 이곳에서 작성해준다.
			// this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
			// 이곳은 2번의 모습을 정의
			// View view = inflater.inflate(R.layout.item_spinner_dropdown, parent, false);
			// TextView tvValue = (TextView) view.findViewById(R.id.tv_spitem);
			// tvValue.setText("");
			
			// return view;
			return getCustomView(position, cnvtView, prnt);
		}

		@Override
		public View getView(int pos, View cnvtView, ViewGroup prnt) {
			// 이곳은 1번의 모습을 정의
			// View view = inflater.inflate(R.layout.item_spinner, parent, false);
			// TextView tvValue = (TextView) view.findViewById(R.id.tv_spitem);
			// tvValue.setText("");
			
			// return view;			
			
			return getCustomView(pos, cnvtView, prnt);
		}

		public View getCustomView(int position, View convertView,
				ViewGroup parent) {
			
			LayoutInflater inflater = getLayoutInflater();
			View mySpinner = inflater.inflate(R.layout.custom_spinner, parent,false);
			
			TextView main_text = (TextView) mySpinner.findViewById(R.id.text_main_seen);
			TextView subSpinner = (TextView) mySpinner.findViewById(R.id.sub_text_seen);
			ImageView left_icon = (ImageView) mySpinner.findViewById(R.id.left_pic);
			
			main_text.setText(spinnerValues[position]);
			subSpinner.setText(spinnerSubs[position]);
			left_icon.setImageResource(total_images[position]);
			
			return mySpinner;
		}
	}

}
