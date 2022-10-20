package com.stl.aopplugin

import com.quinn.hunter.transform.HunterTransform
import com.stl.aopplugin.hunter.FastClickHunterWeaver
import org.gradle.api.Project


class AOPTransform(project: Project?) : HunterTransform(project) {
    init {
        bytecodeWeaver = FastClickHunterWeaver()
    }


}