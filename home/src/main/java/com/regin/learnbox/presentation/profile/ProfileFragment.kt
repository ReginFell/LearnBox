package com.regin.learnbox.presentation.profile

import com.regin.learnbox.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class ProfileFragment : BaseFragment<ProfileViewModel>() {

    override val viewModel: ProfileViewModel by inject()

}