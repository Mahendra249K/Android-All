package com.all;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Menu extends AppCompatActivity implements OnGestureListener {

    ArrayAdapter arrayAdapter;
    BottomSheetDialog bottomSheetDialog;
    LinearLayout call;
    LinearLayout facebook;
    GestureDetector gestureDetector;
    LinearLayout instagram;
    ListView list_item;
    LinearLayout map;
    String[] name = {"One", "Two", "Three", "Four", "Five", "Six", "Sevan", "Eight", "Nine"};
    TextView popupmenu;
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
        setContentView(R.layout.activity_menu);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gestureDetector = new GestureDetector(this, this);
        popupmenu = (TextView) findViewById(R.id.popupmenu);
        list_item = (ListView) findViewById(R.id.list_item);

        setBottomsheet();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, name);
        list_item.setAdapter(arrayAdapter);

        registerForContextMenu(list_item);

        popupmenu.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(Menu.this, popupmenu);
                popupMenu.getMenuInflater().inflate(R.menu.option_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.one) {
                            Menu.this.startActivity(new Intent(Menu.this, Basic.class));
                            Menu.this.finish();
                        }
                        if (item.getItemId() == R.id.mmm) {
                            Toast.makeText(Menu.this, "Menu CLicked", Toast.LENGTH_LONG).show();
                        }
                        return false;
                    }
                });
            }
        });
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderIcon(R.drawable.menu);
        menu.setHeaderTitle("Select one");
        menu.add(0, v.getId(), 1, "insert");
        menu.add(0, v.getId(), 2, "update");
        menu.add(0, v.getId(), 3, "delete");
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "insert") {
            Toast.makeText(this, "Inseted", Toast.LENGTH_SHORT).show();
        }
        if (item.getTitle() == "delete") {
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);

       // for search view
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setQueryHint("Search here...");
        searchView.setOnQueryTextListener(new OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            public boolean onQueryTextChange(String newText) {
                Menu.this.arrayAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            finish();
        }
        if (item.getItemId() == R.id.one) {
            Toast.makeText(this, "One Clicked", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.four) {
            Toast.makeText(this, "Four Clicked", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.three) {
            this.bottomSheetDialog.show();
        }
        if (item.getItemId() == R.id.mmm) {
            Toast.makeText(this, "Menu Image Clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void setBottomsheet() {
        View view = LayoutInflater.from(this).inflate(R.layout.bottomsheet_1, null);
        BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
        this.bottomSheetDialog = bottomSheetDialog2;
        bottomSheetDialog2.setContentView(view);
        this.whatsapp = (LinearLayout) view.findViewById(R.id.whatsapp);
        this.facebook = (LinearLayout) view.findViewById(R.id.facebook);
        this.twitter = (LinearLayout) view.findViewById(R.id.twitter);
        this.instagram = (LinearLayout) view.findViewById(R.id.instagram);
        this.map = (LinearLayout) view.findViewById(R.id.map);
        this.call = (LinearLayout) view.findViewById(R.id.call);
        this.whatsapp.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=+91 9909087670"));
                Menu.this.startActivity(intent);
                Menu.this.bottomSheetDialog.dismiss();
            }
        });
        this.facebook.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("fb://profile/+ https://www.facebook.com/profile.php?id=100015800556691"));
                Menu.this.startActivity(intent);
                Menu.this.bottomSheetDialog.dismiss();
            }
        });
        this.instagram.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://instagram.com/_.mahendra_boxer?igshid=1ll10ts6gkvkz"));
                    Menu.this.startActivity(intent);
                    Menu.this.bottomSheetDialog.dismiss();
                } catch (Exception e) {
                    Toast.makeText(Menu.this, "Please Insatall Instagram App...", Toast.LENGTH_SHORT).show();
                    Menu.this.bottomSheetDialog.dismiss();
                }
            }
        });
        this.call.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("tel:+91 9909087670"));
                Menu.this.startActivity(intent);
                Menu.this.bottomSheetDialog.dismiss();
            }
        });
        this.map.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("geo:21.212697,72.839776"));
                Menu.this.startActivity(intent);
                Menu.this.bottomSheetDialog.dismiss();
            }
        });
        this.twitter.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Menu.this, "Bhai Santi rakh Set Krvanu baki Che ...", Toast.LENGTH_SHORT).show();
                Menu.this.bottomSheetDialog.dismiss();
            }
        });
    }

    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        int action = event.getAction();
        if (action == Toast.LENGTH_SHORT) {
            this.x1 = event.getX();
            this.y1 = event.getY();
        } else if (action == 1) {
            this.x2 = event.getX();
            float y = event.getY();
            this.y2 = y;
            float valueY = y - this.y1;
            if (Math.abs(this.x2 - this.x1) > 150.0f) {
                if (this.x2 > this.x1) {
                    Toast.makeText(this, "Left to Right Swipe", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Right to left Swipe", Toast.LENGTH_SHORT).show();
                }
            } else if (Math.abs(valueY) > 150.0f) {
                if (this.y2 > this.y1) {
                    Toast.makeText(this, "Bottom Swipe", Toast.LENGTH_SHORT).show();
                } else {
                    this.bottomSheetDialog.show();
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
        return false;
    }

    public void onLongPress(MotionEvent e) {
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
