package com.example.homework_1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_1.databinding.ElemItemBinding

class ElemAdapter: RecyclerView.Adapter<ElemAdapter.ElemHolder>() {
    var elemList = ArrayList<Elem>()
    class ElemHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ElemItemBinding.bind(item)
        fun bind(elem: Elem) = with(binding) {
            tv.text = elem.num.toString()
            tv.setBackgroundResource(elem.color)



            cv.setOnClickListener() {
                itemView.context.startActivity(MainActivity2.newInstance(itemView.context, elem.num, elem.color))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.elem_item, parent, false)
        return ElemHolder(view)
    }

    override fun getItemCount(): Int {
        return elemList.size
    }

    override fun onBindViewHolder(holder: ElemHolder, position: Int) {
        holder.bind(elemList[position])
    }

    fun addElem(elem: Elem) {
        elemList.add(elem)
        notifyDataSetChanged()
    }
}