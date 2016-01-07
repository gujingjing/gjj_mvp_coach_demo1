package mvp.gjj.gjj_mvp_basedemo.factory;

import android.util.SparseArray;

import java.util.HashMap;

import mvp.gjj.androidbaselib.base.BaseFragment;
import mvp.gjj.gjj_mvp_basedemo.fragment.Fragment1;
import mvp.gjj.gjj_mvp_basedemo.fragment.Fragment1_Copy;
import mvp.gjj.gjj_mvp_basedemo.fragment.Fragment2;
import mvp.gjj.gjj_mvp_basedemo.fragment.Fragment3;

public class FragmentFactory {
	private static HashMap<Integer, BaseFragment> hashMap = new HashMap<Integer, BaseFragment>();
	//SparseArray性能优化
	private static SparseArray<BaseFragment> sparseArray=new SparseArray<>();

	public static BaseFragment createFragment(int arg0){
		BaseFragment baseFragment = null;
		if(sparseArray.get(arg0)!=null){
			baseFragment=sparseArray.get(arg0);
		}else{
			switch (arg0){
				case 0:
					baseFragment = new Fragment1();
					break;
				case 1:
					baseFragment = new Fragment1_Copy();
					break;
				case 2:
					baseFragment = new Fragment3();
					break;
				case 3:
					baseFragment = new Fragment3();
					break;
			}
			sparseArray.put(arg0,baseFragment);
		}
		return baseFragment;
	}
	public static BaseFragment createFragment_Nouse(int arg0) {
		BaseFragment baseFragment = null;
		//如果当前集合中有fragment的时候直接根据索引去做获取
		if(hashMap.containsKey(arg0)){
			baseFragment = hashMap.get(arg0);
		}else{
			switch (arg0) {
			case 0:
				baseFragment = new Fragment1();
				break;
			case 1:
				baseFragment = new Fragment1_Copy();
				break;
			case 2:
				baseFragment = new Fragment3();
				break;
			case 3:
				baseFragment = new Fragment3();
				break;
			}
			hashMap.put(arg0,baseFragment);
		}
		return baseFragment;
	}

}
