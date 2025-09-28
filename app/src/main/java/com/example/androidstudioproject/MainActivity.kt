package com.example.androidstudioproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etTop: EditText
    private lateinit var etBottom: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnC: Button
    private lateinit var btnDel: Button
    private lateinit var btnPersent: Button
    private lateinit var btnUnmul: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnMul: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btnMinus: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btnPlus: Button
    private lateinit var btnRevers: Button
    private lateinit var btn0: Button
    private lateinit var btnDot: Button
    private lateinit var btnEq: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTop = findViewById(R.id.etTop)
        etBottom = findViewById(R.id.etBottom)
        tvResult = findViewById(R.id.tvResult)
        btnC = findViewById(R.id.btnC)
        btnDel = findViewById(R.id.btnDel)
        btnPersent = findViewById(R.id.btnPersent)
        btnUnmul = findViewById(R.id.btnUnmul)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnMul = findViewById(R.id.btnMul)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btnMinus = findViewById(R.id.btnMinus)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btnPlus = findViewById(R.id.btnPlus)
        btnRevers = findViewById(R.id.btnRevers)
        btn0 = findViewById(R.id.btn0)
        btnDot = findViewById(R.id.btnDot)
        btnEq = findViewById(R.id.btnEq)

        btnC.setOnClickListener(this)
        btnDel.setOnClickListener(this)
        btnPersent.setOnClickListener(this)
        btnUnmul.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnMul.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnRevers.setOnClickListener(this)
        btn0.setOnClickListener(this)
        btnDot.setOnClickListener(this)
        btnEq.setOnClickListener(this)
        }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9, R.id.btnDot -> {
                val b = v as Button
                etBottom.append(b.text)
            }

            R.id.btnC -> {
                etTop.text.clear()
                etBottom.text.clear()
                tvResult.text = "Result"
            }

            R.id.btnDel -> {
                val str = etBottom.text.toString()
                if (str.isNotEmpty()){
                    etBottom.setText(str.substring(0, str.length - 1))
                }
            }

            R.id.btnPlus, R.id.btnUnmul, R.id.btnMinus,
            R.id.btnMul, R.id.btnPersent ->{
                etTop.setText(etBottom.text.toString())
                etBottom.text.clear()
                tvResult.text = (v as Button).text
            }

            R.id.btnEq -> {
                val top = etTop.text.toString().toDoubleOrNull() ?: 0.0
                val bottom = etBottom.text.toString().toDoubleOrNull() ?: 0.0

                val op = tvResult.text.toString()

                val res = when (op){
                    "+" -> top + bottom
                    "-" -> top - bottom
                    "x" -> top * bottom
                    "÷" -> if (bottom != 0.0) top / bottom else Double.NaN
                    "%" -> top % bottom
                    else -> 0.0
                }
                tvResult.text = res.toString()
            }
        }

    }

}
