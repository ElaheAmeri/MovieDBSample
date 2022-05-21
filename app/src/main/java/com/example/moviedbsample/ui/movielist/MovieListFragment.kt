package com.example.moviedbsample.ui.movielist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.moviedbsample.R
import com.example.moviedbsample.databinding.FragmentMovieListBinding
import com.example.moviedbsample.ui.adapter.MovieAdapter


class MovieListFragment : Fragment() {
    val viewModel : MovieListViewModel by viewModels()
    lateinit var binding: FragmentMovieListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_movie_list,container,false)
        binding.vmodel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter=MovieAdapter({})
        binding.rvMovieList.adapter=adapter
        viewModel.movieList.observe(viewLifecycleOwner){adapter.submitList(it)}

    }
}