package com.example.qrazy.qrazyapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlin.math.roundToInt

class KotAdapter(val context : Context): RecyclerView.Adapter<KotAdapter.Holder>() {
    private var mDatas :ArrayList<AppInfo> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return Holder(itemView)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(mDatas[position],position)
    }
    override fun getItemCount(): Int {
        return mDatas.size
    }
    fun setData(datas :ArrayList<AppInfo>){
        mDatas.clear()
        mDatas.addAll(datas)
    }
    inner class Holder(itemView :View) : RecyclerView.ViewHolder(itemView) {

            var iv:ImageView = itemView.findViewById(R.id.iv)
            var tv1:TextView= itemView.findViewById(R.id.text1)
            var tv2:TextView= itemView.findViewById(R.id.text2)

        fun bind(appInfo: AppInfo , position: Int) {
            Glide.with(iv).load(appInfo.appIcon).into(iv)
            tv1.text = appInfo.toString()

            /*val i = Math.random()*9
            val roundToInt = i.roundToInt()
            tv2.text = "-----------------------------------"+roundToInt*/

        }



    }
}