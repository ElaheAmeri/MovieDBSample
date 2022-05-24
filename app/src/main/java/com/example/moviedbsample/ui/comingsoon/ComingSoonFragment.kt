package com.example.moviedbsample.ui.comingsoon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.moviedbsample.R
import com.example.moviedbsample.databinding.FragmentMovieListBinding
import com.example.moviedbsample.ui.movielist.MovieListViewModel


class ComingSoonFragment : Fragment() {

    val viewModel : ComingSoonViewModel by viewModels()
    lateinit var binding: FragmentMovieListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coming_soon, container, false)
    }

}