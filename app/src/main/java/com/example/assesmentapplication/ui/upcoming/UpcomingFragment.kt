package com.example.assesmentapplication.ui.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.assesmentapplication.MainApplication
import com.example.assesmentapplication.databinding.PopularFragmentBinding
import com.example.assesmentapplication.databinding.UpcomingFragmentBinding
import com.example.assesmentapplication.di.component.DaggerFragmentComponent
import com.example.assesmentapplication.di.module.FragmentModule
import com.example.assesmentapplication.model.response.MovieInformation
import com.example.assesmentapplication.ui.home.HomeAdapter
import com.example.assesmentapplication.ui.home.OnItemClickListener
import com.example.assesmentapplication.ui.popular.PopularViewModel
import javax.inject.Inject

class UpcomingFragment : Fragment(), OnItemClickListener{
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

        binding.upcomingRecyclerView.apply {
            viewModel.movieList.observe(viewLifecycleOwner, {
                homeAdapter = HomeAdapter(it as MutableList<MovieInformation>, this@UpcomingFragment)
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