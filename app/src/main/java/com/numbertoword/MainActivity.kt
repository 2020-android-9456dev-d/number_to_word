package com.numbertoword

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var result: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        txt_convert.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        try {
            var vId = view?.id
            when (vId) {
                R.id.txt_convert -> {
                    var input: String = et_input.text.toString()
                    if (TextUtils.isEmpty(input)) {
                        showToast(getString(R.string.enter_number))
                    } else {
                        if (input.length > 6) {
                            showToast(getString(R.string.supported_length))
                            txt_result.text = ("")
                        } else {
                            if (input.equals("0").not()) {
                                var parseInt = input.toInt();
                                var numberUtils = NumberUtils()
                                txt_result.text =
                                    (input + " : " + numberUtils.convertNumberToWords(parseInt));
                                et_input.text.clear()
                            } else {
                                showToast(getString(R.string.enter_greater_than_zero))
                            }
                        }

                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }
}


