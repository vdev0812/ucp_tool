package com.example.ucp_tool;

import static com.example.ucp_tool.MainActivity.vaf;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class VAFFragment extends Fragment {

    EditText edt_f1, edt_f2, edt_f3, edt_f4, edt_f5, edt_f6, edt_f7, edt_f8, edt_f9, edt_f10, edt_f11, edt_f12, edt_f13, edt_f14;
    AppCompatButton btn_caculate_vaf;
    TextView tv_vaf_result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_v_a_f, container, false);
        edt_f1 = view.findViewById(R.id.edt_f1);
        edt_f2 = view.findViewById(R.id.edt_f2);
        edt_f3 = view.findViewById(R.id.edt_f3);
        edt_f4 = view.findViewById(R.id.edt_f4);
        edt_f5 = view.findViewById(R.id.edt_f5);
        edt_f6 = view.findViewById(R.id.edt_f6);
        edt_f7 = view.findViewById(R.id.edt_f7);
        edt_f8 = view.findViewById(R.id.edt_f8);
        edt_f9 = view.findViewById(R.id.edt_f9);
        edt_f10 = view.findViewById(R.id.edt_f10);
        edt_f11 = view.findViewById(R.id.edt_f11);
        edt_f12 = view.findViewById(R.id.edt_f12);
        edt_f13 = view.findViewById(R.id.edt_f13);
        edt_f14 = view.findViewById(R.id.edt_f14);
        btn_caculate_vaf = view.findViewById(R.id.btn_caculate_vaf);
        tv_vaf_result = view.findViewById(R.id.tv_vaf_result);

        btn_caculate_vaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_f1.getText().toString().length() == 0) edt_f1.setText("0");
                if(edt_f2.getText().toString().length() == 0) edt_f2.setText("0");
                if(edt_f3.getText().toString().length() == 0) edt_f3.setText("0");
                if(edt_f4.getText().toString().length() == 0) edt_f4.setText("0");
                if(edt_f5.getText().toString().length() == 0) edt_f5.setText("0");
                if(edt_f6.getText().toString().length() == 0) edt_f6.setText("0");
                if(edt_f7.getText().toString().length() == 0) edt_f7.setText("0");
                if(edt_f8.getText().toString().length() == 0) edt_f8.setText("0");
                if(edt_f9.getText().toString().length() == 0) edt_f9.setText("0");
                if(edt_f10.getText().toString().length() == 0) edt_f10.setText("0");
                if(edt_f11.getText().toString().length() == 0) edt_f11.setText("0");
                if(edt_f12.getText().toString().length() == 0) edt_f12.setText("0");
                if(edt_f13.getText().toString().length() == 0) edt_f13.setText("0");
                if(edt_f14.getText().toString().length() == 0) edt_f14.setText("0");

                double sumF = parseF(edt_f1) + parseF(edt_f2) + parseF(edt_f3)
                        + parseF(edt_f4) + parseF(edt_f5) + parseF(edt_f6)
                        + parseF(edt_f7) + parseF(edt_f8) + parseF(edt_f9)
                        + parseF(edt_f10) + parseF(edt_f11) + parseF(edt_f12)
                        + parseF(edt_f11) + parseF(edt_f4);
                DecimalFormat decimalFormat = new DecimalFormat("#,###");
                vaf = Math.round((double)(0.65+0.01*sumF) * 1000.0) / 1000.0;
                tv_vaf_result.setText("0.65 + 0.01*" + sumF + " = " + Math.round((double)(0.65+0.01*sumF) * 1000.0) / 1000.0);
            }
        });
        return view;
    }

    double parseF (EditText f){
        return Double.parseDouble(f.getText().toString().trim());
    }
}