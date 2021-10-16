package com.wasilyk.app.insulting.mvp.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wasilyk.app.insulting.databinding.ItemViewBinding
import com.wasilyk.app.insulting.mvp.models.Insult
import com.wasilyk.app.insulting.mvp.presenters.InsultsListAdapterPresenter

class InsultsListAdapter(private val adapterPresenter: InsultsListAdapterPresenter) :
    RecyclerView.Adapter<InsultsListAdapter.ViewHolder>() {

    inner class ViewHolder(private val viewBinding: ItemViewBinding) :
        RecyclerView.ViewHolder(viewBinding.root), ItemView {

        override fun setInsults(insult: Insult) {
            viewBinding.insultTv.apply {
                text = insult.text
            }
        }

        override var pos: Int = -1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        adapterPresenter.bindView(holder.apply {
            pos = position
        })

    override fun getItemCount() = adapterPresenter.getCount()
}