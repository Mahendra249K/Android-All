package com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView.CommaTokenizer;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.all.R;

public class EditText_Fragment extends Fragment {

    AutoCompleteTextView autoCompleteTextView;
    TextView auto_complate_text_view;
    Button change_text_btn;
    EditText email_edit_text;
    TextView email_textView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    TextView multi_auto_complate_text_view;
    EditText numeric_password_edit_text;
    TextView numeric_password_textView;
    EditText password_edit_text;
    TextView password_textView;
    EditText phoneno_edit_text;
    TextView phono_textView;
    EditText simple_edit_text;
    TextView simple_textView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edittext, container, false);

        simple_textView = (TextView) view.findViewById(R.id.simple_textView);
        password_textView = (TextView) view.findViewById(R.id.password_textView);
        numeric_password_textView = (TextView) view.findViewById(R.id.numeric_password_textView);
        email_textView = (TextView) view.findViewById(R.id.email_textView);
        phono_textView = (TextView) view.findViewById(R.id.phono_textView);
        auto_complate_text_view = (TextView) view.findViewById(R.id.auto_complate_text_view);
        multi_auto_complate_text_view = (TextView) view.findViewById(R.id.multi_auto_complate_text_view);
        simple_edit_text = (EditText) view.findViewById(R.id.simple_edit_text);
        password_edit_text = (EditText) view.findViewById(R.id.password_edit_text);
        numeric_password_edit_text = (EditText) view.findViewById(R.id.numeric_password_edit_text);
        email_edit_text = (EditText) view.findViewById(R.id.email_edit_text);
        phoneno_edit_text = (EditText) view.findViewById(R.id.phoneno_edit_text);
        autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.auto_Complete_edit_text);
        multiAutoCompleteTextView = (MultiAutoCompleteTextView) view.findViewById(R.id.multi_auto_complete_edit_text);
        change_text_btn = (Button) view.findViewById(R.id.change_text);


        this.autoCompleteTextView.setAdapter(new ArrayAdapter(getContext(), 17367043, new String[]{"hiiii", "aaaaaaa", "bbbbbbbbb", "cccccccc", "ddddddd", "eeeeeeeee", "fffffffff", "gggggggg", "hhhhhhh", "iiiiiiii", "jjjjjj", "kkkkkkk", "lllllll", "bbbbbb", "ooooo", "pppppp", "qqqqqq", "rrrr", "sssssss", "ttttt", "uuuu", "vvvvv", "xxxxxx", "wwwwwwww", "yyyyyyyy", "zzzzzzzz", "Hiiiiii", "byyyy", "Good", "Nice", "wahhh", "saras", "okkkk", "Noooo", "janebee", "heheheheheh"}));
        this.multiAutoCompleteTextView.setAdapter(new ArrayAdapter(getContext(), 17367043, new String[]{"hiiii", "aaaaaaa", "bbbbbbbbb", "cccccccc", "ddddddd", "eeeeeeeee", "fffffffff", "gggggggg", "hhhhhhh", "iiiiiiii", "jjjjjj", "kkkkkkk", "lllllll", "bbbbbb", "ooooo", "pppppp", "qqqqqq", "rrrr", "sssssss", "ttttt", "uuuu", "vvvvv", "xxxxxx", "wwwwwwww", "yyyyyyyy", "zzzzzzzz", "Hiiiiii", "byyyy", "Good", "Nice", "wahhh", "saras", "okkkk", "Noooo", "janebee", "heheheheheh"}));
        this.multiAutoCompleteTextView.setTokenizer(new CommaTokenizer());

        this.change_text_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String a = EditText_Fragment.this.simple_edit_text.getText().toString();
                String b = EditText_Fragment.this.password_edit_text.getText().toString();
                String c = EditText_Fragment.this.numeric_password_edit_text.getText().toString();
                String d = EditText_Fragment.this.email_edit_text.getText().toString();
                String e = EditText_Fragment.this.phoneno_edit_text.getText().toString();
                String f = EditText_Fragment.this.autoCompleteTextView.getText().toString();
                String g = EditText_Fragment.this.multiAutoCompleteTextView.getText().toString();
                EditText_Fragment.this.simple_textView.setText(a);
                EditText_Fragment.this.password_textView.setText(b);
                EditText_Fragment.this.numeric_password_textView.setText(c);
                EditText_Fragment.this.email_textView.setText(d);
                EditText_Fragment.this.phono_textView.setText(e);
                EditText_Fragment.this.auto_complate_text_view.setText(f);
                EditText_Fragment.this.multi_auto_complate_text_view.setText(g);
            }
        });
        return view;
    }
}
