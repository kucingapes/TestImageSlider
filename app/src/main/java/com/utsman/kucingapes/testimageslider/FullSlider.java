package com.utsman.kucingapes.testimageslider;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;


public class FullSlider extends AppCompatActivity {

    private ViewPager fullSlider;
    private AdapterFull adapterFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_slider);
        fullSlider = findViewById(R.id.full_slider);
        adapterFull = new AdapterFull(this);
        fullSlider.setAdapter(adapterFull);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("posisi", 0);

        fullSlider.setCurrentItem(pos);
    }

    private class AdapterFull extends PagerAdapter {
        private Context context;
        private LayoutInflater inflater;

        public AdapterFull(Context context) {
            this.context = context;
        }

        int[] list_img = {
                R.drawable.kaget,
                R.drawable.ngantuk,
                R.drawable.molor
        };

        @Override
        public int getCount() {
            return list_img.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return (view == object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_full, container, false);

            PhotoView photoView = view.findViewById(R.id.img_full);
            photoView.setImageResource(list_img[position]);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((RelativeLayout) object);
        }
    }
}
