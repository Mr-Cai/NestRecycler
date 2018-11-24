package com.example

import android.os.Bundle
import android.view.WindowManager.LayoutParams.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val itemRecyclerSet = ArrayList<Any>()
    private val dataSet: ArrayList<Any>
        get() {
            itemRecyclerSet.add(verticalData[0])
            itemRecyclerSet.add(verticalData[0])
            itemRecyclerSet.add(horizontalData[0])
            itemRecyclerSet.add(horizontalData[0])
            return itemRecyclerSet
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        recycler_View.adapter = MainAdapter(this, dataSet)
        recycler_View.layoutManager = LinearLayoutManager(this)
    }

    companion object {
        val verticalData: ArrayList<SingleVertical>
            get() {
                val singleVerticals = ArrayList<SingleVertical>()
                singleVerticals.add(
                    SingleVertical(
                        "查理·卓别林",
                        "查尔斯·斯宾塞爵士，“查理”，卓别林，KBE是一位英国喜剧演员，......",
                        R.mipmap.charlie
                    )
                )
                singleVerticals.add(
                    SingleVertical(
                        "憨豆先生",
                        "憨豆先生是由罗温·艾金森和理查德·柯蒂斯创作的英国情景喜剧，并以阿特金森为主角。",
                        R.mipmap.mrbean
                    )
                )
                singleVerticals.add(
                    SingleVertical(
                        "金凯瑞",
                        "金凯瑞是加拿大裔美国演员，喜剧演员，印象派，编剧......",
                        R.mipmap.jim
                    )
                )
                return singleVerticals
            }


        val horizontalData: ArrayList<SingleHorizontal>
            get() {
                val singleHorizontals = ArrayList<SingleHorizontal>()
                for (i in 1..3) {
                    singleHorizontals.add(
                        SingleHorizontal(
                            R.mipmap.charlie,
                            "查理·卓别林",
                            "查尔斯·斯宾塞爵士，“查理”，卓别林，KBE是一位英国喜剧演员，......",
                            "2010/2/1"
                        )
                    )
                    singleHorizontals.add(
                        SingleHorizontal(
                            R.mipmap.mrbean,
                            "憨豆先生",
                            "憨豆先生是由罗温·艾金森和理查德·柯蒂斯创作的英国情景喜剧，并以阿特金森为主角。",
                            "2010/2/1"
                        )
                    )
                    singleHorizontals.add(
                        SingleHorizontal(
                            R.mipmap.jim,
                            "金凯瑞",
                            "金凯瑞是加拿大裔美国演员，喜剧演员，印象派，编剧......",
                            "2010/2/1"
                        )
                    )
                }
                return singleHorizontals
            }
    }
}
