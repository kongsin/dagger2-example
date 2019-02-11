package com.annaquizshow.testdependencyinjection

import android.os.Bundle
import com.annaquizshow.testdependencyinjection.di.modules.Foo
import com.annaquizshow.testdependencyinjection.di.modules.Source
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var userManager: UserProfileManager

    @Inject
    lateinit var foo: Foo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userManager.saveUser(name = "Hello", age =  26)
        userManager.getUser()

        openProfileSettingFragment.setOnClickListener {
            ProfileSettingFragment.newInstance().show(supportFragmentManager, "ProfileSettingFragment")
        }

        foo.lists.onEach {
            text.text = text.text.toString() + it.nextT()
        }

    }

}
