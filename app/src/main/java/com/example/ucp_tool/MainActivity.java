package com.example.ucp_tool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btn_next, btn_back;
    int screen=0;
    static double uucw = 0;
    static double uaw = 0;
    static double uucp = 0;
    static double vaf = 0;
    static String[] content;
    AppCompatButton btn_input, btn_output;
    private static final int REQUEST_CODE = 123;
    String filename = "ucp.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_next = findViewById(R.id.btn_next);
        btn_back = findViewById(R.id.btn_back);
        btn_input = findViewById(R.id.btn_input);
        btn_output = findViewById(R.id.btn_output);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        UUCWFragment uucwFragment = new UUCWFragment();
        UAWFragment uawFragment = new UAWFragment();
        UUCPFragment uucpFragment = new UUCPFragment();
        VAFFragment vafFragment= new VAFFragment();
        ResultFragment resultFragment = new ResultFragment();

        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fileIn=openFileInput(filename);
                    InputStreamReader InputRead= new InputStreamReader(fileIn);
                    CSVReader reader = new CSVReader(InputRead);
                    String[] header = reader.readNext();
                    content = reader.readNext();

                    FileFragment fileFragment = new FileFragment();

                    FragmentManager fragmentManager1 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_container, fileFragment).commit();

                    Toast.makeText(MainActivity.this,"Đọc file thành công", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CsvValidationException e) {
                    e.printStackTrace();
                } catch (CsvException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.frame_container, uucwFragment).commit();
                screen = 0;
                btn_back.setBackgroundColor(Color.parseColor("#FFA2A2A2"));
                btn_next.setBackgroundColor(Color.parseColor("#4CAF50"));
            }
        });


        fragmentTransaction.replace(R.id.frame_container, uucwFragment);
        fragmentTransaction.commit();
        btn_back.setBackgroundColor(Color.parseColor("#FFA2A2A2"));
        btn_next.setOnClickListener(v -> {
            switch (screen){
                case 0:
                    FragmentManager fragmentManager1 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_container, uawFragment).commit();
                    btn_back.setBackgroundColor(Color.parseColor("#4CAF50"));
                    screen++;
                    break;
                case 1:
                    FragmentManager fragmentManager3 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                    fragmentTransaction3.replace(R.id.frame_container, vafFragment).commit();
                    btn_next.setBackgroundColor(Color.parseColor("#4CAF50"));
                    screen++;
                    break;
                case 2:
                    FragmentManager fragmentManager4 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction4 = fragmentManager4.beginTransaction();
                    fragmentTransaction4.replace(R.id.frame_container, resultFragment).commit();
                    btn_next.setBackgroundColor(Color.parseColor("#FFA2A2A2"));
                    screen++;
                    break;

                default:

            }

        });
        btn_back.setOnClickListener(v -> {
            switch (screen){
                case 1:
                    FragmentManager fragmentManager1 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_container, uucwFragment).commit();
                    btn_back.setBackgroundColor(Color.parseColor("#FFA2A2A2"));
                    screen--;
                    break;
                case 2:
                    FragmentManager fragmentManager3 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                    fragmentTransaction3.replace(R.id.frame_container, uawFragment).commit();
                    btn_next.setBackgroundColor(Color.parseColor("#4CAF50"));
                    screen--;
                    break;
                case 3:
                    FragmentManager fragmentManager4 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction4 = fragmentManager4.beginTransaction();
                    fragmentTransaction4.replace(R.id.frame_container, vafFragment).commit();
                    btn_next.setBackgroundColor(Color.parseColor("#4CAF50"));
                    screen--;
                    break;
                default:


            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (data != null && data.getData() != null) {


            }
        }
    }

    private void openFolder() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_CODE);
    }
}