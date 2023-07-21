package com.example.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mathgame.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private  val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var number1=0
    private var number2 =0
    private var count1=0
    private var count2=0
    private var summa=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        hammasi()

        binding.txtJavob1.setOnClickListener {
            if (binding.txtJavob1.text.toString().toInt() == summa) {
                count1++
                binding.txtYutuqlar.text = count1.toString()
            } else {
                count2++
                binding.txtYutuqsiz.text = count2.toString()
            }
            hammasi()
        }
        binding.txtJavob4.setOnClickListener {
            if (binding.txtJavob4.text.toString().toInt() == summa) {
                count1++
                binding.txtYutuqlar.text = count1.toString()
            } else {
                count2++
                binding.txtYutuqsiz.text = count2.toString()
            }
            hammasi()
        }
        binding.txtJavob2.setOnClickListener {
            if (binding.txtJavob2.text.toString().toInt() == summa) {
                count1++
                binding.txtYutuqlar.text = count1.toString()
            } else {
                count2++
                binding.txtYutuqsiz.text = count2.toString()
            }
            hammasi()
        }
        binding.txtJavob3.setOnClickListener{
            if (binding.txtJavob3.text.toString().toInt()==summa){
                count1++
                binding.txtYutuqlar.text=count1.toString()
            }else{
                count2++
                binding.txtYutuqsiz.text=count2.toString()
            }
            hammasi()
        }
    }
    fun amalBtn():Int{
        return Random.nextInt(1,5)
    }
    fun amalRandom():Int{
        val nums= Random.nextInt(1,3)
        var sum=0
        when(nums) {
            1 -> {
                binding.txtAmal.text = "+"
                sum =
                    binding.txtNumber1.text.toString().toInt() + binding.txtNumber2.text.toString()
                        .toInt()
            }
            2 -> {
                binding.txtAmal.text = "-"
                sum =
                    binding.txtNumber1.text.toString().toInt() - binding.txtNumber2.text.toString()
                        .toInt()
            }
        }
        return sum
    }

    fun numberRandom(){
        number1=Random.nextInt(1,20)
        number2=Random.nextInt(1,20)
        if (number1>number2){
            binding.txtNumber1.text=number1.toString()
            binding.txtNumber2.text=number2.toString()
        }else{
            return numberRandom()
        }
    }

    fun numberBtn():Int{
        return Random.nextInt(1,20)
    }

    fun randomNumberBtn(num1: Int):ArrayList<Int> {
        val num2 = numberBtn()
        val num3 = numberBtn()
        val num4 = numberBtn()
        val intArray = arrayListOf<Int>()
        intArray.add(num1)
        intArray.add(num2)
        intArray.add(num3)
        intArray.add(num4)
        if (num1 != num2 && num2 != num3 && num3 != num4 && num1!=num4) {
            return intArray
        }
        return randomNumberBtn(num1)
    }

    fun hammasi(){
        numberBtn()
        numberRandom()
        summa=amalRandom()
        val array:ArrayList<Int> = randomNumberBtn(summa)
        when (amalBtn()) {
            1 -> {
                binding.txtJavob1.text = summa.toString()
                binding.txtJavob2.text = array[1].toString()
                binding.txtJavob3.text = array[2].toString()
                binding.txtJavob4.text = array[3].toString()
            }
            2 -> {
                binding.txtJavob2.text = summa.toString()
                binding.txtJavob1.text = array[1].toString()
                binding.txtJavob3.text = array[2].toString()
                binding.txtJavob4.text = array[3].toString()
            }
            3 -> {
                binding.txtJavob3.text = summa.toString()
                binding.txtJavob1.text = array[1].toString()
                binding.txtJavob2.text = array[2].toString()
                binding.txtJavob4.text = array[3].toString()
            }
            4 -> {
                binding.txtJavob4.text= summa.toString()
                binding.txtJavob1.text = array[1].toString()
                binding.txtJavob2.text = array[2].toString()
                binding.txtJavob3.text = array[3].toString()
            }
        }
    }
}
