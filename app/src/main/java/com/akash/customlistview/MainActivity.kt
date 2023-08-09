package com.akash.customlistview


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var listView:ListView=findViewById(R.id.listViewMain)
        var sendBtn:Button=findViewById(R.id.sendBtn)
        var list= mutableListOf<ContactDetail2>()


        list.add(ContactDetail2("Aman","7028923789",R.drawable.boycontactimg, checked = false))
        list.add(ContactDetail2("Isha","9992761282",R.drawable.girlcontactimg, checked =false))
        list.add(ContactDetail2("Shreya","2873682937",R.drawable.girlcontactimg, checked = false))
        list.add(ContactDetail2("Manik","8910289132",R.drawable.boycontactimg, checked = false))
        list.add(ContactDetail2("Priyanka","2398729390",R.drawable.girlcontactimg, checked = false))
        list.add(ContactDetail2("Divya","99823789202",R.drawable.girlcontactimg, checked = false))
        list.add(ContactDetail2("Ankit","99823789202",R.drawable.boycontactimg, checked = false))
        list.add(ContactDetail2("Harsh","9092390823",R.drawable.boycontactimg,checked = false))
        list.add(ContactDetail2("Mohit","99823789202",R.drawable.boycontactimg,checked = false))





        listView.adapter=demo(this,R.layout.customlookfile,list)

        sendBtn.setOnClickListener()
        {
            var str="Checked Items:\n"
            val cnt:Int=list.count()
            for (i in 0  until  cnt)
            {
                var a=demo(this,R.layout.customlookfile,list)
                if(a.isChecked(i))
                {
                    str+"""$i""".trimIndent()

                }
            }

            Toast.makeText(this,str,Toast.LENGTH_SHORT).show()
            listView.visibility=View.GONE

        }






    }
}