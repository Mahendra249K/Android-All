package com.all;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.AlertDialog_Fragment;
import com.Button_Fragment;
import com.CheckBox_Fragment;
import com.DatePicker_Fragment;
import com.EditText_Fragment;
import com.ImageView_Fragment;
import com.RadioButton_Fragment;
import com.Ratingbar_Fragment;
import com.Swich_Fragment;
import com.TextView_Fragment;
import com.TimePicker_Fragment;
import com.Toast_Fragment;
import com.Toggle_Fragment;

public class Basic extends AppCompatActivity {
    LinearLayout alertDialog;
    LinearLayout button;
    LinearLayout checkBox;
    LinearLayout datePicker;
    LinearLayout editText;
    Fragment fragment;
    LinearLayout imageView;
    LinearLayout radioButton;
    LinearLayout ratingBar;
    LinearLayout swicha;
    LinearLayout textView;
    LinearLayout timePicker;
    LinearLayout toast;
    LinearLayout toggle;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Text View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView = (LinearLayout) findViewById(R.id.text_View);
        editText = (LinearLayout) findViewById(R.id.edit_text);
        imageView = (LinearLayout) findViewById(R.id.imageView);
        button = (LinearLayout) findViewById(R.id.button);
        radioButton = (LinearLayout) findViewById(R.id.radio_button);
        checkBox = (LinearLayout) findViewById(R.id.checkbox);
        toast = (LinearLayout) findViewById(R.id.toast);
        swicha = (LinearLayout) findViewById(R.id.swich);
        toggle = (LinearLayout) findViewById(R.id.toggle);
        timePicker = (LinearLayout) findViewById(R.id.time_picker);
        datePicker = (LinearLayout) findViewById(R.id.date_picker);
        ratingBar = (LinearLayout) findViewById(R.id.rating_bar);
        alertDialog = (LinearLayout) findViewById(R.id.alert_diloag);
        textView.setEnabled(false);

        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(false);
                editText.setEnabled(true);
                imageView.setEnabled(true);
                button.setEnabled(true);
                radioButton.setEnabled(true);
                checkBox.setEnabled(true);
                toast.setEnabled(true);
                swicha.setEnabled(true);
                toggle.setEnabled(true);
                timePicker.setEnabled(true);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Text View");

                fragment = new TextView_Fragment();
                loadfragment(fragment);
            }
        });
        this.editText.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(false);
                imageView.setEnabled(true);
                button.setEnabled(true);
                radioButton.setEnabled(true);
                checkBox.setEnabled(true);
                toast.setEnabled(true);
                swicha.setEnabled(true);
                toggle.setEnabled(true);
                timePicker.setEnabled(true);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Edit Text");
                fragment = new EditText_Fragment();
                loadfragment(fragment);
            }
        });
        this.imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(true);
                imageView.setEnabled(false);
                button.setEnabled(true);
                radioButton.setEnabled(true);
                checkBox.setEnabled(true);
                toast.setEnabled(true);
                swicha.setEnabled(true);
                toggle.setEnabled(true);
                timePicker.setEnabled(true);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Image View");
                fragment = new ImageView_Fragment();
                loadfragment(fragment);
            }
        });
        this.button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(true);
                imageView.setEnabled(true);
                button.setEnabled(false);
                radioButton.setEnabled(true);
                checkBox.setEnabled(true);
                toast.setEnabled(true);
                swicha.setEnabled(true);
                toggle.setEnabled(true);
                timePicker.setEnabled(true);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Button");
                fragment = new Button_Fragment();
                loadfragment(fragment);
            }
        });
        this.radioButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(true);
                imageView.setEnabled(true);
                button.setEnabled(true);
                radioButton.setEnabled(false);
                checkBox.setEnabled(true);
                toast.setEnabled(true);
                swicha.setEnabled(true);
                toggle.setEnabled(true);
                timePicker.setEnabled(true);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Radio Button");
                fragment = new RadioButton_Fragment();
                loadfragment(fragment);
            }
        });
        this.checkBox.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(true);
                imageView.setEnabled(true);
                button.setEnabled(true);
                radioButton.setEnabled(true);
                checkBox.setEnabled(false);
                toast.setEnabled(true);
                swicha.setEnabled(true);
                toggle.setEnabled(true);
                timePicker.setEnabled(true);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Check Box");
                fragment = new CheckBox_Fragment();
                loadfragment(fragment);
            }
        });
        this.toast.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(true);
                imageView.setEnabled(true);
                button.setEnabled(true);
                radioButton.setEnabled(true);
                checkBox.setEnabled(true);
                toast.setEnabled(false);
                swicha.setEnabled(true);
                toggle.setEnabled(true);
                timePicker.setEnabled(true);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Toast");
                fragment = new Toast_Fragment();
                loadfragment(fragment);
            }
        });
        this.swicha.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(true);
                imageView.setEnabled(true);
                button.setEnabled(true);
                radioButton.setEnabled(true);
                checkBox.setEnabled(true);
                toast.setEnabled(true);
                swicha.setEnabled(false);
                toggle.setEnabled(true);
                timePicker.setEnabled(true);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Swich");
                fragment = new Swich_Fragment();
                loadfragment(fragment);
            }
        });
        this.toggle.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(true);
                imageView.setEnabled(true);
                button.setEnabled(true);
                radioButton.setEnabled(true);
                checkBox.setEnabled(true);
                toast.setEnabled(true);
                swicha.setEnabled(true);
                toggle.setEnabled(false);
                timePicker.setEnabled(true);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Toggle");
                fragment = new Toggle_Fragment();
                loadfragment(fragment);
            }
        });
        this.timePicker.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(true);
                imageView.setEnabled(true);
                button.setEnabled(true);
                radioButton.setEnabled(true);
                checkBox.setEnabled(true);
                toast.setEnabled(true);
                swicha.setEnabled(true);
                toggle.setEnabled(true);
                timePicker.setEnabled(false);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Time Picker");
                fragment = new TimePicker_Fragment();
                loadfragment(fragment);
            }
        });
        this.datePicker.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(true);
                imageView.setEnabled(true);
                button.setEnabled(true);
                radioButton.setEnabled(true);
                checkBox.setEnabled(true);
                toast.setEnabled(true);
                swicha.setEnabled(true);
                toggle.setEnabled(true);
                timePicker.setEnabled(true);
                datePicker.setEnabled(false);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Date Picker");
                fragment = new DatePicker_Fragment();
                loadfragment(fragment);
            }
        });
        this.ratingBar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(true);
                imageView.setEnabled(true);
                button.setEnabled(true);
                radioButton.setEnabled(true);
                checkBox.setEnabled(true);
                toast.setEnabled(true);
                swicha.setEnabled(true);
                toggle.setEnabled(true);
                timePicker.setEnabled(true);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(false);
                alertDialog.setEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Rating Bar");

                fragment = new Ratingbar_Fragment();
                loadfragment(fragment);
            }
        });
        this.alertDialog.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                textView.setEnabled(true);
                editText.setEnabled(true);
                imageView.setEnabled(true);
                button.setEnabled(true);
                radioButton.setEnabled(true);
                checkBox.setEnabled(true);
                toast.setEnabled(true);
                swicha.setEnabled(true);
                toggle.setEnabled(true);
                timePicker.setEnabled(true);
                datePicker.setEnabled(true);
                ratingBar.setEnabled(true);
                alertDialog.setEnabled(false);
                getSupportActionBar().setTitle((CharSequence) "Alert Dialog");

                fragment = new AlertDialog_Fragment();
                loadfragment(fragment);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadfragment(Fragment fragment2) {
        if (fragment2 != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.basic_fragment, fragment2);
            fragmentTransaction.commit();
        }
    }
}
