package com.annaquizshow.testdependencyinjection

import android.content.Intent
import android.os.Bundle
import com.annaquizshow.testdependencyinjection.flow.profile.view.ProfileActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var userManager: UserProfileManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userManager.saveUser(name = "Hello", age =  26)
        userManager.getUser()

        openProfileSettingFragment.setOnClickListener {
            //ProfileSettingFragment.newInstance().show(supportFragmentManager, "ProfileSettingFragment")
            startActivity(Intent(this, ProfileActivity::class.java).apply {
                putExtra("NAME", "Kongsing")
            })
        }

    }

}
