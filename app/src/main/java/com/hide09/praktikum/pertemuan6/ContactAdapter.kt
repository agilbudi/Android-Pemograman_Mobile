package com.hide09.praktikum.pertemuan6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hide09.praktikum.R
import kotlinx.android.synthetic.main.prt6_contact_list_item.view.*

class ContactAdapter (val phoneItemList: List<PhoneData>, val clickListener: (PhoneData)-> Unit):
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.prt6_contact_list_item, parent, false)
        return ItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(phoneItemList[position], clickListener)
    }

    override fun getItemCount() = phoneItemList.size

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(phone: PhoneData, clickListener: (PhoneData) -> Unit){
            itemView.tv_item_name.text = phone.contactName
            itemView.tv_item_id.text = phone.phone.toString()
            itemView.setOnClickListener { clickListener(phone) }
        }
    }

}