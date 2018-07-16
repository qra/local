package com.example.qrazy.qrazyapplication;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qrazy.qrazyapplication.tiankong.ReplaceSpan;
import com.example.qrazy.qrazyapplication.tiankong.SpansManager;
import com.example.qrazy.qrazyapplication.viewbinder.OneViewBinder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ReplaceSpan.OnClickListener{


    @BindView(R.id.rl_view)
    RecyclerView rlView;
    private MultiTypeAdapter adapter;
    private Items items;
    private SpansManager mSpansManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rlView.setLayoutManager(linearLayoutManager);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(rlView);
        adapter = new MultiTypeAdapter();

        List<AppInfo> appList = new ArrayList<AppInfo>();
        ApplicationInfoUtil.getAllProgramInfo(appList, this);
        adapter.register(AppInfo.class, new OneViewBinder());
        rlView.setAdapter(adapter);
        items = new Items();
        for (AppInfo app : appList){
            items.add(app);
        }
        adapter.setItems(items);
        adapter.notifyDataSetChanged();

        /*mSpansManager = new SpansManager(this,mTvContent,mEtInput);
        mSpansManager.doFillBlank(mTestStr);*/

    }

    @Override
    public void onClick(View view) {
        /*switch (view.getId()){
            case R.id.btn_submit:
                Toast.makeText(this, getMyAnswerStr(), Toast.LENGTH_LONG).show();
                break;
        }*/
    }

    //填空题点击响应事件
    @Override
    public void OnClick(TextView v, int id, ReplaceSpan span) {
        //mSpansManager.setData(mEtInput.getText().toString(),null, mSpansManager.mOldSpan);
        //mSpansManager.mOldSpan = id;
        //如果当前span身上有值，先赋值给et身上
        //mEtInput.setText(TextUtils.isEmpty(span.mText)?"":span.mText);
        //mEtInput.setSelection(span.mText.length());
        span.mText = "";
        //通过rf计算出et当前应该显示的位置
        RectF rf = mSpansManager.drawSpanRect(span);
        //设置EditText填空题中的相对位置
        mSpansManager.setEtXY(rf);
        mSpansManager.setSpanChecked(id);
    }

    private String getMyAnswerStr(){
       // mSpansManager.setLastCheckedSpanText(mEtInput.getText().toString());
        return mSpansManager.getMyAnswer().toString();
    }


}
