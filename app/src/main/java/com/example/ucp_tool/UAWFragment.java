package com.example.ucp_tool;

import static com.example.ucp_tool.MainActivity.uaw;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UAWFragment extends Fragment {
    AppCompatButton btn_caculate_uaw;
    EditText simple_actor;
    EditText average_actor;
    EditText complex_actor;
    TextView uc_simple;
    TextView uc_average;
    TextView uc_complex;
    TextView result_simple;
    TextView result_average;
    TextView result_complex;
    TextView result_total;
    TableLayout table_result;
    int simple = 0;
    int average = 0;
    int complex = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_u_a_w, container, false);
        btn_caculate_uaw = view.findViewById(R.id.btn_caculate_uaw);
        simple_actor = view.findViewById(R.id.simple_actor);
        average_actor = view.findViewById(R.id.average_actor);
        complex_actor = view.findViewById(R.id.complex_actor);
        uc_simple = view.findViewById(R.id.uc_simple);
        uc_average = view.findViewById(R.id.uc_average);
        uc_complex = view.findViewById(R.id.uc_complex);
        table_result = view.findViewById(R.id.table_result);
        result_simple = view.findViewById(R.id.result_simple);
        result_average = view.findViewById(R.id.result_average);
        result_complex = view.findViewById(R.id.result_complex);
        result_total = view.findViewById(R.id.result_total);
        btn_caculate_uaw.setOnClickListener(v -> {
            if(simple_actor.getText().toString().length() == 0) simple_actor.setText("0");
            if(average_actor.getText().toString().length() == 0) average_actor.setText("0");
            if(complex_actor.getText().toString().length() == 0) complex_actor.setText("0");
            simple = Integer.parseInt(simple_actor.getText().toString().trim());
            average = Integer.parseInt(average_actor.getText().toString().trim());
            complex = Integer.parseInt(complex_actor.getText().toString().trim());

            uc_simple.setText(simple + "");
            uc_average.setText(average + "");
            uc_complex.setText(complex + "");

            result_simple.setText(simple*1 +"");
            result_average.setText(average*2 +"");
            result_complex.setText(complex*3 +"");
            uaw = (simple*1 + average*2 + complex*3);
            result_total.setText((simple*1 + average*2 + complex*3) +"");

            table_result.setVisibility(View.VISIBLE);
        });
        return view;
    }
}