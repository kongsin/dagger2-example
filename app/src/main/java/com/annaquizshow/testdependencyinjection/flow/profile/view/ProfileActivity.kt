package com.annaquizshow.testdependencyinjection.flow.profile.view

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.annaquizshow.testdependencyinjection.BaseActivity
import com.annaquizshow.testdependencyinjection.R
import com.annaquizshow.testdependencyinjection.UserProfileManager
import com.annaquizshow.testdependencyinjection.extensions.argument
import com.annaquizshow.testdependencyinjection.flow.profile.model.UserProfileModel
import com.annaquizshow.testdependencyinjection.flow.profile.viewmodel.UserProfileViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class ProfileActivity : BaseActivity(), UserProfileInterface {

    @Inject lateinit var userManager: UserProfileManager
    @Inject lateinit var profileViewModel: UserProfileViewModel

    private val userName by argument<String>("NAME")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show()
        text.text = userManager.name
        profileViewModel.injectView(this)
    }

    override fun onStart() {
        super.onStart()
        profileViewModel.getUserProfile().observe(this@ProfileActivity, Observer<List<UserProfileModel>> { info ->
            onLoadProfileFinish(info)
        })
    }

    override fun onLoadProfileFinish(model: List<UserProfileModel>) {
        text.text = "${model}"
        text.setTextColor(Color.BLUE)
    }

    override fun onLoadProfileError(message: String) {
        text.text = "Error : $message"
    }

    override fun onShowLoading() {

    }

    override fun onDismissLoading() {

    }

    override fun onDestroy() {
        super.onDestroy()
        profileViewModel.stop()
    }

}
