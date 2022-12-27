package com;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.all.R;

public class AlertDialog_Fragment extends Fragment {
	Button button;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_alertdialog, container, false);
		Button button2 = (Button) view.findViewById(R.id.alert_btnnn);
		this.button = button2;
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				AlertDialog_Fragment.this.alert();
			}
		});
		return view;
	}

	/* access modifiers changed from: 0000 */
	public void alert() {
		Builder builder = new Builder(getContext());
		builder.setIcon(R.drawable.alert);
		builder.setTitle("Exit");
		builder.setCancelable(false);
		builder.setMessage("Are want to sure to exit ?");
		builder.setNegativeButton("No", null);
		builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(AlertDialog_Fragment.this.getActivity(), "You Clicked Ok",Toast.LENGTH_SHORT).show();
			}
		});
		builder.show();
	}
}