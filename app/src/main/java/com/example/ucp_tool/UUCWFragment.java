package com.example.ucp_tool;

import static com.example.ucp_tool.MainActivity.uucw;

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

public class UUCWFragment extends Fragment {
    AppCompatButton btn_caculate_uucw;
    EditText number_of_simple_use_cases;
    EditText number_of_average_use_cases;
    EditText number_of_complex_use_cases;
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
        View view = inflater.inflate(R.layout.fragment_u_u_c_w, container, false);
        btn_caculate_uucw = view.findViewById(R.id.btn_caculate_uucw);
        number_of_simple_use_cases = view.findViewById(R.id.number_of_simple_use_cases);
        number_of_average_use_cases = view.findViewById(R.id.number_of_average_use_cases);
        number_of_complex_use_cases = view.findViewById(R.id.number_of_complex_use_cases);
        uc_simple = view.findViewById(R.id.uc_simple);
        uc_average = view.findViewById(R.id.uc_average);
        uc_complex = view.findViewById(R.id.uc_complex);
        table_result = view.findViewById(R.id.table_result);
        result_simple = view.findViewById(R.id.result_simple);
        result_average = view.findViewById(R.id.result_average);
        result_complex = view.findViewById(R.id.result_complex);
        result_total = view.findViewById(R.id.result_total);

        btn_caculate_uucw.setOnClickListener(v -> {
            if(number_of_simple_use_cases.getText().toString().length() == 0) number_of_simple_use_cases.setText("0");
            if(number_of_average_use_cases.getText().toString().length() == 0) number_of_average_use_cases.setText("0");
            if(number_of_complex_use_cases.getText().toString().length() == 0) number_of_complex_use_cases.setText("0");
            simple = Integer.parseInt(number_of_simple_use_cases.getText().toString().trim());
            average = Integer.parseInt(number_of_average_use_cases.getText().toString().trim());
            complex = Integer.parseInt(number_of_complex_use_cases.getText().toString().trim());

            uc_simple.setText(simple + "");
            uc_average.setText(average + "");
            uc_complex.setText(complex + "");

            result_simple.setText(simple*5 +"");
            result_average.setText(average*10 +"");
            result_complex.setText(complex*15 +"");
            uucw = (simple*5 + average*10 + complex*15);
            result_total.setText((simple*5 + average*10 + complex*15) +"");

            table_result.setVisibility(View.VISIBLE);
        });
        return view;
    }
}