package br.com.heiderlopes.githubaac.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.heiderlopes.githubaac.R
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject
import dagger.android.support.HasSupportFragmentInjector
import android.support.v4.app.Fragment
import br.com.heiderlopes.githubaac.ui.userprofile.UserProfileFragment


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.configureDagger()
        this.showFragment(savedInstanceState)
    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {
        return dispatchingAndroidInjector
    }

    private fun showFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            val fragment = UserProfileFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, fragment, null)
                    .commit()
        }
    }

    private fun configureDagger() {
        AndroidInjection.inject(this)
    }
}
