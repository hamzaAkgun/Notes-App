package com.example.notesapp.ui.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.Model.Notes
import com.example.notesapp.databinding.ItemNotesBinding
import com.example.notesapp.ui.Fragments.HomeFragmentDirections


class NotesAdapter(val requireContext: Context, var notesList: List<Notes>) :RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {


    @SuppressLint("NotifyDataSetChanged")
    fun filtering(newFilteredList:ArrayList<Notes>){
        notesList=newFilteredList
        notifyDataSetChanged()
    }

    class notesViewHolder(val binding : ItemNotesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {

        val data = notesList[position]
        holder.binding.notesTitle.text = notesList[position].title
        holder.binding.notesSubTitle.text = notesList[position].subTitle
        holder.binding.notesDate.text = notesList[position].date



        holder.binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(data)
            Navigation.findNavController(it).navigate(action)

        }


    }

    override fun getItemCount(): Int {
        return notesList.size
    }
}