package com.example.bankbalance

import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class MainActivity : AppCompatActivity() {
    var price = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        intent.getStringExtra("Hello")


        btn_1.setOnClickListener {
            seekbar.isEnabled = true
            val animator = ValueAnimator.ofInt(price, price + 1)
            animator.addUpdateListener {
                price = animator.animatedValue as Int
                tv_price.text = price.toString()
            }

            animator.duration = 100
            animator.start()
        }

        btn_5.setOnClickListener {
            seekbar.isEnabled = true
            val animator = ValueAnimator.ofInt(price, price + 5)
            animator.addUpdateListener {
                price = animator.animatedValue as Int
                tv_price.text = price.toString()
            }

            animator.duration = 500
            animator.start()

        }

        btn_10.setOnClickListener {
            seekbar.isEnabled = true
            val animator = ValueAnimator.ofInt(price, price + 10)
            animator.addUpdateListener {
                price = animator.animatedValue as Int
                tv_price.text = price.toString()
            }

            animator.duration = 700
            animator.start()

        }

        btn_50.setOnClickListener {
            seekbar.isEnabled = true
            val animator = ValueAnimator.ofInt(price, price + 50)
            animator.addUpdateListener {
                price = animator.animatedValue as Int
                tv_price.text = price.toString()
            }

            animator.duration = 700
            animator.start()

        }

        btn_100.setOnClickListener {
            seekbar.isEnabled = true
            val animator = ValueAnimator.ofInt(price, price + 100)
            animator.addUpdateListener {
                price = animator.animatedValue as Int
                tv_price.text = price.toString()
            }

            animator.duration = 700
            animator.start()

        }

        btn_500.setOnClickListener {
            seekbar.isEnabled = true
            val animation = ValueAnimator.ofInt(price, price + 500)
            animation.addUpdateListener {
                price = animation.animatedValue as Int
                tv_price.text = price.toString()
            }

            animation.duration = 700
            animation.start()

        }

        btn_1000.setOnClickListener {
            seekbar.isEnabled = true
            val animator = ValueAnimator.ofInt(price, price + 1000)
            animator.addUpdateListener {
                price = animator.animatedValue as Int
                tv_price.text = price.toString()
            }

            animator.duration = 700
            animator.start()

        }

        btn_5000.setOnClickListener {
            seekbar.isEnabled = true
            val animator = ValueAnimator.ofInt(price, price + 5000)
            animator.addUpdateListener {
                price = animator.animatedValue as Int
                tv_price.text = price.toString()
            }

            animator.duration = 800
            animator.start()

        }

        btn_clear.setOnClickListener {

            val animator = ValueAnimator.ofInt(price, 0)
            animator.addUpdateListener {
                price = animator.animatedValue as Int
                tv_price.text = price.toString()
                tv_presentNum.text = ""
                tv_sale.text = ""
                tv_offNum.text = ""

                seekbar.progress = 0


            }

            animator.duration = 500
            animator.start()

        }

        btn_input.setOnClickListener {


            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
            dialogView.et_input.inputType = EditorInfo.TYPE_CLASS_NUMBER

            builder.setView(dialogView)
            builder.setTitle("請輸入金額")
            builder.setPositiveButton("確認") { dialog, which ->


                var input = dialogView.et_input.text.toString()



                if (input == "") {
                    val toast = Toast(applicationContext)
                    toast.setGravity(Gravity.BOTTOM,0,120)
                    toast.view = layoutInflater.inflate(R.layout.custom_toast_money,null)
                    toast.duration = Toast.LENGTH_SHORT
                    toast.show()

//                    Toast.makeText(this, "請輸入金額", Toast.LENGTH_SHORT).show()

                } else {

                    price = input.toInt()
                    tv_price.text = input
                    seekbar.progress = 0
                    tv_offNum.text = price.toString()
                }


            }

            builder.setNegativeButton("取消") { dialog, which ->

                val toast = Toast(applicationContext)
                toast.setGravity(Gravity.BOTTOM, 0, 120)
                toast.view = layoutInflater.inflate(R.layout.custom_toast_cancel, null)
                toast.duration = Toast.LENGTH_SHORT
                toast.show()


            }
            val dialog = builder.create()
            dialog.show()

        }



        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {


                when (price) {
                    0 -> {

                        seekbar.isEnabled = false

                    }
                    else -> {

                        seekbar.isEnabled = true
                        tv_presentNum.text = "($progress %) :"
                        tv_sale.text = "$ " + (price * progress / 100).toString()
                        tv_offNum.text = "$ " + (price - (price * progress / 100)).toString()
                    }
                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {


            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })


    }


}
