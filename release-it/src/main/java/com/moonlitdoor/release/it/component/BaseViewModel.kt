package com.moonlitdoor.release.it.component

import androidx.lifecycle.ViewModel
import com.moonlitdoor.release.it.extension.ignore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

  private val job = Job()

  override val coroutineContext: CoroutineContext
    get() = Dispatchers.IO + job

  override fun onCleared() = job.cancel().ignore()

}