package com.wasilyk.app.insulting.mvp.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.wasilyk.app.insulting.app.App
import com.wasilyk.app.insulting.databinding.FragmentListBinding
import com.wasilyk.app.insulting.mvp.presenters.InsultsListPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class InsultsListFragment : MvpAppCompatFragment(), InsultsListView {

    private val insultsListPresenter: InsultsListPresenter by moxyPresenter {
        App.instance.appComponent.getInsultsListPresenter()
    }
    private lateinit var viewBinding: FragmentListBinding
    private lateinit var insultsAdapter: InsultsListAdapter

    companion object {
        fun newInstance(): Fragment = InsultsListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = FragmentListBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.insultGenBtn.setOnClickListener {
            insultsListPresenter.startGenFragment()
        }
    }

    override fun init() {
        insultsAdapter = InsultsListAdapter(insultsListPresenter.adapterPresenter)
        viewBinding.recyclerView.apply {
            this.adapter = insultsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateInsultsList() {
        insultsAdapter.notifyDataSetChanged()
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}