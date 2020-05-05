package com.numbertoword

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.numbertoword.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener, MainActivityView {

    var result: String = ""
    lateinit var mainActivityPresenter: MainActivityPresenter
    lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.activity = this
        mainActivityPresenter = MainActivityPresenter(this)
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
                                mainActivityPresenter.getNumberToWord(parseInt)
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

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }

    override fun onSuccess(numberToWord: Int, convertNumberToWords: String?) {
        try {
            val result = buildString {
                append(numberToWord).append(getString(R.string.colon))
                    .append(convertNumberToWords)
            }
            txt_result.text = result
            et_input.text.clear()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}


