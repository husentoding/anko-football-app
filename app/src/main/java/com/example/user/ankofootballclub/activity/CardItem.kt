package com.example.user.ankofootballclub.activity

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.user.ankofootballclub.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class CardItem : AnkoComponent<ViewGroup>{

    companion object {
        val IMAGE_CARD = 0
        val TITLE = 1
        val CONTAINER = 2
    }

    lateinit var clubImage : ImageView
    lateinit var clubName : TextView
    lateinit var clubContainer : LinearLayout
    override fun createView(ui: AnkoContext<ViewGroup>): View {

        clubContainer = ui.linearLayout {
            lparams{
                width = matchParent
            }
            id = CONTAINER
            orientation = LinearLayout.HORIZONTAL
            padding = dip(20)
            clubImage = imageView {
                id = IMAGE_CARD
            }.lparams {
                width = 200
                height = 200
            }
            clubName = textView {
                id = TITLE
            }.lparams {
                leftMargin = dip(20)
                gravity = Gravity.CENTER_VERTICAL
            }
        }
        return clubContainer

    }

}