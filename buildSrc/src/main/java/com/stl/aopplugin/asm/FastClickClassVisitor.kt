package com.stl.aopplugin.asm

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class FastClickClassVisitor(classVisitor: ClassVisitor?) :
    ClassVisitor(Opcodes.ASM7, classVisitor) {
    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<String>?
    ) {
        super.visit(version, access, name, signature, superName, interfaces)
    }

    override fun visitField(
        access: Int,
        name: String?,
        descriptor: String?,
        signature: String?,
        value: Any?
    ): FieldVisitor? {
        return super.visitField(access, name, descriptor, signature, value)
    }

    override fun visitMethod(
        access: Int,
        name: String?,
        descriptor: String?,
        signature: String?,
        exceptions: Array<String>?
    ): MethodVisitor? {
        val methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
        return FastClickMethodVisitor(methodVisitor)
    }
}