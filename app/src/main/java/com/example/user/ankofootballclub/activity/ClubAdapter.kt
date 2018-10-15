package com.example.user.ankofootballclub.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.user.ankofootballclub.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext
import java.lang.Exception

class ClubAdapter(val listClub : ArrayList<Club>, val context : Context, val listener : (Club)-> Unit) : RecyclerView.Adapter<ClubAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(CardItem().createView(AnkoContext.create(context, p0)))
    }

    override fun getItemCount(): Int {
        return listClub.size
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        Log.e("bind", listClub.get(p1).name)
        holder.bindItem(listClub.get(p1))
    }


    inner class ViewHolder (view : View) : RecyclerView.ViewHolder(view){
        var clubImage = view.findViewById<ImageView>(CardItem.IMAGE_CARD)
        var clubName = view.findViewById<TextView>(CardItem.TITLE)
        var clubContainer = view.findViewById<LinearLayout>(CardItem.CONTAINER)

        fun bindItem(item : Club){
            Picasso.get()
                    .load(item.image)
                    .placeholder(R.color.colorWhite)
                    .error(R.color.colorAccent)
                    .centerCrop()
                    .fit()
                    .into(clubImage, object : Callback{
                        override fun onSuccess() {

                        }

                        override fun onError(e: Exception?) {
                            Log.e("Error picasso", e?.message.toString() +" ")
                        }

                    })
            clubName.text = item.name
            clubContainer.setOnClickListener {
                listener(item)
            }
        }
    }

}