package com.stl.aopplugin.hunter

import com.quinn.hunter.transform.asm.BaseWeaver
import com.stl.aopplugin.asm.FastClickClassVisitor
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter

class FastClickHunterWeaver : BaseWeaver() {
    override fun wrapClassWriter(classWriter: ClassWriter?): ClassVisitor {
        return FastClickClassVisitor(classWriter)
    }
}