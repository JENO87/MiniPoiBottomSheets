package com.example.minipoibottomsheets

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.minipoibottomsheets.databinding.MiniPoiModalBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MiniPoiDialogFragment : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "MiniPoiDialogFragment"
    }

    private var _binding: MiniPoiModalBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = MiniPoiModalBottomSheetBinding.inflate(inflater, container, false).apply {

/*            context?.let {
                Glide.with(it)
                    .load("https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2F4%2F4f%2FLunds_domkyrka%25E2%2580%2593flygbild_06_september_2014.jpg&imgrefurl=https%3A%2F%2Fsv.wikipedia.org%2Fwiki%2FLunds_domkyrka&tbnid=eg1hBV2ThZ_CBM&vet=12ahUKEwjz7r6ag4rxAhXMzioKHemFAXsQMygAegUIARCvAQ..i&docid=Ber0V9xoND0Y6M&w=3444&h=2394&q=lunds%20domkyrka&ved=2ahUKEwjz7r6ag4rxAhXMzioKHemFAXsQMygAegUIARCvAQ")
                    .into(miniPoiImage)
            }*/

            poiInfoName.text = "Lunds Domkyrka"
            poiInfoTypeAndDistance.text = "Place of Worship, 10 min"
            poiInfoOpeningHours.text = "Open now"

        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.miniPoiImage.setOnClickListener {
            Toast.makeText(context, "Image Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
