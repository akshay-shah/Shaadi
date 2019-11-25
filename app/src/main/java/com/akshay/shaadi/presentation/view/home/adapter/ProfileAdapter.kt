package com.akshay.shaadi.presentation.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshay.shaadi.R
import com.akshay.shaadi.domain.getmatches.Profile
import com.bumptech.glide.Glide

class ProfileAdapter() : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {
    var list: List<Profile> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.profile_view,
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewName.apply {
            text = list[position].name
        }
        holder.textViewAge.apply {
            text = " " + list[position].age
        }
        Glide.with(holder.itemView.context).load(list[position].imageUrl)
            .into(holder.imageViewProfilePic)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.findViewById<TextView>(R.id.textViewName)
        val textViewAge = itemView.findViewById<TextView>(R.id.textViewAge)
        val imageViewProfilePic = itemView.findViewById<ImageView>(R.id.imageViewProfileImage)
    }
}