package com.example.tippapp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun tipFun(){
    Row( modifier = Modifier
        .fillMaxWidth()) {
            tipInput()
//            outPut()
    }
}





@Composable
fun tipInput(){

    var inputNum by remember { mutableStateOf("") }
    var tipPer by remember { mutableStateOf("") }
    var tot by remember { mutableStateOf(0.00f) }

    var showDialog by remember { mutableStateOf(false) }

    var appGreen by remember { mutableStateOf(Color(red = 6, green = 89, blue = 16)) }
    var appRed by remember { mutableStateOf(Color(red = 227, green = 7, blue = 21)) }

    var amountInputColor by remember { mutableStateOf(appGreen) }
    var tipInputColor by remember { mutableStateOf(appGreen) }

    Column (modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxWidth()
        .padding(0.dp, 40.dp)){

        if(showDialog == true){
            AlertDialog(onDismissRequest = { showDialog = false }, confirmButton = {
//                tot= cal(inputNum, tipPer.toFloat())
//                var t = "%.2f".format(tot)
//                tot = t.toFloat()
            },
                text={
                    Column {
                        OutlinedTextField(         colors = TextFieldDefaults.colors(
                            focusedIndicatorColor  = tipInputColor,
                            unfocusedIndicatorColor = tipInputColor,
                            cursorColor = tipInputColor

                        ), placeholder = { Text(text = "Percent", style = TextStyle(color = Color.Black))}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), value = tipPer, onValueChange = {tipPer = it; tipInputColor=appGreen},  modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(3.dp, 10.dp)
//            .offset(x =0.dp, y = 400.dp),
                        )
                        Button(onClick = {
                            if(  tipPer.toFloatOrNull()!=null){
                                tipPer = tipPer;
                                tot= cal(inputNum, tipPer)
                                var t = "%.2f".format(tot)
                                tot = t.toFloat()
                                showDialog = false
                            }else{
                                tipInputColor = appRed
                            }


                        },
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.CenterHorizontally),
                            colors = ButtonDefaults.buttonColors(appGreen) ) {
                            Text(text = "Enter")
                        }
                    }

                }
            )

        }

        OutlinedTextField(         colors = TextFieldDefaults.colors(
            focusedIndicatorColor  = amountInputColor,
            unfocusedIndicatorColor = amountInputColor,
            cursorColor = amountInputColor

        ),
            placeholder = { Text(text = "Amount",  style = TextStyle(color = Color.Black, background = Color.Transparent,  ))},

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),

            value = inputNum, onValueChange = {inputNum =it; amountInputColor=appGreen},
            modifier = Modifier
//                .border(2.dp, amountInputColor)
                .align(Alignment.CenterHorizontally)
                .padding(3.dp, 10.dp)





//            .offset(x =0.dp, y = 400.dp),
        )



        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 40.dp)
            , Arrangement.SpaceEvenly
            ){
            Button(
                onClick = {
                    if(inputNum.toFloatOrNull()!=null){
                        tipPer = 10.00.toString();
                        tot= cal(inputNum, tipPer)
                        var t = "%.2f".format(tot)
                        tot = t.toFloat()
                    }else{
                            amountInputColor = appRed
                    }

                },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(appGreen),
            ) {
                Text(text = "10%")
            }
            Button(
                onClick = {
                    if(inputNum.toFloatOrNull()!=null){
                        tipPer = 20.00.toString();
                        tot= cal(inputNum, tipPer)
                        var t = "%.2f".format(tot)
                        tot = t.toFloat()
                    }else{
                        amountInputColor = appRed
                    }

                },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(appGreen),
            ) {
                Text(text = "20%")
            }
            Button(
                onClick = {
                    if(inputNum.toFloatOrNull()!=null){
                        tipPer = 30.00.toString();
                        tot= cal(inputNum, tipPer)
                        var t = "%.2f".format(tot)
                        tot = t.toFloat()
                    }else{
                        amountInputColor = appRed
                    }

                },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(appGreen),
            ) {
                Text(text = "30%")
            }


        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 20.dp)
            , Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    if(inputNum.toFloatOrNull()!=null){
                        tipPer = ""
                        showDialog = true
                    }else{
                        amountInputColor = appRed
                    }

                },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(appGreen),
            ) {
                Text(text = "Custom")
            }
        }

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 20.dp)
            , Arrangement.SpaceEvenly
        ) {
            Text(text = "Total: R ${tot}", style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.Bold))
        }


        }

}

fun cal(a: String, b: String): Float {
val amount = a.toFloat()
val tipPer = b.toFloat()
var total = 0.00f

val tipAmount = (amount*tipPer)/100

total = amount+tipAmount

    return total

}