// Yue Li yueli1@stanford.edu
// Tip Calculator: calculates either 15, 18, or 20 percent tip
// Gives the total and the tip amount

package com.example.yueli.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private String total = "";
    private String tipString = "";
    private double sum = 0.0;
    private String s = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView totalView = (TextView) findViewById(R.id.total);
        totalView.setText("Amount Entered: $0.00");
        TextView tipView = (TextView) findViewById(R.id.tipAmount);
        tipView.setText("Tip: $0.00");
    }


    public void onClick(View view) {
        TextView totalView = (TextView) findViewById(R.id.total);
        int b = view.getId();
        Button button = (Button) findViewById(b);
        s = button.getText().toString();
        total = total + s;
        totalView.setText("Amount Entered: $" + total);
        sum = Double.parseDouble(total);
    }

    public void tipClick(View view) {
        TextView totalView = (TextView) findViewById(R.id.total);
        int b = view.getId();
        Button button = (Button) findViewById(b);
        s = button.getText().toString();
        double percent = 0;
        if(s.equals("15%")) {
            percent = 0.15;
        } else if (s.equals("18%")) {
            percent = 0.18;
        } else {
            percent = 0.2;
        }
        double tipSum = tipTotal(sum, percent);
        totalView.setText("Total Pay: $" + total);
        double tip = tipAmount(sum, percent);
        TextView tipView = (TextView) findViewById(R.id.tipAmount);
        tipView.setText("Tip: $" + tipString);

    }

    public void clearClick(View view) {
        total = "";
        tipString = "";
        sum = 0.0;
        TextView totalView = (TextView) findViewById(R.id.total);
        totalView.setText("Total Pay: $0.00");
        TextView tipView = (TextView) findViewById(R.id.tipAmount);
        tipView.setText("Tip: $0.00");
    }

    public double tipTotal(double sum, double percent) {
        double newSum = (1 + percent) * sum;
        DecimalFormat df = new DecimalFormat("0.00");
        total = df.format(newSum);
        return (1 + percent) * newSum;
    }

    public double tipAmount(double sum, double percent) {
        double newSum = percent * sum;
        DecimalFormat df = new DecimalFormat("0.00");
        tipString = df.format(newSum);
        return percent * sum;
    }
}
