package com.seumelhorcaminho.produtividade.estudos

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.NORMAL
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import com.seumelhorcaminho.produtividade.estudos.model.Email

class EmailAdapter(val emails: MutableList<Email>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun getItemCount(): Int = emails.size

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position])
    }

    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(email: Email) {
            with(email) {
                val hash = user.hashCode()
                itemView.findViewById<TextView>(R.id.textIcon).text = user.first().toString()
                itemView.findViewById<TextView>(R.id.textIcon).background =
                    itemView.oval(Color.rgb(hash, hash / 2, 1))
                itemView.findViewById<TextView>(R.id.textSubject).text = subject
                itemView.findViewById<TextView>(R.id.textPreview).text = prev
                itemView.findViewById<TextView>(R.id.textDate).text = date
                itemView.findViewById<TextView>(R.id.textUser).text = user

                itemView.findViewById<TextView>(R.id.textUser)
                    .setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)
                itemView.findViewById<TextView>(R.id.textSubject)
                    .setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)
                itemView.findViewById<TextView>(R.id.textPreview)
                    .setTypeface(Typeface.DEFAULT, if (unread) BOLD else NORMAL)

                itemView.findViewById<ImageView>(R.id.starMail).setImageResource(
                    if (star) android.R.drawable.btn_star_big_on
                    else android.R.drawable.star_off
                )

            }
        }
    }

    fun View.oval(@ColorInt color: Int): ShapeDrawable {
        val oval = ShapeDrawable(OvalShape())
        with(oval) {
            intrinsicHeight = height
            intrinsicWidth = width
            paint.color = color
        }
        return oval
    }

}