package uz.umarov.simpleussdexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.umarov.simpleussdexample.R
import uz.umarov.simpleussdexample.adapters.RvAdapter
import uz.umarov.simpleussdexample.databinding.FragmentFirstBinding
import uz.umarov.simpleussdexample.models.USSD_data

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    lateinit var rvAdapter: RvAdapter
    lateinit var data: ArrayList<USSD_data>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        loadData()
        return binding.root
    }

    private fun loadData() {

        data = ArrayList()

        for (i in 0 until 100) {
            data.add(
                USSD_data(
                    "Mobi 20",
                    "*103#",
                    "20.000 so'm",
                    "Mobi 20"
                )
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvAdapter = RvAdapter(data, object : RvAdapter.OnItemClickListener {
            override fun onItemClick(data: USSD_data, position: Int) {

                val bundle = Bundle()

                bundle.putSerializable("a", data)

                findNavController().navigate(R.id.secondFragment, bundle)

            }
        })


        binding.rv.adapter = rvAdapter

    }

}