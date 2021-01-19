package com.dicoding.picodiploma.aplikasigithubuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvUser: RecyclerView
    private lateinit var listUserAdapter: ListUserAdapter
    private var dataUser = arrayListOf<User>()

    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataAvatar: TypedArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        prepare()
        addItem()
        listUserAdapter = ListUserAdapter(dataUser)
        showRecyclerList()
    }

    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem() {
        for (position in dataUsername.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position],
                dataAvatar.getResourceId(position, -1)
            )
            dataUser.add(user)
        }
    }

    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemCallback(object: ListUserAdapter.OnItemCallback {
            override fun onItemClick(data: User) {
                val userDetailIntent = Intent(this@MainActivity, UserDetailActivity::class.java)
                userDetailIntent.putExtra(UserDetailActivity.EXTRA_USER, data)
                startActivity(userDetailIntent)
            }
        })
    }
}