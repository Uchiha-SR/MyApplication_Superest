package dev.android.myapplication_superest.presentation.screens

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import dev.android.myapplication_superest.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import dev.android.myapplication_superest.graphs.Graph
import dev.android.myapplication_superest.ui.theme.Green
import java.util.concurrent.TimeUnit


@Composable

fun SignInScreen() {


    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
/*
        Image(
            modifier = Modifier.size(440.dp),
            painter = painterResource(id = R.drawable.vegetables_img),
            contentDescription = stringResource(id = R.string.content_description)
        )


        Text(
            // on below line we are specifying
            // text to display in top app bar
            text = "Get your Groceries with the Superest",
            // on below line we are specifying
            // modifier to fill max width
            modifier = Modifier.fillMaxWidth(),

            fontSize = 30.sp,
            // on below line we are specifying
            // text alignment
            textAlign = TextAlign.Start,
            // on below line we are specifying
            // color for our text.
            color = Color.Black
        )
*/
        PhoneVerification(LocalContext.current,)
       // GmailVerification()


    }
}

@Composable
fun PhoneVerification(context: Context) {
    

    val phoneNumber = remember {
        mutableStateOf("")
    }

    val otp = remember {
        mutableStateOf("")
    }

    val verificationID = remember {
        mutableStateOf("")
    }

    val message = remember {
        mutableStateOf("")
    }

    // on below line creating variable
    // for firebase auth and callback
    val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    // on below line creating a column
    // to display our retrieved image view.
    Column(
        // adding modifier for our column
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        // on below line adding vertical and
        // horizontal alignment for column.
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // on below line creating text field for phone number.
        TextField(
            // on below line we are specifying
            // value for our course name text field.
            value = phoneNumber.value,
            // on below line specifying key board type as number.
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            // on below line we are adding on
            // value change for text field.
            onValueChange = { phoneNumber.value = it },

            // on below line we are adding place holder
            // as text as "Enter your course name"
            placeholder = { Text(text = "Enter your phone number") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        // on below line adding spacer.
        Spacer(modifier = Modifier.height(10.dp))

        // on below line creating button to send verification code.
        Button(
            onClick = {
                // on below line we are validating user inputs
                if (TextUtils.isEmpty(phoneNumber.value)) {
                    Toast.makeText(context, "Please enter phone number..", Toast.LENGTH_SHORT)
                        .show()
                } else {

                    val number = "+91${phoneNumber.value}"
                    // on below line calling method to generate verification code.
                    sendVerificationCode(number, mAuth, context as Activity, callbacks)
                }
            },
            // on below line we are
            // adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Generate OTP", modifier = Modifier.padding(8.dp))
        }

        // adding spacer on below line.
        Spacer(modifier = Modifier.height(10.dp))

        // on below line creating text field for otp
        TextField(
            // on below line we are specifying
            // value for our course duration text field.
            value = otp.value,
            //specifying key board on below line.
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            // on below line we are adding on
            // value change for text field.
            onValueChange = { otp.value = it },

            // on below line we are adding place holder
            // as text as "Enter your course duration"
            placeholder = { Text(text = "Enter your otp") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        // adding spacer on below line.
        Spacer(modifier = Modifier.height(10.dp))

        // on below line creating button to add
        // data to firebase firestore database.
        Button(
            onClick = {
                // on below line we are validating
                // user input parameters.
                if (TextUtils.isEmpty(otp.value)) {
                    // displaying toast message on below line.
                    Toast.makeText(context, "Please enter otp..", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    // on below line generating phone credentials.
                    val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(
                        verificationID.value, otp.value
                    )
                    // on below line signing within credentials.
                    signInWithPhoneAuthCredential(
                        credential,
                        mAuth,
                        context as Activity,
                        context,
                        message,


                    )
                }
            },
            // on below line we are
            // adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

        ) {
            // on below line we are adding text for our button
            Text(text = "Verify OTP", modifier = Modifier.padding(8.dp))
        }

        // on below line adding spacer.
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            // on below line displaying message for verification status.
            text = message.value,
            style = TextStyle(color = Green, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )
    }

    // on below line creating callback
    callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            // on below line updating message
            // and displaying toast message
            message.value = "Verification successful"
            Toast.makeText(context, "Verification successful..", Toast.LENGTH_SHORT).show()
        }

        override fun onVerificationFailed(p0: FirebaseException) {
            // on below line displaying error as toast message.
            message.value = "Fail to verify user : \n" + p0.message
            Toast.makeText(context, "Verification failed..", Toast.LENGTH_SHORT).show()
        }

        override fun onCodeSent(verificationId: String, p1: PhoneAuthProvider.ForceResendingToken) {
            // this method is called when code is send
            super.onCodeSent(verificationId, p1)
            verificationID.value = verificationId
        }
    }
}

// on below line creating method to
// sign in with phone credentuals.
private fun signInWithPhoneAuthCredential(
    credential: PhoneAuthCredential,
    auth: FirebaseAuth,
    activity: Activity,
    context: Context,
    message: MutableState<String>

) {

    // on below line signing with credentials.
    auth.signInWithCredential(credential)
        .addOnCompleteListener(activity) { task ->
            // displaying toast message when
            // verification is successful
            if (task.isSuccessful) {
                message.value = "Verification successful"
                Toast.makeText(context, "Verification successful..", Toast.LENGTH_SHORT).show()
            } else {
                // Sign in failed, display a message
                if (task.exception is FirebaseAuthInvalidCredentialsException) {
                    // The verification code
                    // entered was invalid
                    Toast.makeText(
                        context,
                        "Verification failed.." + (task.exception as FirebaseAuthInvalidCredentialsException).message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
}

// below method is use to send
// verification code to user phone number.
private fun sendVerificationCode(
    number: String,
    auth: FirebaseAuth,
    activity: Activity,
    callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
) {
    // on below line generating options for verification code
    val options = PhoneAuthOptions.newBuilder(auth)
        .setPhoneNumber(number) // Phone number to verify
        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
        .setActivity(activity) // Activity (for callback binding)
        .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
        .build()
    PhoneAuthProvider.verifyPhoneNumber(options)
}


