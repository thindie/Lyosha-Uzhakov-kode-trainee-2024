package com.thindie.common

import com.thindie.common.di.CommonProvider
import com.thindie.database.LocalSourceProvider

interface DependenciesProvider : CommonProvider, LocalSourceProvider
