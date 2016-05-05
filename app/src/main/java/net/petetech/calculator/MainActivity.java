package net.petetech.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class MainActivity extends AppCompatActivity {
    Evaluator eval = new Evaluator();
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button add;
    private Button sub;
    private Button multi;
    private Button div;
    private Button openB;
    private Button closeB;
    private Button equals;
    private Button delete;
    private Button zero;
    private Button lang;
    private boolean isFrench; // true if user has switch language to french
    private TextView ans;
    private String equation = "";
    private String frenchDel = "Effacer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (Button) findViewById(R.id.button);
        num2 = (Button) findViewById(R.id.button2);
        num3 = (Button) findViewById(R.id.button3);
        num4 = (Button) findViewById(R.id.button4);
        num5 = (Button) findViewById(R.id.button5);
        num6 = (Button) findViewById(R.id.button6);
        num7 = (Button) findViewById(R.id.button7);
        num8 = (Button) findViewById(R.id.button8);
        num9 = (Button) findViewById(R.id.button9);
        zero = (Button) findViewById(R.id.zero);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        openB = (Button) findViewById(R.id.openB);
        closeB = (Button) findViewById(R.id.closeB);
        multi = (Button) findViewById(R.id.multi);
        div = (Button) findViewById(R.id.div);
        equals = (Button) findViewById(R.id.equal);
        delete = (Button) findViewById(R.id.del);
        ans = (TextView) findViewById(R.id.ans);
        lang = (Button) findViewById(R.id.lang);
        ans.setText("");
        lang.setText("English");
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "1";
                ans.setText(equation);
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "2";
                ans.setText(equation);
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "3";
                ans.setText(equation);
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "4";
                ans.setText(equation);
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "5";
                ans.setText(equation);
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "6";
                ans.setText(equation);
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "7";
                ans.setText(equation);
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "8";
                ans.setText(equation);
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "9";
                ans.setText(equation);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "0";
                ans.setText(equation);
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    equation = eval.evaluate(equation);
                    ans.setText("= " + equation);
                } catch (EvaluationException e) {
                    ans.setText("Syntax Error");
                    equation = "";
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + " + ";
                ans.setText(equation);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + " - ";
                ans.setText(equation);
            }
        });
        openB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + "(";
                ans.setText(equation);
            }
        });
        closeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + ")";
                ans.setText(equation);
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + " * ";
                ans.setText(equation);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation = equation + " / ";
                ans.setText(equation);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    equation = equation.substring(0, equation.length() - 1);
                    ans.setText(equation);
                } catch (StringIndexOutOfBoundsException e) {
                    equation = "";
                    ans.setText(equation);
                }
            }
        });
        lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFrench) {
                    isFrench = true;
                    lang.setText("Français");
                    delete.setText(frenchDel);
                } else {
                    isFrench = false;
                    lang.setText("English");
                    delete.setText("Delete");
                }
            }
        });
    }

}
