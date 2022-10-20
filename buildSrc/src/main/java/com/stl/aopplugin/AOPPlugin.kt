package com.stl.aopplugin

import com.android.build.gradle.AppExtension
import com.stl.aopplugin.AOPTransform
import org.gradle.api.Plugin
import org.gradle.api.Project

class AOPPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val appExtension = project.extensions.getByName("android") as AppExtension
        appExtension.registerTransform(AOPTransform(project))
    }
}