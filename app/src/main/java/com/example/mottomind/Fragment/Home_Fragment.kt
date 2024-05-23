package com.example.soulscript.Fragment

import Qoutes_moden
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mottomind.R
import com.example.mottomind.databinding.FragmentHomeBinding
import com.example.soulscript.Adapter.QuotesListAdapter

class Home_Fragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding // Use FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentHomeBinding.inflate(inflater, container, false) // Inflate the binding object

        val quotes = arrayOf(
            "A smile is happiness you'll find right under your nose...",
            "Because of your smile, you make life more beautiful...",
            "A smile is the best makeup any girl can wear...",
            "I am not getting better but at" + "Least I haven’t killed myself...",
            "“I’m constantly in awe of the work ethic of the human heart It keeps beating though it’s broken...”",
            "“But love has a way of revealing itself in the most explicit manner...",
            "Peril, loneliness, an uncertain future, are not oppressive...",
            "Music was my refuge. I could crawl into the space between...",
            "All I ever wanted was to reach out and touch another human being...",
            "I would rather sit on a pumpkin and have it all to myself, than be...",
            "I wish I could show you when you are lonely or in darkness...",
            "To live is the rarest thing in the world. Most people exist, that is all...",
            "That it will never come again is what makes life so sweet...",
            "Be kind, for everyone you meet is fighting a hard battle...",
            "Love is patient, love is kind. It does not envy, it does not boast...",
            "Have enough courage to trust love one more time and always one more time...",
            "A happy person is not a person in a certain set of circumstances...",
            "Anger is always more harmful than the insult that caused it...",
            "A fool gives full vent to his anger, but a wise man keeps himself under control...",
            "We can shoot rockets into space but we can’t cure anger or discontent...",
            "Read, read, read. Read everything – trash, classics, good and bad...",
            "A good writer possesses not only his own spirit but also...",
            " Anger makes you smaller, while forgiveness forces you to grow beyond what you were...",            // Add more quotes
        )
        val authorName = arrayOf(
            "―Lee Ar",
            "―Eleanor R",
            "―C.T. Banks",
            "―Kierra C.T.",
            "―Jonathan",
            "―Araali Ewya ",
            "―S.killer",
            "―Positively ",
            "―Shar Isenia",
            "―Dr Aman ",
            "―bekerman",
            "―Sabrina ",
            "―Hassanwainx",
            "―Stamenkovic",
            "―Napz Cherub",
            "―Dax Bamania",
            "―Shiva Negi",
            "―Marie Curie",
            "―Gordon B",
            "―Ralph  ",
            "―Johnny ",
            "―Laurie R",
            "―Ackerman"            // Add more authors
        )

        val quotesList = ArrayList<Qoutes_moden>()

        for (i in quotes.indices) {
            val quote = Qoutes_moden(quotes[i], authorName[i], "Author 1", false) // Correct parameter order
            quotesList.add(quote)
        }

        val quotesListAdapter =
            QuotesListAdapter(requireContext(), quotesList) // Use requireContext() instead of this
        val layoutManager = GridLayoutManager(requireContext(), 1)
        binding.risi1.adapter = quotesListAdapter
        binding.risi1.layoutManager = layoutManager

        binding.imgMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.navigationDrawer.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.mHome -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.mSettings -> {
                    Toast.makeText(requireContext(), "Settings", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.mCall -> {
                    Toast.makeText(requireContext(), "Call", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.mGroup -> {
                    Toast.makeText(requireContext(), "Group", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }

        return binding.root // Return the root view of the binding object

    }
}