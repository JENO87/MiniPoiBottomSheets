package com.example.minipoibottomsheets

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
                    when (newState) {
                        BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(context, "STATE_COLLAPSED", Toast.LENGTH_SHORT).show()
                        BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText(context, "STATE_EXPANDED", Toast.LENGTH_SHORT).show()
                        BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(context, "STATE_DRAGGING", Toast.LENGTH_SHORT).show()
                        BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(context, "STATE_SETTLING", Toast.LENGTH_SHORT).show()
                        BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(context, "STATE_HIDDEN", Toast.LENGTH_SHORT).show()
                        else -> Toast.makeText(context, "OTHER_STATE", Toast.LENGTH_SHORT).show()
                    }
                }
            })

            btnBottomSheetPersistent.setOnClickListener {
                if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                else
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }


        return binding.root
    }

}