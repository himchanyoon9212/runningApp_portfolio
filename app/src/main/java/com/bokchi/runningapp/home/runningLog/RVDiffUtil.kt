package com.bokchi.runningapp.home.runningLog

import androidx.recyclerview.widget.DiffUtil
import com.bokchi.runningapp.db.runnginLogDB.RunningLogEntity

class RVDiffUtil(
    private val oldList : List<RunningLogEntity>,
    private val newList : List<RunningLogEntity>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldItem == newItem
    }
}