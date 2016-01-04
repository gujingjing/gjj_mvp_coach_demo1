package mvp.gjj.androidbaselib.view.finishClassView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;

import mvp.gjj.androidbaselib.R;

/**
 * 想要实现向右滑动删除Activity效果只需要继承SwipeBackActivity
 */
public abstract class SwipeBackActivity extends FragmentActivity {
	protected SwipeBackLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
				R.layout.activity_base, null);
		layout.attachToActivity(this);
	}
	@Override
	public void finish(){
		super.finish();
		overridePendingTransition(0, R.anim.base_slide_right_out);
	}
	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
	}
	// Press the back button in mobile phone
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(0, R.anim.base_slide_right_out);
	}
}
