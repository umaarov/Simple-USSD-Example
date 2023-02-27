package uz.umarov.simpleussdexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.umarov.simpleussdexample.R
import uz.umarov.simpleussdexample.databinding.FragmentSecondBinding
import uz.umarov.simpleussdexample.models.USSD_data

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSecondBinding.inflate(layoutInflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ussd = arguments?.getSerializable("a") as USSD_data

        binding.titleS.text = ussd.titleData
        binding.dataS.text = ussd.longData

    }

}