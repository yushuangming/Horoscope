package yushuangming.test01.u2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import yushuangming.test01.u2.R;
import yushuangming.test01.u2.view.WrapContentViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class JieMentFragment extends Fragment {
    private WrapContentViewPager vp;
    private String title;
    private int index;
    public JieMentFragment(String title, WrapContentViewPager vp,int index) {
        this.title = title;
        this.vp = vp;
        this.index = index;
    }

    public JieMentFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jie_ment, container, false);
        vp.setObjectForPosition(view,index);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv.setText(title);
        return view;
    }

}
