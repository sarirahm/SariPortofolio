package com.example.sarirahmawati_androidexercises.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sarirahmawati_androidexercises.R

class ContactAdapter(private val context: ContactFragment, private val Contact: List<Contact>, val listener: (Contact) -> Unit)
    : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivIcon: ImageView = itemView.findViewById(R.id.iv_ic_social_media)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)

        fun bindView(contact: Contact, listener: (Contact) -> Unit){
            ivIcon.setImageResource(contact.ic_social_media)
            tvName.text = contact.detail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_contact, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return Contact.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindView(Contact[position], listener)
    }
}