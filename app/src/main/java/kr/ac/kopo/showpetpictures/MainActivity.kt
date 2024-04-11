package kr.ac.kopo.showpetpictures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    lateinit var checkStart : CheckBox
    lateinit var rg : RadioGroup
    lateinit var linearSub : LinearLayout
    lateinit var btnDone : Button
    lateinit var imgV : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkStart = findViewById<CheckBox>(R.id.checkStart)
        rg = findViewById<RadioGroup>(R.id.rg)
        linearSub = findViewById<LinearLayout>(R.id.linearSub)
        btnDone = findViewById<Button>(R.id.btndone)
        imgV = findViewById<ImageView>(R.id.imgV)

        linearSub.visibility = View.INVISIBLE

        checkStart.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                linearSub.visibility= View.VISIBLE
            }else{
                linearSub.visibility = View.INVISIBLE
            }
        }
        btnDone.setOnClickListener {
            when(rg.checkedRadioButtonId){
                R.id.radioDog -> imgV.setImageResource(R.drawable.dog)
                R.id.radioTiger -> imgV.setImageResource(R.drawable.tiger)
                R.id.radioPuma -> imgV.setImageResource(R.drawable.puma)
            }
        }
    }

    val btnListener = OnClickListener {
        when(it.id){
            R.id.btnFinish -> finish()
            R.id.btnInit -> {
                checkStart.isChecked = false
                linearSub.visibility = INVISIBLE
            }
        }
    }
}