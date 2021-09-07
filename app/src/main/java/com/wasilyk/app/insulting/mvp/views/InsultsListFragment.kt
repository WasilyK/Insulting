package com.wasilyk.app.insulting.mvp.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.Router
import com.wasilyk.app.insulting.databinding.FragmentListBinding
import com.wasilyk.app.insulting.mvp.presenters.InsultsListPresenter
import com.wasilyk.app.insulting.mvp.views.screens.Screens
import com.wasilyk.app.insulting.repository.local.LocalDataSource
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class InsultsListFragment : MoxyDaggerBaseFragment(), InsultsListView {

    @Inject lateinit var localDataSource: LocalDataSource
    @Inject lateinit var router: Router
    @Inject lateinit var screens: Screens

    private val insultsListPresenter: InsultsListPresenter by moxyPresenter {
        InsultsListPresenter(
            localDataSource,
            router,
            screens
        )
    }
    private var viewBinding: FragmentListBinding? = null
    private var insultsAdapter: InsultsListAdapter? = null

    companion object {
        fun newInstance(): Fragment = InsultsListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = FragmentListBinding.inflate(inflater, container, false)
        return viewBinding?.root as View
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding?.insultGenBtn?.setOnClickListener {
            insultsListPresenter.startGenFragment()
        }
    }

    override fun init() {
        insultsAdapter = InsultsListAdapter(insultsListPresenter.adapterPresenter)
        viewBinding?.recyclerView?.apply {
            this.adapter = insultsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateInsultsList() {
        insultsAdapter?.notifyDataSetChanged()
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}