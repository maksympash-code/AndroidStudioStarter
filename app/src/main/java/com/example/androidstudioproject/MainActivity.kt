package com.example.androidstudioproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etInput: EditText
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

    private var firstOperand: Double? = null
    private var operator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etInput = findViewById(R.id.etInput)
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
                etInput.append(b.text)
            }

            R.id.btnPlus, R.id.btnMinus, R.id.btnMul,
            R.id.btnUnmul, R.id.btnPersent -> {
                firstOperand = etInput.text.toString().toDoubleOrNull()
                operator = (v as Button).text.toString()
                etInput.text.clear()
            }

            R.id.btnEq -> {
                val secondOperand = etInput.text.toString().toDoubleOrNull()
                val res = if (firstOperand != null && secondOperand != null && operator != null) {
                    when(operator){
                        "+" -> firstOperand!! + secondOperand
                        "-" -> firstOperand!! - secondOperand
                        "x" -> firstOperand!! * secondOperand
                        "÷" -> if (secondOperand == 0.0) Double.NaN else firstOperand!! / secondOperand
                        "%" -> firstOperand!! % secondOperand
                        else -> 0.0
                    }
                } else 0.0

                tvResult.setText("$firstOperand ${operator} $secondOperand = ${res}")
                etInput.text.clear()

                firstOperand = res
                etInput.setText(res.toString())
            }

            R.id.btnC -> {
                etInput.text.clear()
                tvResult.text = "Result"
                firstOperand = null
                operator = null
            }
        }

}
}
