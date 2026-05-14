package com.example.composition

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.composition.navigation.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            AppNavigation()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        AppNavigation()
    }
}

@Composable
fun Form() {

    var a by rememberSaveable { mutableStateOf("") }
    var b by rememberSaveable { mutableStateOf("") }
    var x by rememberSaveable { mutableStateOf(0) }

    var aError by rememberSaveable { mutableStateOf(false) }
    var bError by rememberSaveable { mutableStateOf(false) }

    val isFormValid = !a.isBlank() && !b.isBlank()


    var resultat by rememberSaveable { mutableStateOf("") }



    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = a,
            onValueChange = {
                a = it
                if(aError && a.isNotEmpty()){
                    aError = false
                }
            },
            label = {
                Text("a")
            },
            modifier = Modifier.fillMaxWidth(),
            isError = aError
        )
        Spacer( modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = b,
            onValueChange = {
                b = it
                if(bError && b.isNotEmpty()){
                    bError = false
                }
            },
            label = {
                Text("b")
            },
            modifier = Modifier.fillMaxWidth(),
            isError = bError
        )

        Spacer( modifier = Modifier.height(10.dp))

        if(aError && bError){

            Text(
                when{
                    a.toInt() ==  0 && b.toInt() == 0 -> "Infinité de solutions"
                    a.toInt() ==  0 && b.toInt() != 0 -> "Aucune solution"
                    else -> "Erreur de saisie"
                }
            )
        }

        Button(
            onClick = {
                if(a.isNotEmpty() && b.isNotEmpty()){
                    aError = false
                    bError = false

                    var x = -1 * b.toInt() / a.toInt()

                }

            },
            modifier = Modifier.fillMaxWidth(),
            enabled = isFormValid
        ) {
            Text("Resoudre")
        }

        Spacer( modifier = Modifier.height(10.dp))


        if(!aError && !bError){
            Text("le resultat est " + x)
        }else{
            Text("")
        }
    }

}