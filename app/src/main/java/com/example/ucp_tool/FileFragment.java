package com.example.ucp_tool;

import static com.example.ucp_tool.MainActivity.content;
import static com.example.ucp_tool.MainActivity.uaw;
import static com.example.ucp_tool.MainActivity.uucw;
import static com.example.ucp_tool.MainActivity.vaf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class FileFragment extends Fragment {

    TextView at_simple;
    TextView at_average;
    TextView at_complex;
    TextView at_result_simple;
    TextView at_result_average;
    TextView at_result_complex;
    TextView at_result_total;
    TextView uc_simple;
    TextView uc_average;
    TextView uc_complex;
    TextView result_simple;
    TextView result_average;
    TextView result_complex;
    TextView result_total;
    EditText edt_f1, edt_f2, edt_f3, edt_f4, edt_f5, edt_f6, edt_f7, edt_f8, edt_f9, edt_f10, edt_f11, edt_f12, edt_f13, edt_f14;
    TextView tv_vaf_result;
    TextView tv_uucp_result;
    TextView tv_ucp_result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_file, container, false);
        at_simple = view.findViewById(R.id.at_simple);
        at_average = view.findViewById(R.id.at_average);
        at_complex = view.findViewById(R.id.at_complex);
        at_result_simple = view.findViewById(R.id.at_result_simple);
        at_result_average = view.findViewById(R.id.at_result_average);
        at_result_complex = view.findViewById(R.id.at_result_complex);
        uc_simple = view.findViewById(R.id.uc_simple);
        uc_average = view.findViewById(R.id.uc_average);
        uc_complex = view.findViewById(R.id.uc_complex);
        result_simple = view.findViewById(R.id.result_simple);
        result_average = view.findViewById(R.id.result_average);
        result_complex = view.findViewById(R.id.result_complex);
        result_total = view.findViewById(R.id.result_total);
        at_result_total = view.findViewById(R.id.at_result_total);
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
        tv_vaf_result = view.findViewById(R.id.tv_vaf_result);
        tv_uucp_result = view.findViewById(R.id.tv_uucp_result);
        tv_ucp_result = view.findViewById(R.id.tv_ucp_result);

        uc_simple.setText(content[0]);
        uc_average.setText(content[1]);
        uc_complex.setText(content[2]);

        result_simple.setText(Integer.parseInt(content[0])*5 +"");
        result_average.setText(Integer.parseInt(content[1])*10 +"");
        result_complex.setText(Integer.parseInt(content[2])*15 +"");
        uucw = Integer.parseInt(content[0])*5 + Integer.parseInt(content[1])*10 + Integer.parseInt(content[2])*15;
        result_total.setText((Integer.parseInt(content[0])*5 + Integer.parseInt(content[1])*10 + Integer.parseInt(content[2])*15) +"");

        at_simple.setText(content[3]);
        at_average.setText(content[4]);
        at_complex.setText(content[5]);

        at_result_simple.setText(Integer.parseInt(content[3])*1 +"");
        at_result_average.setText(Integer.parseInt(content[4])*2 +"");
        at_result_complex.setText(Integer.parseInt(content[5])*3 +"");
        uaw = Integer.parseInt(content[3])*1 + Integer.parseInt(content[4])*2 + Integer.parseInt(content[5])*3;
        at_result_total.setText((Integer.parseInt(content[3])*1 + Integer.parseInt(content[4])*2 + Integer.parseInt(content[5])*3) +"");

        edt_f1.setText(content[6]);
        edt_f2.setText(content[7]);
        edt_f3.setText(content[8]);
        edt_f4.setText(content[9]);
        edt_f5.setText(content[10]);
        edt_f6.setText(content[11]);
        edt_f7.setText(content[12]);
        edt_f8.setText(content[13]);
        edt_f9.setText(content[14]);
        edt_f10.setText(content[15]);
        edt_f11.setText(content[16]);
        edt_f12.setText(content[17]);
        edt_f13.setText(content[18]);
        edt_f14.setText(content[19]);

        double sumF = Integer.parseInt(content[6])
                + Integer.parseInt(content[7])
                + Integer.parseInt(content[8])
                + Integer.parseInt(content[9])
                + Integer.parseInt(content[10])
                + Integer.parseInt(content[11])
                + Integer.parseInt(content[12])
                + Integer.parseInt(content[13])
                + Integer.parseInt(content[14]);
        vaf = Math.round((double)(0.65+0.01*sumF) * 1000.0) / 1000.0;
        tv_vaf_result.setText("0.65 + 0.01*" + sumF + " = " + Math.round((double)(0.65+0.01*sumF) * 1000.0) / 1000.0);

        tv_uucp_result.setText(uaw + " + " + uucw + " = " + (uaw + uucw));
        tv_ucp_result.setText((uaw + uucw) + " * " + vaf + " = " + ((uaw + uucw)*vaf));

        return view;
    }
}