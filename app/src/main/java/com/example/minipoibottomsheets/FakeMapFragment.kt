package com.example.minipoibottomsheets

import PageAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.minipoibottomsheets.databinding.FragmentFakeMapBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class FakeMapFragment : Fragment() {

    private var _binding: FragmentFakeMapBinding? = null
    private val binding get() = _binding!!
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFakeMapBinding.inflate(inflater, container, false).apply {

            bottomSheetBehavior = BottomSheetBehavior.from(miniPoiSheet)

            bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    // Handle onslide
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                }
            })

            btnBottomSheetPersistent.setOnClickListener {
                when (bottomSheetBehavior.state) {
                    BottomSheetBehavior.STATE_COLLAPSED -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                    BottomSheetBehavior.STATE_EXPANDED -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
                    else -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            }


            // PageAdapter stuff
            val viewPager = poiViewpager
            viewPager.adapter = PageAdapter(childFragmentManager)

            val tabLayout = tabLayout
            tabLayout.setupWithViewPager(viewPager)

        }

        return binding.root
    }

}