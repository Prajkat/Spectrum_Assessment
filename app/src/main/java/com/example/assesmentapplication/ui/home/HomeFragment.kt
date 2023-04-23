package com.example.assesmentapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.assesmentapplication.MainApplication
import com.example.assesmentapplication.databinding.HomeFragmentBinding
import com.example.assesmentapplication.di.component.DaggerFragmentComponent
import com.example.assesmentapplication.di.module.FragmentModule
import com.example.assesmentapplication.model.response.MovieInformation
import javax.inject.Inject

class HomeFragment : Fragment(), OnItemClickListener {

    private lateinit var binding: HomeFragmentBinding

    private lateinit var homeAdapter: HomeAdapter

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movieRecyclerView.apply {
            viewModel.movieList.observe(viewLifecycleOwner, {
                homeAdapter = HomeAdapter(it as MutableList<MovieInformation>, this@HomeFragment)
            })

            viewModel.errorMessage.observe(viewLifecycleOwner, {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
        }

    }

    private fun injectDependency() {
        val fragmentComponent = DaggerFragmentComponent
            .builder()
            .applicationComponent((activity?.application as MainApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()
        fragmentComponent.inject(this)
    }

    override fun onItemClicked(feeds: MovieInformation) {
        // TODO("Not yet implemented")
    }
}