package com.example.banner2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.RotateYTransformer;
import com.youth.banner.transformer.ZoomOutPageTransformer;

import java.io.StringReader;

public class MainActivity extends AppCompatActivity {
    private String[] url = new String[5];
    private DataBing dataBing;
    private Banner banner;
    private Banner banner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = getResources().getStringArray(R.array.url);
        dataBing = new DataBing(url);
        banner = (Banner) findViewById(R.id.banner);
        banner2 = (Banner) findViewById(R.id.banner2);
        initBanner();
        initBanner2();

    }
    public void initBanner(){
        banner.setLoopTime(2000);
        banner.setPageTransformer(new ZoomOutPageTransformer());

        banner.setAdapter(new BannerImageAdapter<DataBing>(DataBing.getTestData3()) {
            @Override
            public void onBindView(BannerImageHolder holder, DataBing data, int position, int size) {
                Glide.with(holder.imageView)
                        .load(data.imageUrl)
                        .into(holder.imageView);
            }
        });
        banner.setIndicator(new CircleIndicator(this));
    }

    public void initBanner2(){
        banner2.setLoopTime(2000);
        banner2.setPageTransformer(new RotateYTransformer());
        banner2.setAdapter(new BannerImageAdapter<DataBing>(DataBing.getTestData3()) {
            @Override
            public void onBindView(BannerImageHolder holder, DataBing data, int position, int size) {
                Glide.with(holder.imageView)
                        .load(data.imageUrl)
                        .into(holder.imageView);
            }
        });
        banner2.setIndicator(new CircleIndicator(this));
        banner2.addBannerLifecycleObserver(this);

    }
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner2.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //停止轮播
        banner2.stop();
    }
}