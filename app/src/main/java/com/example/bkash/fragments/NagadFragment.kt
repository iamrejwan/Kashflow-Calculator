package com.example.bkash.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.bkash.R
import com.example.bkash.utils.ToastMsg
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.round

class NagadFragment() : Fragment() {

    private val NAGAD_CHARGE = 1.149




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nagad, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = view.findViewById<TextView>(R.id.title)
        val description = view.findViewById<TextView>(R.id.description)
        val amountInput = view.findViewById<TextInputEditText>(R.id.text_input)
        val calculateBtn = view.findViewById<Button>(R.id.calculate)
        val parentLyt = view.findViewById<LinearLayout>(R.id.parent_lyt)
        val chargesTextview = view.findViewById<TextView>(R.id.charges)
        val itemList1 = view.findViewById<TextView>(R.id.itemlist1)
        val itemList2 = view.findViewById<TextView>(R.id.itemlist2)
        val itemList3 = view.findViewById<TextView>(R.id.itemlist3)

        calculateBtn.setOnClickListener(View.OnClickListener { view ->
            title.text = getString(R.string.nagad_cashout_calculator)
            description.text = getString(R.string.cashing_out_from_app_nagad)
            if(amountInput.text!!.isNotEmpty()){
                val charges = calculateCharges(amountInput.text.toString().toInt(), NAGAD_CHARGE)

                chargesTextview.setText(charges.toString() + "Taka")
                val totalAmountWithFee = amountInput.text.toString().toInt() + charges
                val totalAmountWithoutFee = amountInput.text.toString().toInt() - charges
                itemList1.setText("with cashout fee: "+ amountInput.text+"+"+ charges.toString() + " = " + totalAmountWithFee)
                itemList2.setText("without fee: "+ amountInput.text+"-"+ charges.toString() + " = " + totalAmountWithoutFee)
                itemList3.setText("nagad charges: $NAGAD_CHARGE%")

                parentLyt.visibility = View.VISIBLE
            }else{
                ToastMsg(context).toastIconError(resources.getString(R.string.input_amount))
            }
        })
    }

    private fun calculateCharges(amount: Int, charge:Double): Int {

        return round(charge * amount/100.0).toInt()
    }

}