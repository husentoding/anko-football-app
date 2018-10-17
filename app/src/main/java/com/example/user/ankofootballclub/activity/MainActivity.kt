package com.example.user.ankofootballclub.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.user.ankofootballclub.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    val listClub = ArrayList<Club>()
    lateinit var rvClub : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            rvClub = recyclerView()
        }
        val listener : (Club) -> Unit = {
//            val intent = Intent(this@MainActivity, DetailClubActivity::class.java)
//            intent.putExtra("CLUB", it)
//            startActivity(intent)
            startActivity(intentFor<DetailClubActivity>("CLUB" to it))
            toast(it.name)
        }
        initData()
        rvClub.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ClubAdapter(listClub, this@MainActivity, listener)
        }

    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = "Real Madrid Club de Fútbol (Spanish pronunciation: [reˈal maˈðɾið ˈkluβ ðe ˈfuðβol]; \"Royal Madrid Football Club\"), commonly known as Real Madrid, is a professional football club based in Madrid, Spain.\n" +
                            "\n" +
                            "Founded on 6 March 1902 as the Madrid Football Club, the club has traditionally worn a white home kit since inception. The word real is Spanish for \"royal\" and was bestowed to the club by King Alfonso XIII in 1920 together with the royal crown in the emblem. The team has played its home matches in the 81,044-capacity Santiago Bernabéu Stadium in downtown Madrid since 1947. Unlike most European sporting entities, Real Madrid's members (socios) have owned and operated the club throughout its history."
        listClub.clear()
        for (i in name.indices) {
            listClub.add(Club(name[i], desc, image.getResourceId(i, 0)))
        }

        //Recycle the typed array
        image.recycle()
    }

//    fun initData(){
//        val desc = "Real Madrid Club de Fútbol (Spanish pronunciation: [reˈal maˈðɾið ˈkluβ ðe ˈfuðβol]; \"Royal Madrid Football Club\"), commonly known as Real Madrid, is a professional football club based in Madrid, Spain.\n" +
//                "\n" +
//                "Founded on 6 March 1902 as the Madrid Football Club, the club has traditionally worn a white home kit since inception. The word real is Spanish for \"royal\" and was bestowed to the club by King Alfonso XIII in 1920 together with the royal crown in the emblem. The team has played its home matches in the 81,044-capacity Santiago Bernabéu Stadium in downtown Madrid since 1947. Unlike most European sporting entities, Real Madrid's members (socios) have owned and operated the club throughout its history."
//        val club1 = Club("a", desc, "https://www.thehappycatsite.com/wp-content/uploads/2017/10/best-treats-for-kittens.jpg")
//        val club2 = Club("b", desc, "https://www.thehappycatsite.com/wp-content/uploads/2017/10/best-treats-for-kittens.jpg")
//        val club3 = Club("c", desc, "https://www.thehappycatsite.com/wp-content/uploads/2017/10/best-treats-for-kittens.jpg")
//        val club4 = Club("d", desc, "https://www.thehappycatsite.com/wp-content/uploads/2017/10/best-treats-for-kittens.jpg")
//        val club5 = Club("e", desc, "https://www.thehappycatsite.com/wp-content/uploads/2017/10/best-treats-for-kittens.jpg")
//        val club6 = Club("f", desc, "https://www.thehappycatsite.com/wp-content/uploads/2017/10/best-treats-for-kittens.jpg")
//        listClub.add(club1)
//        listClub.add(club2)
//        listClub.add(club3)
//        listClub.add(club4)
//        listClub.add(club5)
//        listClub.add(club6)
//
//    }



}
