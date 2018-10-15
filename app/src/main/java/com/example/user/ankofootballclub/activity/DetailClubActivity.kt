package com.example.user.ankofootballclub.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.example.user.ankofootballclub.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailClubActivity : AppCompatActivity() {

    lateinit var clubLogo : ImageView
    lateinit var clubName : TextView
    lateinit var clubDesc : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras
        val club: Club  = bundle.getParcelable("CLUB")
        verticalLayout {
            gravity = Gravity.CENTER_HORIZONTAL
            padding = dip(20)
            clubLogo = imageView{

            }.lparams(200, 200)
            clubName = textView{
                text = club.name
                textSize = 18.0f
            }.lparams(width = wrapContent, height = wrapContent)
            clubDesc = textView{
                text = club.description
            }.lparams(width = matchParent, height = wrapContent)
        }
        Picasso.get()
                .load(club.image)
                .placeholder(R.color.colorWhite)
                .error(R.color.colorAccent)
                .centerCrop()
                .fit()
                .into(clubLogo)
    }
}
