package com.example.ucp_tool;

import static com.example.ucp_tool.MainActivity.uaw;
import static com.example.ucp_tool.MainActivity.uucp;
import static com.example.ucp_tool.MainActivity.uucw;
import static com.example.ucp_tool.MainActivity.vaf;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class ResultFragment extends Fragment {

    EditText edt_uucw;
    EditText edt_uaw;
    EditText edt_vaf;
    AppCompatButton btn_caculate_vaf;
    TextView tv_uucp_result;
    TextView tv_ucp_result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        edt_uucw = view.findViewById(R.id.edt_uucw);
        edt_uaw = view.findViewById(R.id.edt_uaw);
        edt_vaf = view.findViewById(R.id.edt_vaf);
        btn_caculate_vaf = view.findViewById(R.id.btn_caculate_vaf);
        tv_uucp_result = view.findViewById(R.id.tv_uucp_result);
        tv_ucp_result = view.findViewById(R.id.tv_ucp_result);

        edt_uucw.setText(uucw +"" );
        edt_uaw.setText(uaw +"" );
        edt_vaf.setText(vaf +"" );
        btn_caculate_vaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_uucp_result.setText(uaw + " + " + uucw + " = " + (uaw + uucw));
                tv_ucp_result.setText((uaw + uucw) + " * " + vaf + " = " + ((uaw + uucw)*vaf));
            }
        });


        return view;
    }
}