package com.example.loveactuallymeandroidapp.ui.navUi

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.loveactuallymeandroidapp.BottomSheetFragment
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.ui.LikeYouActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val frag = inflater.inflate(R.layout.fragment_home, container, false)
        val filterButton = frag.findViewById<ImageView>(R.id.filter_img)
        filterButton.setOnClickListener {
            Toast.makeText(context, "Will Be implemented", Toast.LENGTH_SHORT).show()
        }
        val likeButton=frag.findViewById<ImageView>(R.id.like_img)
        likeButton.setOnClickListener {
            startActivity(Intent(context, LikeYouActivity::class.java))
        }
        return frag
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    //    override fun onResume() {
//        super.onResume()
//        nav_view.menu.findItem(R.id.home_menu).isChecked = true
//    }
    private fun switchBetweenFragments(fragment: Fragment) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.frag_container, fragment)
        fragmentTransaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction?.isAddToBackStackAllowed
        fragmentTransaction?.commit()
    }
}