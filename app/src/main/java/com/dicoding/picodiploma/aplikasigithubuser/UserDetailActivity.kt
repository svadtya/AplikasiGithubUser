package com.dicoding.picodiploma.aplikasigithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class UserDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val imgAvatar: ImageView = findViewById(R.id.img_detail_avatar)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvUsername: TextView = findViewById(R.id.tv_detail_username)
        val tvCompany: TextView = findViewById(R.id.tv_detail_company)
        val tvLocation: TextView = findViewById(R.id.tv_detail_location)
        val tvFollowers: TextView = findViewById(R.id.tv_detail_followers)
        val tvFollowing: TextView = findViewById(R.id.tv_detail_following)
        val tvRepository: TextView = findViewById(R.id.tv_detail_repository)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        imgAvatar.setImageResource(user.avatar)
        tvName.text = user.name
        tvUsername.text = user.username
        tvCompany.text = user.company
        tvLocation.text = user.location
        tvFollowers.text = user.followers
        tvFollowing.text = user.following
        tvRepository.text = user.repository
    }
}