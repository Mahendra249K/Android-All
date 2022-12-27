package com.all;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheet extends AppCompatActivity implements OnGestureListener {
    BottomSheetDialog bottomSheetDialog;
    Button bottom_sheet_btn;
    LinearLayout call;
    LinearLayout facebook;
    GestureDetector gestureDetector;
    LinearLayout instagram;
    LinearLayout map;
    LinearLayout twitter;
    LinearLayout whatsapp;

    /* renamed from: x1 */
    float x1;

    /* renamed from: x2 */
    float x2;

    /* renamed from: y1 */
    float y1;

    /* renamed from: y2 */
    float y2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bottomsheet);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Bottom Sheet");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gestureDetector = new GestureDetector(this, this);
        Button button = (Button) findViewById(R.id.bottom_sheet_btn);
        bottom_sheet_btn = button;

        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                bottomSheetDialog.show();
            }
        });
        setBottomsheet();
    }

    public void setBottomsheet() {
        View view = LayoutInflater.from(this).inflate(R.layout.bottomsheet_1, null);
        BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
        bottomSheetDialog = bottomSheetDialog2;
        bottomSheetDialog2.setContentView(view);
        whatsapp = (LinearLayout) view.findViewById(R.id.whatsapp);
        facebook = (LinearLayout) view.findViewById(R.id.facebook);
        twitter = (LinearLayout) view.findViewById(R.id.twitter);
        instagram = (LinearLayout) view.findViewById(R.id.instagram);
        map = (LinearLayout) view.findViewById(R.id.map);
        call = (LinearLayout) view.findViewById(R.id.call);
        whatsapp.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=+91 9909087670"));
                startActivity(intent);
                bottomSheetDialog.dismiss();
            }
        });
        facebook.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("fb://profile/+ https://www.facebook.com/profile.php?id=100015800556691"));
                startActivity(intent);
                bottomSheetDialog.dismiss();
            }
        });
        instagram.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://instagram.com/_.mahendra_boxer?igshid=1ll10ts6gkvkz"));
                    startActivity(intent);
                    bottomSheetDialog.dismiss();
                } catch (Exception e) {
                    Toast.makeText(BottomSheet.this, "Please Insatall Instagram App...", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                }
            }
        });
        call.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("tel:+91 9909087670"));
                startActivity(intent);
                bottomSheetDialog.dismiss();
            }
        });
        map.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("geo:21.212697,72.839776"));
                startActivity(intent);
                bottomSheetDialog.dismiss();
            }
        });
        twitter.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(BottomSheet.this, "Bhai Santi rakh Set Krvanu baki Che ...", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        int action = event.getAction();
        if (action == 0) {
            x1 = event.getX();
            y1 = event.getY();
        } else if (action == 1) {
            x2 = event.getX();
            float y = event.getY();
            y2 = y;
            float valueY = y - y1;
            if (Math.abs(x2 - x1) > 150.0f) {
                if (x2 > x1) {
                    Toast.makeText(this, "Left to Right Swipe", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Right to left Swipe", Toast.LENGTH_SHORT).show();
                }
            } else if (Math.abs(valueY) > 150.0f) {
                if (y2 > y1) {
                    Toast.makeText(this, "Bottom Swipe", Toast.LENGTH_SHORT).show();
                } else {
                    bottomSheetDialog.show();
                }
            }
        }
        return super.onTouchEvent(event);
    }

    public boolean onDown(MotionEvent e) {
        return false;
    }

    public void onShowPress(MotionEvent e) {
    }

    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Toast.makeText(this, "longggggg", Toast.LENGTH_SHORT).show();
        return false;
    }

    public void onLongPress(MotionEvent e) {
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
