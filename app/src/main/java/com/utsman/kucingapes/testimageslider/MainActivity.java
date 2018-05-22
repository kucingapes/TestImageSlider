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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ViewPager slider;
    private AdapterSlider adapterSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slider = findViewById(R.id.slider_pager);
        adapterSlider = new AdapterSlider(this);
        slider.setAdapter(adapterSlider);
    }

    private class AdapterSlider extends PagerAdapter {
        private Context context;
        private LayoutInflater inflater;

        public AdapterSlider(Context context) {
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
            View view = inflater.inflate(R.layout.item_slider, container, false);

            ImageView imageView = view.findViewById(R.id.item_img);
            imageView.setImageResource(list_img[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FullSlider.class);
                    intent.putExtra("posisi", position);
                    startActivity(intent);
                }
            });
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((RelativeLayout) object);
        }
    }
}
