package com.vu.androidbasicapp.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R
import com.vu.androidbasicapp.home.data.ResponseItem
import com.vu.androidbasicapp.home.ui.recyclerview.MyRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeScreenFragment : Fragment() {

    // to let the Android Jetpack libraries’ viewModels() function to create a lifecycle-aware viewmodel.
    private val viewModel: HomeScreenViewModel by viewModels()
    private lateinit var navigationFunctionLambda: (ResponseItem) -> Unit
    //
    private lateinit var recyclerViewAdapter: MyRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Pass the argument in the starting fragment
        navigationFunctionLambda = { findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToDashboardFragment(detail = it)) }
        recyclerViewAdapter = MyRecyclerViewAdapter(navigationFunction = navigationFunctionLambda)

        // LifecycleMode : Use lifecycleScope when you want coroutines to be tied to the lifecycle of an Activity or Fragment.
        // The coroutines are automatically canceled when the LifecycleOwner (Activity or Fragment) is destroyed.
        // launch: This is used for fire-and-forget coroutines where you don't need to return a result.
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                viewModel.greetingText.collect { greetingTextState ->
                    view.findViewById<TextView>(R.id.screenTitle).text = greetingTextState
                }
            }
        }
        // ensures that the collection starts when the lifecycle
        //reaches the STARTED state and stops when it falls below STARTED, automatically
        //restarting the collection each time the lifecycle returns to STARTED, which helps prevent
        //unnecessary updates and potential memory leaks.

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                viewModel.apiResponseObjects.collect { listOfResponseItems ->
                    recyclerViewAdapter.setData(listOfResponseItems)
                }
            }
        }

        //  get a view reference to the recyclerview and attach the adapter to it.
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = recyclerViewAdapter
    }
}