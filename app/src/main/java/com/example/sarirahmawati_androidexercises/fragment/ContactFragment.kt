package com.example.sarirahmawati_androidexercises.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sarirahmawati_androidexercises.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ContactFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var contactArrayList: ArrayList<Contact>
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)


        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)

//        val contactList = listOf<Contact>(
//            Contact(
//                R.drawable.ic_whatsapp,
//                "08104715254"
//            ),
//            Contact(
//                R.drawable.ic_linkedin,
//                "Sari Rahmawati"
//            ),
//            Contact(
//                R.drawable.ic_instagram,
//                "sariram_"
//            )
//        )
//
//        recyclerView = view.findViewById<RecyclerView>(R.id.rv_contact)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.adapter = ContactAdapter( this, contactList) {
//
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_contact)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ContactAdapter(this, contactArrayList){}
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContactFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun dataInitialize() {

        contactArrayList = arrayListOf<Contact>(
            Contact(
                R.drawable.ic_whatsapp,
                "08104715254"
            ),
            Contact(
                R.drawable.ic_linkedin,
                "Sari Rahmawati"
            ),
            Contact(
                R.drawable.ic_instagram,
                "sariram_"
            )
        )
    }
}