package com.all;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

public class ImageSlider_Viewpager extends AppCompatActivity {
    ImageView[] dots;
    LinearLayout dots_indicator;
    int dotscount;
    ViewPager image_slider_viewpager;

    class Adpter_ViewPager_ImageSlider extends PagerAdapter {
        private Context context;
        Integer[] image = {Integer.valueOf(R.drawable.iiiiii), Integer.valueOf(R.drawable.grid_view), Integer.valueOf(R.drawable.whatsapp), Integer.valueOf(R.drawable.radio_button)};
        private LayoutInflater layoutInflater;

        public Adpter_ViewPager_ImageSlider(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            return this.image.length;
        }

        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater layoutInflater2 = (LayoutInflater) this.context.getSystemService(LAYOUT_INFLATER_SERVICE);
            this.layoutInflater = layoutInflater2;
            View view = layoutInflater2.inflate(R.layout.viewpager_imageflipper_background, null);
            ((ImageView) view.findViewById(R.id.viewpager_imageflipper_image)).setImageResource(this.image[position].intValue());
            ((ViewPager) container).addView(view);
            return view;
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageslider_viewpager);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Image Slider");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        image_slider_viewpager = (ViewPager) findViewById(R.id.image_slider_viewpager);
        dots_indicator = (LinearLayout) findViewById(R.id.dots_indicator);

        Adpter_ViewPager_ImageSlider adpterViewPagerImageSlider = new Adpter_ViewPager_ImageSlider(this);
        image_slider_viewpager.setAdapter(adpterViewPagerImageSlider);

        int count = adpterViewPagerImageSlider.getCount();
        dotscount = count;
        dots = new ImageView[count];

        for (int i = 0; i < this.dotscount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_not_dots));
            LayoutParams params = new LayoutParams(-2, -2);
            params.setMargins(8, 0, 8, 0);
            dots_indicator.addView(this.dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dots));
        image_slider_viewpager.addOnPageChangeListener(new OnPageChangeListener() {

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                for (int i = 0; i < ImageSlider_Viewpager.this.dotscount; i++) {
                    ImageSlider_Viewpager.this.dots[i].setImageDrawable(ContextCompat.getDrawable(ImageSlider_Viewpager.this.getApplicationContext(), R.drawable.active_not_dots));
                }
                ImageSlider_Viewpager.this.dots[position].setImageDrawable(ContextCompat.getDrawable(ImageSlider_Viewpager.this.getApplicationContext(), R.drawable.active_dots));
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
