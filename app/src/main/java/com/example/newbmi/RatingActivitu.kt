package com.example.newbmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.newbmi.databinding.ActivityRatingActivituBinding

class RatingActivitu : AppCompatActivity(), View.OnClickListener {
    private  lateinit var binding: ActivityRatingActivituBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRatingActivituBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ratingbtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.ratingbtn ->{
                val msg=binding.ratingbar.rating.toString()
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

            }

        }
    }
}