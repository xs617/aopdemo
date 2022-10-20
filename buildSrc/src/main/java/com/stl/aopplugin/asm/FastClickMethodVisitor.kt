package com.stl.aopplugin.asm

import org.objectweb.asm.AnnotationVisitor
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

class FastClickMethodVisitor(methodVisitor: MethodVisitor?) :
    MethodVisitor(Opcodes.ASM7, methodVisitor) {
    var isCheckFastClick = false
    override fun visitAnnotation(descriptor: String, visible: Boolean): AnnotationVisitor {
//        System.out.println("visitAnnotation() ----- ------  " + descriptor );
        isCheckFastClick = "Lcom/stl/aopplugin/announce/FastClick;" == descriptor
        return super.visitAnnotation(descriptor, visible)
    }

    override fun visitCode() {
        if (isCheckFastClick) {
            super.visitCode()
            println("visitCode() ----- isCheckFastClick ")
            this.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "com/stl/aopplugin/announce/FastClickUtil",
                "isFastClick",
                "()Z",
                false
            )
            val label1 = Label()
            visitJumpInsn(Opcodes.IFEQ, label1)
            visitInsn(Opcodes.RETURN)
            visitLabel(label1)
            super.visitCode()
        } else {
            super.visitCode()
        }
    }
}