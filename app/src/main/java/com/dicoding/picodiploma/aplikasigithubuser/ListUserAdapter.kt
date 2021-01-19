package com.dicoding.picodiploma.aplikasigithubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListUserAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var onItemCallback: OnItemCallback

    fun setOnItemCallback(onItemCallback: OnItemCallback) {
        this.onItemCallback = onItemCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]

        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgAvatar)

        holder.tvName.text = user.name
        holder.tvUsername.text = user.username

        holder.itemView.setOnClickListener() {
            onItemCallback.onItemClick(listUser[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    interface OnItemCallback {
        fun onItemClick(data: User)
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_list_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_list_username)
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_list_avatar)
    }
}