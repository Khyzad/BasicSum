package com.example.firstproject;

enum Buttons {
    btn0("0"),
    btn1("1"),
    btn2("2"),
    btn3("3"),
    btn4("4"),
    btn5("5"),
    btn6("6"),
    btn7("7"),
    btn8("8"),
    btn9("9"),
    btnPlus("+"),
    btnMinus("-"),
    btnMultiply("*"),
    btnDivide("/"),
    btnEqual("="),
    btnDecimal("."),
    btnBackspace(""),
    btnPower("^"),
    btnClear("_");

    protected String Value;
    Buttons(String value){
        this.Value = value;
    }
}