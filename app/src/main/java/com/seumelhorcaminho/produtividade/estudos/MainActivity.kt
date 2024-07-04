package com.seumelhorcaminho.produtividade.estudos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seumelhorcaminho.produtividade.estudos.databinding.ActivityMainBinding
import com.seumelhorcaminho.produtividade.estudos.model.email
import com.seumelhorcaminho.produtividade.estudos.model.fakeEmails
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    private lateinit var adapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = "LêMail"

        adapter = EmailAdapter(fakeEmails())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.fab.setOnClickListener {
            addEmail()
            binding.recyclerView.scrollToPosition(0)
        }

        // Configura o ItemTouchHelper
        var helper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                // Lógica para movimentação (arraste) dos itens
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition
                adapter.notifyItemMoved(from, to)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.emails.removeAt(viewHolder.adapterPosition)
                adapter.notifyItemRemoved(viewHolder.adapterPosition)
            }
        })

        // Anexa o ItemTouchHelper ao RecyclerView
        helper.attachToRecyclerView(binding.recyclerView)

    }


    private fun addEmail() {
        val users = arrayOf("YouTube", "Instagram", "Santander")
        val sub = arrayOf("Nova modalidade de ...", "Teste confirmado", "Uma nova funcionalidade")
        val preview = "Lorem Ipsum is simply dummy text of the printing and typesetting"
        val random = Random.nextInt(3)


        adapter.emails.add(0, email {
            unread = true
            user = users[random]
            subject = sub[random]
            prev = preview
        })
        adapter.notifyItemInserted(0)
    }


}