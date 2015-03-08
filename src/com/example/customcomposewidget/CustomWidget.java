package com.example.customcomposewidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomWidget extends LinearLayout {

	private TextView mTv;
	private ImageButton mBtn;
	
	public CustomWidget(Context context) {
		this(context, null);
	}

	public CustomWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.custom_layout, this, true);
		
		mTv = (TextView)findViewById(R.id.text1);
		mBtn = (ImageButton)findViewById(R.id.btn1);
		
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImageBtnWithText);  
		CharSequence text = a.getText(R.styleable.ImageBtnWithText_android_text); 
		CharSequence appendText = a.getText(R.styleable.ImageBtnWithText_appendText);  
		if(text != null) mTv.setText("Text =" +  text  + ", " + "appendText = " + appendText.toString());  
		Drawable drawable = a.getDrawable(R.styleable.ImageBtnWithText_android_src);  
		if(drawable != null) mBtn.setImageDrawable(drawable);  
		a.recycle();
	}
	
	/**
	 *  设置按钮图片
	 * @param resId
	 */
	public void setButtonImageResource(int resId) {  
        mBtn.setImageResource(resId);  
    }  
      
    /**
     * 设置文本字符串
     * @param text
     */
    public void setTextViewText(String text) {  
        mTv.setText(text);  
    } 
}
