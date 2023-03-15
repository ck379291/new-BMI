package com.example.newbmi

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.newbmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
private lateinit var  binding: ActivityMainBinding
    private var isClear: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnsubmit.setOnClickListener(this)
        if (isClear){
            isClear=false
            binding.btnsubmit.setText("CALCULATE")
        }
    }

    override fun onClick(view: View?) {
      when(view?.id){
          R.id.btnsubmit->{
              if (binding.height.text!!.isEmpty() && binding.weight.text!!.isEmpty()){
                  binding.height.requestFocus()
                  Toast.makeText(this,"enter your height and weight", Toast.LENGTH_SHORT).show()
              }
              if (isClear){
                  isClear=false
                  binding.btnsubmit.setText("CALCULATE")
                  binding.BMI.setText("")
                  binding.height.text!!.clear()
                  binding.weight.text!!.clear()
                  Toast.makeText(this,"clear this",Toast.LENGTH_SHORT).show()
              }
              else{
                  if (binding.weight.text!!.isNotEmpty() && binding.height.text!!.isNotEmpty()){
                      if (!isClear){
                          isClear=true
                          binding.btnsubmit.setText("clear")
                          val height=(binding.height.text.toString()).toDouble()
                          val weight=(binding.weight.text.toString()).toDouble()
                          if (height==0.0 && weight==0.0){
                              Toast.makeText(this,"enter valid ammount",Toast.LENGTH_SHORT).show()
                          }
                          else{
                              val height_in_meter=height.toFloat()/100
                              val BMI=weight.toFloat()/(height_in_meter*height_in_meter)
                              binding.BMI.text="your bmi is:${BMI}"
                              if (BMI<18.5){
                                  binding.output.text=resources.getString(R.string.under_weight)
                              }
                              else if (BMI >= 18.5 && BMI < 24.9){
                                  binding.output.text=resources.getString(R.string.Healthy)
                              }
                              else if (BMI >= 24.9 && BMI < 30){
                                  binding.output.text=resources.getString(R.string.over_weight)
                              }
                              else{
                                  binding.output.text=resources.getString(R.string.Suffering_from_Obesity)
                              }
                          }
                      }
                  }

              }
          }
      }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.newmenu,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1->{
                val intent=Intent(this,developeractivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "about developer", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item2->{
                val intent=Intent(this,Bmichart::class.java)
                startActivity(intent)
                Toast.makeText(this, "BMI chart", Toast.LENGTH_SHORT).show()
                return true

            }
            R.id.item3->{
                finish()
                System.exit(0)
                Toast.makeText(this,"exit ",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item4->{
                Toast.makeText(this, "what is BMI", Toast.LENGTH_SHORT).show()

                val intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm"))
                startActivity(intent)
            }
            R.id.contectus->{
                Toast.makeText(this,"dailing phone number of feveloper ",Toast.LENGTH_SHORT).show()
                val intent=Intent(Intent.ACTION_DIAL, Uri.parse("tel:8825385207"))
                startActivity(intent)
                return true
            }
//            R.id.calldeveloper->{
//                Toast.makeText(this,"calling developer",Toast.LENGTH_SHORT).show()
//                if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)==packageManager.PERMISSION_GRANTED){
//                    intent=Intent(Intent.ACTION_CALL)
//                    intent.data= Uri.parse("tel:8825385207")
//                    startActivity(intent)
//                }
//            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onResume() {
        super.onResume()
    }
}