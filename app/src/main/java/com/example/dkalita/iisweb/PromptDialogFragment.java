package com.example.dkalita.iisweb;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dkalita.R;

public class PromptDialogFragment extends DialogFragment implements View.OnClickListener
{
	public static final String ADD_SYM_CMD = "ADD_SYM_CMD";
	public static final String DEL_SYM_CMD = "DEL_SYM_CMD";

	public static PromptDialogFragment
	newInstance(String prompt)
	{
		PromptDialogFragment pdf = new PromptDialogFragment();
		Bundle bundle = new Bundle();
		bundle.putString("prompt",prompt);
		pdf.setArguments(bundle);
		
		return pdf;
	}

	@Override
	public void onAttach(Activity act) {
		// If the activity we're being attached to has
		// not implemented the OnDialogDoneListener
		// interface, the following line will throw a
		// ClassCastException. This is the earliest we
		// can test if we have a well-behaved activity.
		try {
            OnDialogDoneListener test = (OnDialogDoneListener)act;
		}
		catch(ClassCastException cce) {
			// Here is where we fail gracefully.
		}
		super.onAttach(act);
	}

    @Override    
    public void onCreate(Bundle icicle)
    {
    	super.onCreate(icicle);
    	this.setCancelable(true);
        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        setStyle(style,theme);
    }

	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container,
							 Bundle icicle)
	{
		View v = inflater.inflate(R.layout.prompt_dialog, container, false);

		TextView tv = (TextView)v.findViewById(R.id.promptmessage);
		tv.setText(getArguments().getString("prompt"));

		Button dismissBtn = (Button)v.findViewById(R.id.btn_dismiss);
		dismissBtn.setOnClickListener(this);

		Button saveBtn = (Button)v.findViewById(R.id.btn_save);
		saveBtn.setOnClickListener(this);

		return v;
	}

	@Override
    public void onCancel(DialogInterface di) {
    	super.onCancel(di);
    }

    @Override
    public void onDismiss(DialogInterface di) {
    	super.onDismiss(di);
    }

    public void onClick(View v) 
	{
		OnDialogDoneListener act = (OnDialogDoneListener)getActivity();
		if (v.getId() == R.id.btn_save)
		{
			TextView tv = (TextView)getView().findViewById(R.id.inputtext);
			act.onDialogDone(this.getTag(), false, tv.getText());
			dismiss();
			return;
		}
		if (v.getId() == R.id.btn_dismiss)
		{
			act.onDialogDone(this.getTag(), true, null);
			dismiss();
			return;
		}
	}
}
