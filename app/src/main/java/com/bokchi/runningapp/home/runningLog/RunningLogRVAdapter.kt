package com.bokchi.runningapp.home.runningLog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.runningapp.R
import com.bokchi.runningapp.db.runnginLogDB.RunningLogEntity

class RunningLogRVAdapter : RecyclerView.Adapter<RunningLogRVAdapter.ViewHolder>() {

    private val TAG = RunningLogRVAdapter::class.java.simpleName

    var logList = ArrayList<RunningLogEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunningLogRVAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_log_item, parent, false)

        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: RunningLogRVAdapter.ViewHolder, position: Int) {
        holder.bindItems(logList[position])
    }

    override fun getItemCount(): Int {
        return logList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val logTitle = itemView.findViewById<TextView>(R.id.logRvTextArea)

        fun bindItems(runningLogEntity: RunningLogEntity) {
            logTitle.text = runningLogEntity.log
        }

    }

    fun setData(newLogList : ArrayList<RunningLogEntity>) {

        val difUtil = RVDiffUtil(logList, newLogList)
        val diffResults = DiffUtil.calculateDiff(difUtil)
        logList = newLogList
        diffResults.dispatchUpdatesTo(this)

    }

}