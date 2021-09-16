package com.bokchi.runningapp.home.runningGithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.runningapp.R
import com.bokchi.runningapp.network.github.model.RecyclerData
import com.bumptech.glide.Glide

class RunningGithubRVAdapter : RecyclerView.Adapter<RunningGithubRVAdapter.ViewHolder>(){

    private var listData: List<RecyclerData>? = null

    fun setlistData(listData: List<RecyclerData>?) {
        this.listData = listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RunningGithubRVAdapter.ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.rv_github_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RunningGithubRVAdapter.ViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(listData ==null) {
            return 0
        }
        return listData?.size!!
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val githubTextArea = itemView.findViewById<TextView>(R.id.githubNameArea)
        val githubImageArea = itemView.findViewById<ImageView>(R.id.githubImageArea)

        fun bind(data: RecyclerData) {

            githubTextArea.text = data.name

            Glide.with(githubImageArea)
                .load(data.owner?.avatar_url)
                .into(githubImageArea)

        }

    }
}