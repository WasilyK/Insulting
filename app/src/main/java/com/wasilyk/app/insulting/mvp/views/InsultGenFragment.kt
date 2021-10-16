package com.wasilyk.app.insulting.mvp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.wasilyk.app.insulting.databinding.FragmentGenBinding
import com.wasilyk.app.insulting.di.factories.InsultGenPresenterFactory
import com.wasilyk.app.insulting.mvp.models.Insult
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class InsultGenFragment() : MoxyDaggerBaseFragment(), InsultGenView {

    private var viewBinding: FragmentGenBinding? = null
    @Inject lateinit var insultGenPresenterFactory: InsultGenPresenterFactory

    private val insultGenPresenter by moxyPresenter {
        insultGenPresenterFactory.create()
    }

    companion object {
        fun newInstance(): Fragment = InsultGenFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = FragmentGenBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding?.backBtn?.setOnClickListener {
            insultGenPresenter.startListGFragment()
        }
        viewBinding?.nextBtn?.setOnClickListener {
            insultGenPresenter.loadInsult()
        }
        viewBinding?.saveBtn?.setOnClickListener {
            insultGenPresenter.saveInsult()
        }
    }

    override fun setInsult(insult: Insult) {
        viewBinding?.insultTv?.text = insult.text
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}