package com.zcfeng.a2048;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    int a[] = new int[16];
    @BindView(R.id.gv)
    GridView gv;
    MyAdapter adapter;
    GestureDetector detector;
    public void reset(View v){
        for (int i=0;i<16;i++){
            a[i]=0;
        }
        GameManager.addRandom(a);
        adapter.notifyDataSetChanged();
    }
    private boolean isfailure() {
        for(int i:a){
            if(i==0)
                return false;
        }
        if(GameManager.check(a,1,4))return false;
        if(GameManager.check(a,-1,-4))return false;
        if(GameManager.check(a,4,1))return false;
        if(GameManager.check(a,-4,-1))return false;
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        detector=new GestureDetector(this,this);
        GameManager.addRandom(a);
        adapter=new MyAdapter(a);
        gv.setAdapter(adapter);
        gv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return  detector.onTouchEvent(motionEvent);
            }
        });
    }
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }
    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        boolean res=false;
         int i= (int) (motionEvent1.getX()-motionEvent.getX());
         int j=(int) (motionEvent1.getY()-motionEvent.getY());
        if(i*i>j*j){
            if(i>0)
                res=GameManager.action(a,-4,-1);
            else
                res=GameManager.action(a,4,1);
        }
        else
        {
            if(j>0)
                res=GameManager.action(a,-1,-4);
            else
                res=GameManager.action(a,1,4);
        }
        if(isfailure()){
            Toast.makeText(this,"你输了",Toast.LENGTH_SHORT).show();
        }
        if(res)
            GameManager.addRandom(a);
        adapter.notifyDataSetChanged();
        return true;
    }
}