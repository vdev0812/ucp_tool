package com.example.ucp_tool;

import static com.example.ucp_tool.MainActivity.uaw;
import static com.example.ucp_tool.MainActivity.uucw;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UUCPFragment extends Fragment {
    TextView tv_uucw;
    TextView tv_uaw;
    TextView tv_uucp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_u_u_c_p, container, false);
        tv_uucw = view.findViewById(R.id.tv_uucw);
        tv_uaw = view.findViewById(R.id.tv_uaw);
        tv_uucp = view.findViewById(R.id.tv_uucp);

        tv_uucw.setText(uucw + "");
        tv_uaw.setText(uaw + "");
        tv_uucp.setText((uaw+uucw) + "");
        return view;
    }
}