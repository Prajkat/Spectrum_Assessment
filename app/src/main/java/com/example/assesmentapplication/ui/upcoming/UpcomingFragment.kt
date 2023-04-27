package com.example.assesmentapplication.ui.upcoming

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.assesmentapplication.MainApplication
import com.example.assesmentapplication.databinding.UpcomingFragmentBinding
import com.example.assesmentapplication.di.component.DaggerFragmentComponent
import com.example.assesmentapplication.di.module.FragmentModule
import com.example.assesmentapplication.model.response.nowplaying.Result
import com.example.assesmentapplication.ui.home.HomeAdapter
import com.example.assesmentapplication.ui.home.OnItemClickListener
import com.example.assesmentapplication.ui.moviedetails.MovieDetailsActivity
import com.example.assesmentapplication.ui.popular.PopularViewModel
import java.io.Serializable
import javax.inject.Inject

class UpcomingFragment : Fragment(), OnItemClickListener {
    private lateinit var binding: UpcomingFragmentBinding

    private lateinit var homeAdapter: HomeAdapter

    @Inject
    lateinit var viewModel: PopularViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UpcomingFragmentBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loading.observe(viewLifecycleOwner, {
            if (it == true) {
                binding.progressView.visibility = View.VISIBLE
            } else {
                binding.progressView.visibility = View.GONE
            }
        })

        viewModel.movieList.observe(viewLifecycleOwner, {
            homeAdapter = HomeAdapter(it.results, this)
            binding.upcomingRecyclerView.adapter = homeAdapter
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, {
            binding.errorTextView.visibility = View.VISIBLE
        })
    }

    private fun injectDependency() {
        val fragmentComponent = DaggerFragmentComponent
            .builder()
            .applicationComponent((activity?.application as MainApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()
        fragmentComponent.inject(this)
    }

    override fun onItemClicked(movieDetails: Result) {
        val intent = Intent(requireContext(), MovieDetailsActivity::class.java)
        intent.putExtra("studentData", movieDetails as Serializable)
        startActivity(intent)
    }
}