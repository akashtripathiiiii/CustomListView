package com.akash.customlistview


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Objects

class demo(context: Context, var resource:Int,var objects: MutableList<ContactDetail2>)
    :ArrayAdapter<ContactDetail2>(context,resource,objects) {
    lateinit var cb:CheckBox

    fun isChecked(position: Int):Boolean{
        return objects.get(position).checked
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context)
        var total:Int=0;

        val view:View=layoutInflater.inflate(resource,null)
        val imageView: ImageView=view.findViewById(R.id.imageView)
        val title: TextView=view.findViewById(R.id.textView)
        val desc: TextView=view.findViewById(R.id.textView2)
        val removeBtn: Button=view.findViewById(R.id.removeBtn)

        cb=view.findViewById(R.id.checkBox)
        val mItem: ContactDetail2=objects[position]

        imageView.setImageDrawable(context.resources.getDrawable(mItem.img))
        title.text=mItem.title
        desc.text=mItem.description
        removeBtn.tag=position

        cb.setChecked(objects.get(position).checked)
        cb.setTag(position)
        var itemStr = objects.get(position).title;



        cb.setOnClickListener {
            val newState: Boolean = !objects.get(position).isChecked()
            objects.get(position).checked = newState
            Toast.makeText(
                context,itemStr+
                        "Selected with state   : "+newState ,
                Toast.LENGTH_LONG
            ).show()

        }

        cb.setChecked(isChecked(position))

        return view


//        removeBtn.setOnClickListener()
//        {
//
//            val itemSelected=objects.get(removeBtn.tag as Int)
//            objects.remove(itemSelected)
//            notifyDataSetChanged()
//        }
//        return view

    }
}