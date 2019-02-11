package com.annaquizshow.testdependencyinjection


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

class ProfileSettingFragment : BaseFragment() {

    @Inject
    lateinit var userManager: UserProfileManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userManager.getUser()
        userManager.saveUser(name = "Hello from fragment", age = 20)
        userManager.getUser()
    }

    companion object {
        fun newInstance() = ProfileSettingFragment()
    }
}
